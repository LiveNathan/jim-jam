package nathanlively.dev.jimjam.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    @Value("${weather.apikey}")
    private String weatherKey;

    public WeatherService(@Value("${weather.apikey}") String weatherKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openweathermap.org/data/3.0/onecall")
                .build();
    }

    public Mono<WeatherResponse> getWeather(float lat, float lon) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("exclude", "minutely,hourly")
                        .queryParam("units", "imperial")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("appid", weatherKey)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class);
    }
}

