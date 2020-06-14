package pl.paw.cinema.repository;

import pl.paw.cinema.entity.Genre;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

public interface GenreRepository extends DataTablesJpaRepository<Genre, Integer> {
}
