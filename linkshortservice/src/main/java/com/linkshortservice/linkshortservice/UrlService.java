package com.linkshortservice.linkshortservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;


    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public UrlClass generateShortUrl(String url) {
        if(!UrlClass.urlIsValid(url)) {
            System.out.println("Url is not good");
            return null;
        }

        UrlClass urlObject = new UrlClass(url); //пока только с случайным вариантом

        return urlRepository.save(urlObject);
    }
}
