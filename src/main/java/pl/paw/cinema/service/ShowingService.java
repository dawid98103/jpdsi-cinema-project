package pl.paw.cinema.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.entity.Showing;
import pl.paw.cinema.model.request.AddShowingRequest;
import pl.paw.cinema.repository.ShowingRepository;

import java.time.Instant;
import java.time.ZoneId;

@Service
@Data
@RequiredArgsConstructor
public class ShowingService {

    private final ShowingRepository showingRepository;
    private final MovieService movieService;

    public void save(AddShowingRequest addShowingRequest) {
        System.out.println(addShowingRequest.getShowingTimestamp());
        Movie movie = movieService.findMovieById(addShowingRequest.getMovieId());
        showingRepository.save(
                Showing.builder()
                        .showingId(0)
                        .movieId(addShowingRequest.getMovieId())
                        .movieName(movie.getMovieName())
                        .showingDate(Instant.ofEpochMilli(addShowingRequest.getShowingTimestamp()).atZone(ZoneId.systemDefault()).toLocalDateTime())
                        .showingDuration(movie.getMovieDuration())
                        .showingImgUrl(movie.getMovieSmallUrl())
                        .build()
        );
    }

    public DataTablesOutput<Showing> getAllShowings(DataTablesInput input) {
        return showingRepository.findAll(input);
    }

    public Showing findShowingById(int showingId) {
        return showingRepository.findByShowingId(showingId);
    }

//    public List<MovieShowingResponseModel> getShowingsByDates(long dateFrom, long dateTo) {
//        return showingRepository.findAllByShowingDateBetween(
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(dateFrom),
//                        TimeZone.getDefault().toZoneId()),
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTo),
//                        TimeZone.getDefault().toZoneId())
//        ).stream().map(showing -> MovieShowingResponseModel.builder()
//                .showingDate(showing.getShowingDate())
//                .showingId(showing.getShowingId())
//                .movies(showing.getMovies())
//                .build()).collect(Collectors.toList());
//    }
}