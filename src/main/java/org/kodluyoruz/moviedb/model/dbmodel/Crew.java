package org.kodluyoruz.moviedb.model.dbmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "crew")
public class Crew extends MyEntity<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name",length = 255)
    private String name;

    @Column(name = "job",length = 255)
    private String job;

    @Column(name = "image",length = 255)
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id",referencedColumnName = "id", nullable = false)
    private Movie movie;
}
