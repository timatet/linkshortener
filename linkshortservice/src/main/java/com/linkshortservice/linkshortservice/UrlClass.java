package com.linkshortservice.linkshortservice;

import java.net.URL;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
        //this.urlId = ShortenerClass.shortUrltoId(shortUrl); //а также проверять не существует ли уже такой
    }

    public static boolean urlIsValid(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}