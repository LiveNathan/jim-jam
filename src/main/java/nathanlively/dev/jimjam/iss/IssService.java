package nathanlively.dev.jimjam.iss;

import nathanlively.dev.jimjam.ip.astronomy.AstronomyResponse;
import nathanlively.dev.jimjam.ip.location.IpGeoLocationResponse;
import nathanlively.dev.jimjam.iss.location.IssLocationResponse;
import nathanlively.dev.jimjam.iss.pop.IssPopResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IssService {

    private final WebClient webClient;

    public IssService() {
        this.webClient = WebClient.builder()
                .baseUrl("http://api.open-notify.org")
                .build();
    }

    public Mono<IssLocationResponse> getLocation() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/iss-now.json")
                        .build())
                .retrieve()
                .bodyToMono(IssLocationResponse.class);
    }

    public Mono<IssPopResponse> getPopulation() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/astros.json")
                        .build())
                .retrieve()
                .bodyToMono(IssPopResponse.class);
    }
}

