package pl.paw.calc.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
