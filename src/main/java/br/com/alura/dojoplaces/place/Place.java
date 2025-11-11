package br.com.alura.dojoplaces.place;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    private String neighbourhood;

    private String city;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Place(PlaceDto placeDto) {
        this.city = placeDto.city();
        this.code = placeDto.code();
        this.name = placeDto.name();
        this.neighbourhood = placeDto.neighbourhood();
        this.creationDateTime = LocalDateTime.now();
    }

    public Place() {
    }

}
