package com.linkshortservice.linkshortservice;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls_data")
public class UrlClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "url_id")
    private int urlId; //id короткой ссылки
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name = "orig_url")
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

    public UrlClass(int urlId, String shortUrl, String origUrl) {
        this.urlId = urlId;
        this.shortUrl = shortUrl;
        this.origUrl = origUrl;
    }

    public UrlClass() {}

    public UrlClass(String origUrl) {
        this.origUrl = origUrl;
    }

    //конструктор для пользовательского url
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