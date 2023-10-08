package nathanlively.dev.jimjam.ip.astronomy;

import nathanlively.dev.jimjam.ip.location.IpGeoLocationResponse;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface AstronomyClient {
    @GetExchange
    Mono<AstronomyResponse> getAstronomy();
}
