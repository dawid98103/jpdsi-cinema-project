package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.exception.MovieNotFoundException;
import pl.paw.cinema.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public DataTablesOutput<Movie> findAll(DataTablesInput input) {
        return movieRepository.findAll(input);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(int movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(String.format("Nie znaleziono filmu o id: %d", movieId)));
    }
}
