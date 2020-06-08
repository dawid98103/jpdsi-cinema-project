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
@Builder(toBuilder = true)
public class Cinema {

    @Id
    @Column(name = "CINEMA_ID")
    private int cinemaId;

    @Column(name = "LATITUDE")
    private int latitude;

    @Column(name = "LONGITUDE")
    private int longitude;
}
