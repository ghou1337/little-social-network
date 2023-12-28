package pl.social.frontend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.social.frontend.demo.model.Post;
import pl.social.frontend.demo.service.PostService;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collector;

@Controller
public class MainPageController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PostService postService;
    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("");
        return "main-page";
    }
}
