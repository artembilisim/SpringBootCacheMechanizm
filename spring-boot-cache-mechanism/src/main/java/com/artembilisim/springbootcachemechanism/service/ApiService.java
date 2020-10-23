package com.artembilisim.springbootcachemechanism.service;

import com.artembilisim.springbootcachemechanism.models.Movie;
import com.artembilisim.springbootcachemechanism.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    @Autowired
    private CacheManager cacheManager;

    @Value("${api.key}")
    private String apiKey;

    @Value("${base.url}")
    private String baseUrl;

    @Cacheable("movies")
    public Movie getMovieById(String id) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();

        String url = baseUrl + id + "?api_key=" + apiKey;

        MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);

        Movie movie = new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());

        Thread.sleep(5000);

        return movie;
    }

    public String evictCache() {
        for (String name : cacheManager.getCacheNames()) {
            cacheManager.getCache(name).clear();            // clear cache by name
        }
        return "Cache temizlendi";
    }
}
