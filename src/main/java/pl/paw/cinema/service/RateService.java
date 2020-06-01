package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Rate;
import pl.paw.cinema.entity.User;
import pl.paw.cinema.model.request.MovieRateRequest;
import pl.paw.cinema.repository.RateRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;
    private final MyUserDetailsService userDetailsService;

    public void addRateToMovie(MovieRateRequest movieRateRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        Optional<Rate> retrievedRate = rateRepository.findByUserIdAndMovieId(retrievedUser.getId(), movieRateRequest.getMovieId());
        if (retrievedRate.isPresent()) {
            rateRepository.save(
                    retrievedRate.get().toBuilder()
                            .mark(movieRateRequest.getRate())
                            .build());
        } else {
            rateRepository.save(
                    Rate.builder()
                            .rateId(0)
                            .movieId(movieRateRequest.getMovieId())
                            .mark(movieRateRequest.getRate())
                            .userId(retrievedUser.getId())
                            .build());
        }
    }

    public int getValueForUser(int movieId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        return rateRepository.findByUserIdAndMovieId(retrievedUser.getId(), movieId).map(Rate::getMark).orElse(0);
    }
}
