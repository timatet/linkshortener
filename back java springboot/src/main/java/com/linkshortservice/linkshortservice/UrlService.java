package com.linkshortservice.linkshortservice;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;


    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public String getOriginalUrl(String shortUrl) {
        var id = ShortenerClass.shortUrltoId(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        return entity.getOrigUrl();
    }

    public String generateShortUrl(String url) {
        if(!UrlClass.urlIsValid(url)) {
            System.out.println("Url is not good");
            return null;
        }

        UrlClass urlObject = new UrlClass(url); 
        var entity = urlRepository.save(urlObject);
        var shortUrl = ShortenerClass.idToShortUrl(entity.getUrlId());
        urlRepository.setShortUrlById(shortUrl, entity.getUrlId());

        return shortUrl;
    }
}
