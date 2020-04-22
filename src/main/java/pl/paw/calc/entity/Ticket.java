package pl.paw.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Size(max = 64, message = "Typ biletu nie może przekraczać {max} znaków")
    @Column(name = "ticket_type")
    private String type;

    @Column(name = "ticket_price")
    private BigDecimal price;

    @OneToMany(mappedBy = "ticket")
    private Set<Reservation> movieReservation;

    @Column(name = "active")
    private boolean active;
}
