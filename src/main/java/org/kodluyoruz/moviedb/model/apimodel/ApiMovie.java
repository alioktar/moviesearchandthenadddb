package org.kodluyoruz.moviedb.model.apimodel;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class ApiMovie implements Serializable {

    private Integer id;

    private Integer budget;

    private List<ApiGenre> genres = new LinkedList<>();

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    private String overview;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("release_date")
    private Date releaseDate;

    @SerializedName("runtime")
    private Integer duration;

    private String title;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("production_companies")
    private List<ApiProductionCompany> productionCompanies = new LinkedList<>();

    private List<ApiCast> casts = new LinkedList<>();

    private List<ApiCrew> crews = new LinkedList<>();

}
