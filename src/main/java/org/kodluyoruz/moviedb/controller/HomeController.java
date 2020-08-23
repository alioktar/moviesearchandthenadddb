package org.kodluyoruz.moviedb.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.kodluyoruz.moviedb.model.apimodel.*;
import org.kodluyoruz.moviedb.model.dbmodel.*;
import org.kodluyoruz.moviedb.service.*;
import org.kodluyoruz.moviedb.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController extends AbstractController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    private final MovieService movieService;
    private final GenreService genreService;
    private final MovieGenresService movieGenresService;
    private final CastService castService;
    private final CrewService crewService;
    private final ProductionCompanyService productionCompanyService;
    private final ApiService apiService = new ApiService();

    @Autowired
    public HomeController(MovieService movieService, GenreService genreService, MovieGenresService movieGenresService, CastService castService, CrewService crewService, ProductionCompanyService productionCompanyService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.movieGenresService = movieGenresService;
        this.castService = castService;
        this.crewService = crewService;
        this.productionCompanyService = productionCompanyService;
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String index(Model model) {

        return "index";
    }

    @GetMapping(value = "/search",
            produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public String search(
            @RequestParam(name = "q") String search,
            @RequestParam(name = "page") String page,
            Model model
    ) {
        MovieSearchResultResponse result;

        if (search.length() > 0) {
            try {
                result = apiService.search(search, Integer.parseInt(page));

            } catch (UnirestException e) {
                return "error/404";
            }

            if (result != null) {
                Constants.setGenres(apiService, result);
                Constants.setExistsByMovie(movieService, result);

                model.addAttribute("search", search);
                model.addAttribute("page", Integer.parseInt(page));
                model.addAttribute("image", HttpService.BASE_IMG_URL);
                model.addAttribute("result", result);
                model.addAttribute("dateFormat", DATE_FORMAT);
                return "search";
            }
        }

        return "redirect:/";
    }

    @GetMapping(value = "/add-movie/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String addMovie(@PathVariable final String id, Model model) {

        ApiMovie result;

        try {
            result = apiService.getMovieDetail(Integer.parseInt(id));

        } catch (UnirestException e) {
            return "error/404";
        }

        try {
            if (result != null) {
                Movie movie = new Movie();
                movie.setId(result.getId());
                movie.setBudget(result.getBudget());
                movie.setImdbId(result.getImdbId());
                movie.setOriginalLanguage(result.getOriginalLanguage());
                movie.setOriginalTitle(result.getOriginalTitle());
                movie.setOverview(result.getOverview());
                movie.setPoster(result.getPoster());
                movie.setReleaseDate(result.getReleaseDate());
                movie.setDuration(result.getDuration());
                movie.setTitle(result.getTitle());
                movie.setVoteCount(result.getVoteCount());
                movie.setVoteAverage(result.getVoteAverage());
                movieService.add(movie);

                for (ApiCast resultCast : result.getCasts()) {
                    Cast cast = new Cast();
                    cast.setName(resultCast.getName());
                    cast.setCharacter(resultCast.getCharacter());
                    cast.setImage(resultCast.getImage());
                    cast.setOrder(resultCast.getOrder());
                    cast.setMovie(movie);
                    castService.add(cast);
                }
                for (ApiGenre apiGenre : result.getGenres()) {
                    boolean exists = genreService.existsById(apiGenre.getId());

                    Genre genre = new Genre();

                    if (!exists) {
                        genre.setId(apiGenre.getId());
                        genre.setName(apiGenre.getName());

                        genreService.add(genre);
                    }
                    genre = genreService.findByGenreId(apiGenre.getId());

                    MovieGenres movieGenres = new MovieGenres();
                    movieGenres.setGenre(genre);
                    movieGenres.setMovie(movie);
                    movieGenresService.add(movieGenres);
                }


                for (ApiCrew resultCrew : result.getCrews()) {
                    Crew crew = new Crew();
                    crew.setName(resultCrew.getName());
                    crew.setJob(resultCrew.getJob());
                    crew.setImage(resultCrew.getImage());
                    crew.setMovie(movie);
                    crewService.add(crew);
                }

                for (ApiProductionCompany resultCompany : result.getProductionCompanies()) {
                    ProductionCompany company = new ProductionCompany();
                    company.setName(resultCompany.getName());
                    company.setId(resultCompany.getId());
                    company.setImage(resultCompany.getImage());
                    company.setMovie(movie);
                    productionCompanyService.add(company);
                }
                return "redirect:/movie/" + result.getId();
            }
            return "redirect:/";
        }catch (Exception e){
            System.out.println(e);
            return "error/404";
        }
    }

    @GetMapping(value = "/movie/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String movie(@PathVariable final String id, Model model) {

        int movieId = Integer.parseInt(id);

        Movie movie = movieService.findById(movieId);

        if (movie != null) {

            List<MovieGenres> byMovie = movieGenresService.findByMovie(movie);

            List<Genre> genres = new LinkedList<>();

            for (MovieGenres movieGenres : byMovie) {
                genres.add(movieGenres.getGenre());
            }

            model.addAttribute("image", HttpService.BASE_IMG_URL);
            model.addAttribute("dateFormat", DATE_FORMAT);
            model.addAttribute("movie", movie);
            model.addAttribute("genres", genres);
            return "movie";
        }

        return "/error/404";
    }

    @PostMapping(value = "/scoring", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String scoring(@RequestParam String movieScore, @RequestParam String movieId) {
        Movie updated = null;
        if (movieScore.length() > 0) {
            int movieScoreInt = Integer.parseInt(movieScore);
            int movieIdInt = Integer.parseInt(movieId);

            Movie movie = movieService.findById(movieIdInt);

            if (movie != null) {

                Integer voteCount = movie.getVoteCount();
                Double voteAverage = movie.getVoteAverage();

                Double newAverage = (voteCount * voteAverage + movieScoreInt) / (voteCount + 1);
                DecimalFormat df = new DecimalFormat("#0.00");
                df.setRoundingMode(RoundingMode.CEILING);

                movie.setVoteCount(voteCount + 1);
                movie.setVoteAverage(Double.valueOf(df.format(newAverage).replace(',', '.')));

                updated = movieService.update(movie);
            }

        }

        if (updated != null) {
            return "redirect:/movie/" + updated.getId();
        }

        return "/error/404";
    }
}
