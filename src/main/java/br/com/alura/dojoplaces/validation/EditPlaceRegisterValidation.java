package br.com.alura.dojoplaces.validation;

import br.com.alura.dojoplaces.place.EditPlaceForm;
import br.com.alura.dojoplaces.repository.PlaceRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EditPlaceRegisterValidation implements Validator {

    private final PlaceRepository placeRepository;

    public EditPlaceRegisterValidation(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EditPlaceForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final var place = (EditPlaceForm) target;
        if (this.placeRepository.existsByCodeAndIdNot(place.code(), place.id()))
            errors.rejectValue("code", null, "Código já existe na base de dados");
    }
}
