package pl.paw.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ticket {

    @Id
    @javax.persistence.Column(name = "TICKET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Size(max = 64, message = "Typ biletu nie może przekraczać {max} znaków")
    @javax.persistence.Column(name = "TICKET_TYPE")
    private String type;

    @javax.persistence.Column(name = "TICKET_PRICE")
    private BigDecimal price;

    @javax.persistence.Column(name = "ACTIVE")
    private boolean active;
}
