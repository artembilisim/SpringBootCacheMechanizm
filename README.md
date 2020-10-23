# Spring Boot Cache Mechanizm Sample

Spring Boot Rest Api Project Using JDK 1.8

## Info

  - Using TMDB (themoviedb) api data to send request
  - Gets movie detail using movie's unique id
  - Keeps previous request results in cache
  - There is 5 seconds delay if request result gets from TMDB Api
  - No delay if request result gets from cache

## Usage
server.port = 8034

id samples: 100, 200, 350, 550, 700, 950

request sample => localhost:8034/movie/id/100

clear cache => localhost:8034/evictcache


## License
[MIT](https://choosealicense.com/licenses/mit/)