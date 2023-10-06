package nathanlively.dev.jimjam;

import lombok.RequiredArgsConstructor;
import nathanlively.dev.jimjam.ip.IpClient;
import nathanlively.dev.jimjam.ip.IpGeoLocationResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final IpClient ipClient;

    @GetMapping
    public String index(Model model) {

        Mono<IpGeoLocationResponse> ipGeoLocationResponseFlux = ipClient.getTimezone();
        model.addAttribute("ipGeoTime", ipGeoLocationResponseFlux.block());

        return "index";
    }
}
