package nathanlively.dev.jimjam;

import lombok.RequiredArgsConstructor;
import nathanlively.dev.jimjam.ip.astronomy.AstronomyResponse;
import nathanlively.dev.jimjam.ip.IpGeoLocationService;
import nathanlively.dev.jimjam.weather.WeatherResponse;
import nathanlively.dev.jimjam.weather.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final IpGeoLocationService ipGeoLocationService;
    private final WeatherService weatherService;

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

}
