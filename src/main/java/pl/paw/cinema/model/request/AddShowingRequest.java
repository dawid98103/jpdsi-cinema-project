package pl.paw.cinema.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddShowingRequest {
    private int movieId;
    private long showingTimestamp;
}
