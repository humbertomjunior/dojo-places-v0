package br.com.alura.dojoplaces.place;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    public Place() {
    }

    public Place(String city, String code, String name, String neighbourhood, LocalDateTime creationDateTime) {
        this.city = city;
        this.code = code;
        this.name = name;
        this.neighbourhood = neighbourhood;
        this.creationDateTime = creationDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public Place updatePlace(EditPlaceForm editPlaceForm) {
        this.name = editPlaceForm.name();
        this.code = editPlaceForm.code();
        this.city = editPlaceForm.city();
        this.neighbourhood = editPlaceForm.neighbourhood();
        this.updateDateTime = LocalDateTime.now();
        return this;
    }


}
