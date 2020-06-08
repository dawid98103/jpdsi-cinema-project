package pl.paw.cinema.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MovieRateRequest {

    private int movieId;
    private BigDecimal rate;
}
