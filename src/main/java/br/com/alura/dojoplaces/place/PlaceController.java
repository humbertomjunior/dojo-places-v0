package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.repository.PlaceRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/places/create")
    public String getPlaces(Model model, PlaceDto placeDto) {
        model.addAttribute("placeDto", placeDto);
        return "/createLocal";
    }

    @PostMapping("/places/register")
    public String register(@Valid PlaceDto placeDto, BindingResult bindingResult) {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) return "/createLocal";
        Place place = new Place(placeDto);
        this.placeRepository.save(place);
        return "redirect:/createLocal";
    }

}
