package pl.paw.calc.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ShowingMovieRequest {
    private int movieId;
    private int showingId;
}
