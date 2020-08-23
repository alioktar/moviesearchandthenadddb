package org.kodluyoruz.moviedb.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.kodluyoruz.moviedb.model.apimodel.ApiGenre;
import org.kodluyoruz.moviedb.model.apimodel.MovieSearchResult;
import org.kodluyoruz.moviedb.model.apimodel.MovieSearchResultResponse;
import org.kodluyoruz.moviedb.service.ApiService;
import org.kodluyoruz.moviedb.service.MovieService;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    public static MovieSearchResultResponse setGenres(ApiService apiService, MovieSearchResultResponse movieSearchResult) {

        for (MovieSearchResult result : movieSearchResult.getResults()) {
            result.setGenres(result.getGenreIds()
                    .stream()
                    .map(apiService::getGenre)
                    .map(ApiGenre::getName)
                    .sorted()
                    .collect(Collectors.joining(", ")));
        }

        return movieSearchResult;
    }

    public static MovieSearchResultResponse setExistsByMovie(MovieService service, MovieSearchResultResponse movieSearchResult){

        for (MovieSearchResult result : movieSearchResult.getResults()) {

            result.setMovieExist(service.existsById(result.getId()));
        }

        return movieSearchResult;
    }
}
