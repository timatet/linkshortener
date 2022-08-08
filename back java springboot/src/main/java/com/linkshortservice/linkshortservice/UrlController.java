package com.linkshortservice.linkshortservice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.view.RedirectView;

//import com.google.common.base.Strings;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class UrlController {
    @Autowired
    private  UrlService urlService;

    @PostMapping
    public String generateShortUrl(@RequestBody String url) throws ParseException {
        Object obj = new JSONParser().parse(url);
        JSONObject jo = (JSONObject)obj;
        String origUrl = (String)jo.get("origUrl"); 
        String shortUrl = (String)jo.get("shortUrl"); 

        return urlService.generateShortUrl(origUrl, shortUrl);     
    }

    @GetMapping("/{shortUrl}")
    @ResponseBody
    public String getOriglUrl(@PathVariable("shortUrl") String shortUrl) {
        //RedirectView redirectView = new RedirectView();
        var origUrl = urlService.getOriginlUrl(shortUrl);
        //redirectView.setUrl(origUrl);
        return "{ \"message\": \"" + origUrl + "\" }";
    }
}