package pl.paw.cinema.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieRateRequest {

    private int movieId;
    private int rate;
}
