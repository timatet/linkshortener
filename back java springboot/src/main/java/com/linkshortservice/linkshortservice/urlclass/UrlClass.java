package com.linkshortservice.linkshortservice.urlclass;

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
    private Integer urlId; //id короткой ссылки
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name = "orig_url")
    private String origUrl;

    public Integer getUrlId() {
        return urlId;
    }
        
    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getShortUrl() {
        return shortUrl;
    }
        
    public void setShortuRL(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOrigUrl() {
        return origUrl;
    }

    public void setOrigUrl(String origUrl) {
        this.origUrl = origUrl;
    }

    public UrlClass(Integer urlId, String shortUrl, String origUrl) {
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

    @Override
    public String toString() {
        return "Url{" +
                "id=" + urlId +
                ", fullUrl='" + origUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}