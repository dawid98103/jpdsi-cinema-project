package pl.paw.cinema.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeDeserializer;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class AddShowingRequest {
    private int movieId;
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime showingDateTime;
}
