package pl.paw.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import pl.paw.cinema.utils.enums.MovieGenreEnum;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Size(max = 64, message = "Nazwa filmu nie może przekraczać {max} znaków")
    @Column(name = "movie_name")
    private String movieName;

    @Size(max = 2056, message = "Opis nie może być dłuższy niż {max} znaków")
    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "movie_duration")
    private Integer movieDuration;

    @Column(name = "movie_big_url")
    private String movieBigUrl;

    @Column(name = "movie_small_url")
    private String movieSmallUrl;

    @Column(name = "movie_director")
    private String movieDirector;

    @Column(name = "movie_genre")
    private MovieGenreEnum movieGenre;

    @Formula("(select AVG(Rate.mark) from Rate where Rate.movie_id = movie_id)")
    private Integer averageRate;

//    //TODO rekurencja
//    @OneToMany(mappedBy = "movie")
//    private Set<Reservation> movieReservation;
}