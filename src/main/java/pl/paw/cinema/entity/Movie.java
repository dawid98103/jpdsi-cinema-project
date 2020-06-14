package pl.paw.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "MOVIE")
public class Movie {

    @Id
    @javax.persistence.Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Size(max = 64, message = "Nazwa filmu nie może przekraczać {max} znaków")
    @javax.persistence.Column(name = "MOVIE_NAME")
    private String movieName;

    @javax.persistence.Column(name = "MOVIE_DESCRIPTION")
    private String movieDescription;

    @javax.persistence.Column(name = "MOVIE_DURATION")
    private Integer movieDuration;

    @javax.persistence.Column(name = "MOVIE_SMALL_URL")
    private String movieSmallUrl;

    @javax.persistence.Column(name = "MOVIE_DIRECTOR")
    private String movieDirector;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GENRE_ID", nullable = false)
    private Genre genre;

    @Formula("(select AVG(Rate.mark) from Rate where Rate.movie_id = movie_id)")
    private Double averageRate;
}