package pl.social.frontend.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Value(value = "${rest.uri}")
    private String uri;
}
