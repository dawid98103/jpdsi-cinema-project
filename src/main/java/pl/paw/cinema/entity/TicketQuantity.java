package pl.paw.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString(exclude = {"reservation", "ticket"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketQuantity {

    @Id
    @Column(name = "TICKET_QUANTITY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketQuantityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;

    private int quantity;
}
