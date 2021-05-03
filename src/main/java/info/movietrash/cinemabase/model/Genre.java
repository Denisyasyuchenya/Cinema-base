package info.movietrash.cinemabase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "ext_id")
    private int externalId;

    @Column(name = "lang", length = 2)
    private int language;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Movie> movies = new HashSet<>();
}
