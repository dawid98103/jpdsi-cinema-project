package pl.paw.calc.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import pl.paw.calc.entity.Movie;
import pl.paw.calc.utils.serialization.CustomLocalDateTimeDeserializer;
import pl.paw.calc.utils.serialization.CustomLocalDateTimeSerializer;

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
