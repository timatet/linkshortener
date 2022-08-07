package com.linkshortservice.linkshortservice.controler;

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

import com.linkshortservice.linkshortservice.service.UrlService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/")
public class UrlController {
    @Autowired
    private  UrlService urlService;

    @GetMapping("/{shortUrl}")
    @ResponseBody
    public RedirectView getOriglUrl(@PathVariable("shortUrl") String shortUrl) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.getOriginlUrl(shortUrl));
        return redirectView;
        //return urlService.getOriginlUrl(shortUrl);
    }

    @PostMapping
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String generateShortUrl(@RequestBody String url) throws ParseException {
        Object obj = new JSONParser().parse(url);
        JSONObject jo = (JSONObject)obj;
        String origUrl = (String)jo.get("origUrl"); 
        return urlService.generateShortUrl(origUrl);
    }
}