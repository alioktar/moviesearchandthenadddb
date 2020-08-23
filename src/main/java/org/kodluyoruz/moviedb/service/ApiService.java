package org.kodluyoruz.moviedb.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.kodluyoruz.moviedb.model.apimodel.*;

import java.util.TreeMap;

public class ApiService {

    private final TreeMap<Integer, ApiGenre> genres = new TreeMap<>();

    public ApiService() {
        try {
            final GenreSearchResponse genres = listGenres();

            for (ApiGenre genre : genres.getGenres()) {
                this.genres.put(genre.getId(), genre);
            }

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public GenreSearchResponse listGenres() throws UnirestException {
        return HttpService
                .connect("genre/movie/list")
                .params("language", "tr-TR")
                .getAs(GenreSearchResponse.class);
    }

    public ApiGenre getGenre(Integer id) {
        return genres.get(id);
    }

    public MovieSearchResultResponse search(String query, Integer page) throws UnirestException {
        HttpService request = HttpService.connect("search/movie/")
                .params("language", "tr-TR")
                .params("query", query);

        if (page != null) {
            request.params("page", String.valueOf(page));
        }

        return request.getAs(MovieSearchResultResponse.class);
    }

    public MovieDetailResponse getMovieCredits(Integer movieId) throws UnirestException {
        return HttpService
                .connect("movie/" + movieId + "/credits")
                .params("language", "tr-TR")
                .getAs(MovieDetailResponse.class);
    }

    public ApiMovie getMovieDetail(Integer movieId) throws UnirestException {
        ApiMovie movie = HttpService
                .connect("movie/" + movieId)
                .params("language", "tr-TR")
                .getAs(ApiMovie.class);

        MovieDetailResponse credits = getMovieCredits(movieId);
        movie.setCasts(credits.getCast());
        movie.setCrews(credits.getCrew());

        return movie;
    }
}
