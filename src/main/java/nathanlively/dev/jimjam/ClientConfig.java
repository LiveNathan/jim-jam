package nathanlively.dev.jimjam;

import nathanlively.dev.jimjam.ip.astronomy.AstronomyClient;
import nathanlively.dev.jimjam.ip.location.IpClient;
import nathanlively.dev.jimjam.ip.weather.WeatherClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class ClientConfig {

    @Value("${ipgeolocation.apikey}")
    private String apiKey;

    @Value("${weather.apikey}")
    private String weatherKey;



    @Bean
    IpClient ipClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.ipgeolocation.io/timezone?apiKey=" + apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.ofSeconds(7))
                .build();

        return factory.createClient(IpClient.class);
    }

    @Bean
    AstronomyClient astronomyClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.ipgeolocation.io/astronomy?apiKey=" + apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.ofSeconds(7))
                .build();

        return factory.createClient(AstronomyClient.class);
    }

    @Bean
    WeatherClient weatherClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid=" + weatherKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.ofSeconds(7))
                .build();

        return factory.createClient(WeatherClient.class);
    }


}
