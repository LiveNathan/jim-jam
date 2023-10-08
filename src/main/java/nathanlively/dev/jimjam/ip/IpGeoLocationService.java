package nathanlively.dev.jimjam.ip;

import nathanlively.dev.jimjam.ip.astronomy.AstronomyResponse;
import nathanlively.dev.jimjam.ip.location.IpGeoLocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IpGeoLocationService {

    private final WebClient webClient;

    @Value("${ipgeolocation.apikey}")
    private String apiKey;;

    public IpGeoLocationService(@Value("${weather.apikey}") String weatherKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.ipgeolocation.io")
                .build();
    }

    public Mono<IpGeoLocationResponse> getLocation() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/timezone")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(IpGeoLocationResponse.class);
    }

    public Mono<AstronomyResponse> getAstronomy() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/astronomy")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(AstronomyResponse.class);
    }
}

