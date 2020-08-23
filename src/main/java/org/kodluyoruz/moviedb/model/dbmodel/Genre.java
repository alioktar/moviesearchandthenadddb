package org.kodluyoruz.moviedb.model.dbmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "genres")
@NamedQuery(name = "Genre.findByGenreId", query = "select g from Genre g where g.id = ?1")
public class Genre extends MyEntity<Integer> implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "genres",fetch = FetchType.LAZY)
    List<Movie> movies= new LinkedList<>();
}
