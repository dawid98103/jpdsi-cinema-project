package pl.paw.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    @JoinColumn(name = "user_login")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "amount_to_pay")
    private BigDecimal amountToPay;

    @Column(name = "reservation_date_start")
    private LocalDateTime reservationDateStart;

    @Column(name = "reservation_date_end")
    private LocalDateTime reservationDateEnd;
}