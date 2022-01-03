package pulson.kanye_vs_drake_frontend.DondaAOTY;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class KanyeVsDrakeController {

    @GetMapping("/get-both")
    public String getBothAlbums(Model model) {
        model.addAttribute("KanyeSongs", getKanyeSongs());
        model.addAttribute("DrakeSongs", getDrakeSongs());
        return "KanyeVsDrake";
    }

    //docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container_name_or_id
    private List<Song> getKanyeSongs(){
        WebClient client = WebClient.create("http://localhost:8081");
        Mono<List<Song>> response = client.get().uri("/donda")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<Song>>() {});
        return response.block();
    }
    private List<Song> getDrakeSongs(){
        WebClient client = WebClient.create("http://localhost:8082");
        Mono<List<Song>> response = client.get().uri("/clb")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<Song>>() {});
        return response.block();
    }
}
