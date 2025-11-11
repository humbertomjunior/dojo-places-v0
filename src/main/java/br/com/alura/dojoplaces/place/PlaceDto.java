package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record PlaceDto(
        Long id,
        @Length(max = 100)
        String name,
        String code,
        @Length(max = 100)
        String neighbourhood,
        @Length(max = 100)
        String city,
        @PastOrPresent
        LocalDateTime creationDate,
        @PastOrPresent
        LocalDateTime updateDate
) {

    @Override
    public String name() {
        return name;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String neighbourhood() {
        return neighbourhood;
    }

    @Override
    public String city() {
        return city;
    }

    @Override
    public LocalDateTime creationDate() {
        return creationDate;
    }

    @Override
    public LocalDateTime updateDate() {
        return updateDate;
    }


}
