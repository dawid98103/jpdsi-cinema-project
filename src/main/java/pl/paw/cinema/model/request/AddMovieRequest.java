package pl.paw.cinema.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {

    private int movieId;
    private String movieName;
    private String movieDescription;
    private int movieDuration;
    private String movieSmallUrl;
    private String movieDirector;
    private int genreId;
}
