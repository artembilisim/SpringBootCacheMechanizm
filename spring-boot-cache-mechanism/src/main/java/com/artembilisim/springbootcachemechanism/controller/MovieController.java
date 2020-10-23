package com.artembilisim.springbootcachemechanism.controller;

import com.artembilisim.springbootcachemechanism.models.Movie;
import com.artembilisim.springbootcachemechanism.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class MovieController {

    private final ApiService apiService;

    public MovieController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie/id/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") String movieId) throws InterruptedException {
        return apiService.getMovieById(movieId);
    }

    @RequestMapping(path = "/evictcache")
    public String evictCache(){
        return apiService.evictCache();
    }

}
