package com.linkshortservice.linkshortservice;

public class ShortenerClass {
    /**
     * Generate short url from id
     * @param urlId Url id
     * @return Short Url
     */
    static String idToShortUrl(int urlId) 
    { 
        char linkChars[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
        StringBuffer shortUrl = new StringBuffer(); 

        while (urlId > 0) 
        { 
            shortUrl.append(linkChars[urlId % 62]);
            urlId /= 62; 
        } 
      
        return shortUrl.reverse().toString(); 
    } 

    /**
     * Restores short url to id
     * @param shortURL Short url
     * @return Url Id
     */
    static int shortUrltoId(String shortURL) 
    { 
        int urlId = 0; 
      
        for (int i = 0; i < shortURL.length(); i++) 
        { 
            if ('a' <= shortURL.charAt(i) && 
                       shortURL.charAt(i) <= 'z') 
            urlId = urlId * 62 + shortURL.charAt(i) - 'a'; 
            if ('A' <= shortURL.charAt(i) && 
                       shortURL.charAt(i) <= 'Z') 
            urlId = urlId * 62 + shortURL.charAt(i) - 'A' + 26; 
            if ('0' <= shortURL.charAt(i) && 
                       shortURL.charAt(i) <= '9') 
            urlId = urlId * 62 + shortURL.charAt(i) - '0' + 52; 
        } 

        return urlId; 
    } 
}
