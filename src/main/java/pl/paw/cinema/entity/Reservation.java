package pl.paw.cinema.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeDeserializer;
import pl.paw.cinema.utils.serialization.CustomLocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "reservation")
@Builder(toBuilder = true)
public class Reservation implements Serializable {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<TicketQuantity> ticketQuantities;

    @Column(name = "amount_to_pay")
    private BigDecimal amountToPay;

    @Column(name = "reservation_date_start")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime reservationDateStart;

    @Column(name = "reservation_date_end")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime reservationDateEnd;
}