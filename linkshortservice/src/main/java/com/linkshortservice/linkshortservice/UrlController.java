package com.linkshortservice.linkshortservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class UrlController {

    @GetMapping("/{urlId}")
    public String getOriglUrl(@PathVariable int urlId) {
        return ShortenerClass.idToShortUrl(urlId);
    }

    @PostMapping
    public int generateShortUrl(@RequestBody String url) {
        return ShortenerClass.shortUrltoId(url);
    }

}