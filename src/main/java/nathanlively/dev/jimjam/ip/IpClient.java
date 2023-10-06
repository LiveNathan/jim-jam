package nathanlively.dev.jimjam.ip;

import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IpClient {
    @GetExchange
    Mono<IpGeoLocationResponse> getTimezone();
}
