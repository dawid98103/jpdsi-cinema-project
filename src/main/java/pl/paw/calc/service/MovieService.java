package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.Movie;
import pl.paw.calc.exception.MovieNotFoundException;
import pl.paw.calc.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ShowingService showingService;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(int movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(String.format("Nie znaleziono filmu o id: %d", movieId)));
    }
}
