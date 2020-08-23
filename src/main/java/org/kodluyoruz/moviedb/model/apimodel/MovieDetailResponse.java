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
public final class MovieDetailResponse implements Serializable {

    private Integer id;

    private List<ApiCast> cast = new LinkedList<>();

    private List<ApiCrew> crew = new LinkedList<>();
}
