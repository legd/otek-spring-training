package com.example.springboot.dbmodels;

import com.example.springboot.dtos.AddressDTO;
import com.example.springboot.responses.AddressResponse;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length=100, nullable=false, unique=false)
    private String recipient;

    @Column(length=200, nullable=false, unique=false)
    private String firstLine;

    @Column(length=200, nullable=false, unique=false)
    private String secondLine;

    @Column(length=50, nullable=false, unique=false)
    private String city;

    @Column(length=20, nullable=false, unique=false)
    private String zipCode;

    public AddressDTO transformToDTO() {
        return AddressDTO.builder().id(this.id).recipient(this.recipient).firstLine(this.firstLine)
                .secondLine(this.secondLine).city(this.city).zipCode(this.zipCode).build();
    }
}
