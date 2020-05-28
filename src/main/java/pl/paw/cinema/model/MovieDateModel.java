package pl.paw.cinema.model;

import lombok.Builder;
import lombok.Data;
import pl.paw.cinema.entity.Movie;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class MovieDateModel {
    private List<Movie> movie;
    private LocalDateTime dateTime;
}
