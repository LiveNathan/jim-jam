package nathanlively.dev.jimjam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {


//    @Bean
//    IpClient ipClient() {
//        WebClient client = WebClient.builder()
//                .baseUrl("https://api.ipgeolocation.io/timezone?apiKey=" + apiKey)
//                .build();
//
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(client))
//                .blockTimeout(Duration.ofSeconds(7))
//                .build();
//
//        return factory.createClient(IpClient.class);
//    }
//
//    @Bean
//    AstronomyClient astronomyClient() {
//        WebClient client = WebClient.builder()
//                .baseUrl("https://api.ipgeolocation.io/astronomy?apiKey=" + apiKey)
//                .build();
//
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(client))
//                .blockTimeout(Duration.ofSeconds(7))
//                .build();
//
//        return factory.createClient(AstronomyClient.class);
//    }
//
//    @Bean
//    WeatherClient weatherClient() {
//        WebClient client = WebClient.builder()
//                .baseUrl("https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&appid=" + weatherKey)
//                .build();
//
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(client))
//                .blockTimeout(Duration.ofSeconds(7))
//                .build();
//
//        return factory.createClient(WeatherClient.class);
//    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://api.openweathermap.org")
                .build();
    }

}
