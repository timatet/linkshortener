package com.linkshortservice.linkshortservice;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<UrlClass, Integer> {
    @Query(value = "select orig_url from urls_data where short_url = ?1", nativeQuery = true)
    String findByShortUrl(String shortUrl);

    @Query(value = "update urls_data set short_url = ?1 where url_id = ?2", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    void setShortUrlById(String shortUrl, Integer id);
}
