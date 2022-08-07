package com.linkshortservice.linkshortservice;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

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

    public String generateShortUrl(String url, String shortUrl) throws InputUrlErrorException {
        if(!UrlClass.urlIsValid(url)) {
            System.out.println("{ \"res\": \"false\", \"message\": \"Url is not good\" }");
            return "{ \"res\": \"false\", \"message\": \"Url is not good\" }";
        }

        UrlClass urlObject = new UrlClass(url); 
        UrlClass entity;

        if (!Strings.isNullOrEmpty(shortUrl)){
            // => Требуется не случайная ссылка
            if (!Strings.isNullOrEmpty(urlRepository.findByShortUrl(shortUrl))){
                // Если ссылка используется то сообщаем об этом
                System.out.println("Short Url is used");
                return "{ \"res\": \"false\", \"message\": \"Short Url is used\" }";
            }

            entity = urlRepository.save(urlObject);
        } else {
            entity = urlRepository.save(urlObject);
            shortUrl = ShortenerClass.idToShortUrl(entity.getUrlId());
        }

        urlRepository.setShortUrlById(shortUrl, entity.getUrlId());
        return "{ \"res\": \"true\", \"message\": \"" + shortUrl + "\" }";
    }
}
