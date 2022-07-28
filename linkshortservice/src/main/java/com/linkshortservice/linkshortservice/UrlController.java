package com.linkshortservice.linkshortservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class UrlController {
    @Autowired
    private  UrlService urlService;

    @GetMapping("/{shortUrl}")
    public RedirectView getOriglUrl(@PathVariable("shortUrl") String shortUrl) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.getOriginlUrl(shortUrl));
        return redirectView;
        //return urlService.getOriginlUrl(shortUrl);
    }

    @PostMapping
    public String generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }

}