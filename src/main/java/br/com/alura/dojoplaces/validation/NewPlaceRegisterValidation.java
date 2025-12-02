package br.com.alura.dojoplaces.validation;

import br.com.alura.dojoplaces.place.NewPlaceForm;
import br.com.alura.dojoplaces.repository.PlaceRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewPlaceRegisterValidation implements Validator {

    private final PlaceRepository placeRepository;

    public NewPlaceRegisterValidation(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPlaceForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final var place = (NewPlaceForm) target;
        if (this.placeRepository.existsByCode(place.code()))
            errors.rejectValue("code", null, "Código já existe na base de dados");
    }
}
