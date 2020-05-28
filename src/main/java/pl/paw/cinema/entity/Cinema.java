package pl.paw.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema")
@Builder(toBuilder = true)
public class Cinema {

    @Id
    @Column(name = "cinema_id")
    private int cinemaId;

    @Column(name = "latitude")
    private int latitude;

    @Column(name = "longitude")
    private int longitude;
}
