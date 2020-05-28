package pl.paw.cinema.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeDeserializer;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(toBuilder = true)
public class MovieShowingResponseModel {
    private int showingId;
    private Set<Movie> movies;
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime showingDate;
}
