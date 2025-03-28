package com.lcwd.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hotels")
public class Hotel {

    @Id
    @Column(name="hotelId")
    private String hotelid;
    private String name;
    private String location;
    private String about;
}
