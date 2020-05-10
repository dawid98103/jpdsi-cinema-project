package pl.paw.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.paw.calc.utils.enums.MovieGenreEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movie_genre")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MovieGenre {

    @Id
    @Column(name = "movie_genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieGenreId;

    @Column(name = "name")
    private String movieGenreName;

    @OneToMany(mappedBy = "movieGenre", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
