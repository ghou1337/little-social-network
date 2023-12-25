package pl.social.frontend.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import pl.social.frontend.demo.model.Post;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collector;

@Controller
public class MainPageController {

    private final WebClient wedClient;

    public MainPageController(WebClient.Builder webClientBuilder) {
        this.wedClient = webClientBuilder.baseUrl("http://localhost:8082/api").build();
    }


    @GetMapping("/main")
    public String mainPage(Model model) {
        Flux<Post> postsFLux = wedClient.get().uri("/get-posts").retrieve().bodyToFlux(Post.class);
        model.addAttribute("posts", postsFLux);
        return "main-page";
    }
}
