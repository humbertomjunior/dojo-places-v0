package br.com.alura.dojoplaces.place;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record ListingPlace(Long id, String name, String code, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {

    public Long id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public String code() {
        return this.code;
    }
    public String formatedCreatedDateTime() {
        return this.creationDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int lastUpdateDateTimeInDays() {
        return Period.between(this.lastUpdateDateTime.toLocalDate(), LocalDate.now()).getDays();
    }

    public long lastUpdateDateTimeInHours() {
        return Duration.between(this.lastUpdateDateTime, LocalDateTime.now()).toHours();
    }

    public long lastUpdateDateTimeInMinutes() {
        return Duration.between(this.lastUpdateDateTime, LocalDateTime.now()).toMinutes();
    }

    public long lastUpdateDateTimeInSeconds() {
        return Duration.between(this.lastUpdateDateTime, LocalDateTime.now()).toSeconds();
    }

    public static ListingPlace fromEntity(Place place) {
        return new ListingPlace(place.getId(), place.getName(), place.getCode(), place.getCreationDateTime(), place.getUpdateDateTime());
    }

    public static List<ListingPlace> fromEntity(List<Place> places) {
        return places.stream().map(ListingPlace::fromEntity).toList();
    }
}
