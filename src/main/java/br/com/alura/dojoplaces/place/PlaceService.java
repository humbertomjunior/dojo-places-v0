package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.exception.PlaceNotFoundException;
import br.com.alura.dojoplaces.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void register(NewPlaceForm newPlaceForm) {
        Place place = newPlaceForm.toEntity();
        this.placeRepository.save(place);
    }

    public void update(Long placeId, EditPlaceForm editPlaceForm) throws PlaceNotFoundException {
        final var place = this.placeRepository.findById(placeId).orElseThrow(() -> new PlaceNotFoundException("Lugar com id %s nao encontrado".formatted(placeId)));
        final var editedPlace = place.updatePlace(editPlaceForm);
        this.placeRepository.save(editedPlace);
    }

    public EditPlaceForm getEditPlaceForm(Long id) throws PlaceNotFoundException {
        final var foundPlace = this.placeRepository.findById(id).orElseThrow(() -> new PlaceNotFoundException("Lugar com id %s nao encontrado".formatted(id)));
        return EditPlaceForm.fromPlace(foundPlace);
    }

    public List<ListingPlace> getPlaces() {
        final var places = this.placeRepository.findAll();
        return ListingPlace.fromEntity(places);
    }

}
