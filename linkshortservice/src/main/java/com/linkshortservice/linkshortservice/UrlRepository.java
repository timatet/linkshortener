package com.linkshortservice.linkshortservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlClass, Integer> {
    
}
