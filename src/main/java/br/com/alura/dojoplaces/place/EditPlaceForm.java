package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record EditPlaceForm(
        Long id,
        @Length(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        @NotNull(message = "Nome não pode ser null")
        String name,
        @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O codigo não pode ter caracteres especiais e nem espaço")
        @NotNull(message = "Código não pode ser null")
        String code,
        @Length(max = 100, message = "Bairro deve ter no máximo 100 caracteres")
        @NotNull(message = "Bairro não pode ser null")
        String neighbourhood,
        @Length(max = 100, message = "Cidade deve ter no máximo 100 caracteres")
        @NotNull(message = "Cidade não pode ser null")
        String city
) {

    @Override
    public String name() {
        return name;
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

    public static EditPlaceForm fromPlace(Place place) {
        return new EditPlaceForm(place.getId(), place.getName(), place.getCode(), place.getNeighbourhood(), place.getCity());
    }
}
