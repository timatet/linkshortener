package com.linkshortservice.linkshortservice;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private  UrlService urlService;

    @GetMapping("/{shortUrl}")
    public String getOriglUrl(@PathVariable("shortUrl") String shortUrl) {
        return urlService.getOriginlUrl(shortUrl);
    }

    @PostMapping
    public String generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }

}