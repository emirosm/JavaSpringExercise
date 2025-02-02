package com.example.nobsv2;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager manager = new ConcurrentMapCacheManager();
        manager.setAllowNullValues(false);
        manager.setCacheNames(List.of("ProductCache"));
        return manager;
    }

    @CacheEvict(value = "ProductCache", allEntries = true)
    @Scheduled(fixedDelay = 7000, initialDelay = 0)
    public void evictProductCache() {
        //System.out.println("Product cache evicted");
    }
}
