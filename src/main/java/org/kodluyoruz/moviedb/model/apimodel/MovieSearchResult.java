package org.kodluyoruz.moviedb.model.apimodel;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class MovieSearchResult implements Serializable {

    private Integer id;

    private Double popularity;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("vote_average")
    private Double votes;

    private String title;

    @SerializedName("release_date")
    private Date releaseDate;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    private String overview;

    @SerializedName("poster_path")
    private String poster;

    private String genres;

    //TODO:bunu burdan al
    private boolean movieExist;
}
