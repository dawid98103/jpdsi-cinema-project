package pl.paw.cinema.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeDeserializer;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "showing")
public class Showing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showing_id")
    int showingId;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "showing_date")
    private LocalDateTime showingDate;

    @ManyToMany
    @JoinTable(
            name = "showing_movies",
            joinColumns = @JoinColumn(name = "showing_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;
}