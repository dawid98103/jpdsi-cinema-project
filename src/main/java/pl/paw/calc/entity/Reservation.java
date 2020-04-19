package pl.paw.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
@Builder(toBuilder = true)
public class Reservation implements Serializable {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    public Movie movie;

    @Column(name = "ticket_it")
    private int ticketId;

    @Column(name = "reservation_date_start")
    private LocalDateTime reservationDateStart;

    @Column(name = "reservation_date_end")
    private LocalDateTime reservationDateEnd;
}