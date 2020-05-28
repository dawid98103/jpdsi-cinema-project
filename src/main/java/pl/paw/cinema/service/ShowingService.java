package pl.paw.cinema.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Showing;
import pl.paw.cinema.model.response.MovieShowingResponseModel;
import pl.paw.cinema.repository.ShowingRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class ShowingService {

    private final ShowingRepository showingRepository;

    public Showing findShowingById(int showingId){
        return showingRepository.findByShowingId(showingId);
    }

    public List<MovieShowingResponseModel> getShowingsByDates(long dateFrom, long dateTo) {
        return showingRepository.findAllByShowingDateBetween(
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dateFrom),
                        TimeZone.getDefault().toZoneId()),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTo),
                        TimeZone.getDefault().toZoneId())
        ).stream().map(showing -> MovieShowingResponseModel.builder()
                .showingDate(showing.getShowingDate())
                .showingId(showing.getShowingId())
                .movies(showing.getMovies())
                .build()).collect(Collectors.toList());
    }
}