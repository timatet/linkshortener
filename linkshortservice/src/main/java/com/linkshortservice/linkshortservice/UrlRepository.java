package com.linkshortservice.linkshortservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<UrlClass, Integer> {
    @Query(value = "select origUrl from public.urls where shortUrl = ?1", nativeQuery = true)
    String findByShortUrl(String id);
}
