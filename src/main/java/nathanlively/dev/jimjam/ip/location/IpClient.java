package nathanlively.dev.jimjam.ip.location;

import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface IpClient {
    @GetExchange
    Mono<IpGeoLocationResponse> getTimezone();
}
