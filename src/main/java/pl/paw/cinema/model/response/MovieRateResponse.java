package pl.paw.cinema.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieRateResponse {
    String movieName;
    String movieRate;
}
