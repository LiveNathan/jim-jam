package nathanlively.dev.jimjam;

import lombok.RequiredArgsConstructor;
import nathanlively.dev.jimjam.ip.astronomy.AstronomyClient;
import nathanlively.dev.jimjam.ip.astronomy.AstronomyResponse;
import nathanlively.dev.jimjam.ip.location.IpClient;
import nathanlively.dev.jimjam.ip.location.IpGeoLocationResponse;
import nathanlively.dev.jimjam.ip.weather.WeatherClient;
import nathanlively.dev.jimjam.ip.weather.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final IpClient ipClient;
    private final AstronomyClient astronomyClient;
    private final WeatherClient weatherClient;

    @GetMapping
    public String index(Model model) {

        Mono<AstronomyResponse> astronomyResponseMono = astronomyClient.getAstronomy();

        Mono<WeatherResponse> weatherResponseMono = astronomyResponseMono.flatMap(astronomyResponse -> {
            float lat = astronomyResponse.location().latitude() ;
            float lon = astronomyResponse.location().longitude();

            return weatherClient.getWeather(lat, lon);
        });

        Mono.zip(astronomyResponseMono, weatherResponseMono)
                .doOnNext(t -> {
                    model.addAttribute("astronomy", t.getT1());
                    model.addAttribute("weather", t.getT2());
                })
                .block();

        return "index";
    }

    private Mono<WeatherResponse> getWeather(WebClient client, float lat, float lon) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("lat", String.valueOf(lat));
        uriVariables.put("lon", String.valueOf(lon));

        return client.get()
                .uri(uriBuilder -> uriBuilder.build(uriVariables))
                .retrieve()
                .bodyToMono(WeatherResponse.class);
    }

//    @GetMapping
//    public String weather(Model model) {
//
//        Mono<WeatherResponse> weatherResponseMono = weatherClient.getWeather(lat, lon);
//        model.addAttribute("weather", weatherResponseMono.block());
//
//        return "weather";
//    }
}
