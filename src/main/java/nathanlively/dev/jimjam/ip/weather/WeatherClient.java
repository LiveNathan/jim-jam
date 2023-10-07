package nathanlively.dev.jimjam.ip.weather;

import nathanlively.dev.jimjam.ip.location.IpGeoLocationResponse;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherClient {
    @GetExchange
    Mono<WeatherResponse> getWeather(float lat, float lon);
}
