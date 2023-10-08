package nathanlively.dev.jimjam;

import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nathanlively.dev.jimjam.ip.astronomy.AstronomyResponse;
import nathanlively.dev.jimjam.ip.IpGeoLocationService;
import nathanlively.dev.jimjam.iss.IssService;
import nathanlively.dev.jimjam.iss.location.IssLocationResponse;
import nathanlively.dev.jimjam.iss.pop.IssPopResponse;
import nathanlively.dev.jimjam.weather.WeatherResponse;
import nathanlively.dev.jimjam.weather.WeatherService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import java.time.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Log4j2
public class HomeController {

    private final IpGeoLocationService ipGeoLocationService;
    private final WeatherService weatherService;
    private final IssService issService;

    @GetMapping
    public String index(Model model) {
        Mono<AstronomyResponse> astronomyResponseMono = ipGeoLocationService.getAstronomy();

        Mono<WeatherResponse> weatherResponseMono = astronomyResponseMono.flatMap(astronomyResponse -> {
            float lat = astronomyResponse.location().latitude();
            float lon = astronomyResponse.location().longitude();

            return weatherService.getWeather(lat, lon);
        });

        Mono.zip(astronomyResponseMono, weatherResponseMono)
                .doOnNext(t -> {
                    model.addAttribute("astronomy", t.getT1());
                    model.addAttribute("weather", t.getT2());
                })
                .block();

        return "index";
    }

    @HxRequest
    @GetMapping("iss-location")
    public String issLocation(Model model) {
        Mono<IssLocationResponse> issLocationResponseMono = issService.getLocation();
        model.addAttribute("issLocation", issLocationResponseMono.block());
        return "fragments :: issLocation";
    }

    @HxRequest
    @GetMapping("iss-population")
    public String issPopulation(Model model) {
        Mono<IssPopResponse> issPopResponseMono = issService.getPopulation();
        model.addAttribute("issPop", issPopResponseMono.block());
        return "fragments :: issPopulation";
    }

    @HxRequest
    @GetMapping("hobis")
    public String hobis(Model model) {

        List<String> quotes = new ArrayList<>();

        try {
            Resource resource = new ClassPathResource("static/Hobis says.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;
            StringBuilder quoteBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(" ")) {
                    if (!quoteBuilder.isEmpty()) {
                        quotes.add(quoteBuilder.toString());
                        quoteBuilder.setLength(0);
                    }
                    quoteBuilder.append(line);
                } else {
                    quoteBuilder.append("\n").append(line.trim());
                }
            }

            if (!quoteBuilder.isEmpty()) {
                quotes.add(quoteBuilder.toString());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        LocalDate today = LocalDate.now();
        Random seed = new Random(today.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli());

        int index = seed.nextInt(quotes.size());
        model.addAttribute("quote", quotes.get(index));

        return "fragments :: hobis";
    }

}
