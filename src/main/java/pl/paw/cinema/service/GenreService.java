package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Genre;
import pl.paw.cinema.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public Genre getOneById(int genreId){
        return genreRepository.getOne(genreId);
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
