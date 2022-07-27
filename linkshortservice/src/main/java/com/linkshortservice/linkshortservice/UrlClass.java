package com.linkshortservice.linkshortservice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlClass {
    @Id
    private int urlId; //id короткой ссылки
    private String shortUrl;
    private String origUrl;

    public int getUrlId() {
        return urlId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getOrigUrl() {
        return origUrl;
    }

    public UrlClass(String origUrl) {
        this.origUrl = origUrl;

        this.urlId = 12345; //надо заставить генерировать новый !неповторяющийся
        this.shortUrl = ShortenerClass.idToShortUrl(urlId);
    }

    public UrlClass(String origUrl, String shortUrl) {
        this.origUrl = origUrl;

        this.shortUrl = shortUrl; 
        this.urlId = ShortenerClass.shortUrltoId(shortUrl); //а также проверять не существует ли уже такой
    }
}