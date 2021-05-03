package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.dto.SearchDto;
import info.movietrash.cinemabase.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping(value = "/search")
public class SearchMovieController {

    private final static String baseUrl = "https://api.themoviedb.org/3/search/movie?api_key=0b31fa0abdf8b9e72d279c0646c5bd08&query=Tom+Jerry";

    @Value("${themoviedb.ord.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public SearchMovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public List<Movie> searchMovies(@RequestBody SearchDto dto) {
//
//        try{
//            Optional<Movie> movie = movieService.findByName(dto.getQuery());
//
//            if(movie.isPresent()) {
//                return Collections.singletonList(movie.get());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", dto.getQuery())
                .queryParam("language", Locale.getDefault())
                .build()
                .toUri();

        try {

            RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String moviesJson = response.getBody();

            System.out.println(moviesJson);
            Movie movie = new Movie();
            movie.setTitle(moviesJson);
            return Collections.singletonList(movie);

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }

    }



}
