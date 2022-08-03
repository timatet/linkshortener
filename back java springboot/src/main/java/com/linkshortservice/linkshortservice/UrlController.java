package com.linkshortservice.linkshortservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UrlController {
    @Autowired
    private  UrlService urlService;

    @GetMapping("/")
    @ResponseBody
    public String defaultPage() {
        return "Welcome";
    }

    @GetMapping("/{shortUrl}")
    @ResponseBody
    public RedirectView getOriglUrl(@PathVariable("shortUrl") String shortUrl) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.getOriginlUrl(shortUrl));
        return redirectView;
        //return urlService.getOriginlUrl(shortUrl);
    }

    @GetMapping("/geturl/{origUrl}")
    @ResponseBody
    public String getShortUrl(@PathVariable("origUrl") String origUrl) {
        return origUrl;
    }

    @PostMapping
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }

}