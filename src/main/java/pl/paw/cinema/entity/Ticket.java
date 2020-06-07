package pl.paw.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ticket {

    @Id
    @javax.persistence.Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Size(max = 64, message = "Typ biletu nie może przekraczać {max} znaków")
    @javax.persistence.Column(name = "ticket_type")
    private String type;

    @javax.persistence.Column(name = "ticket_price")
    private BigDecimal price;

    @javax.persistence.Column(name = "active")
    private boolean active;
}
