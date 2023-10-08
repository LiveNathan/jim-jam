package nathanlively.dev.jimjam.weather;

import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherClient {
    @GetExchange
    Mono<WeatherResponse> getWeather(float lat, float lon);
}
