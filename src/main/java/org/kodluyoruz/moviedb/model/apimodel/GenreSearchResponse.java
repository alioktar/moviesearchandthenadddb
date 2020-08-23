package org.kodluyoruz.moviedb.model.apimodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class GenreSearchResponse implements Serializable {

    private List<ApiGenre> genres = new LinkedList<>();

}
