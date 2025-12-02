package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.exception.PlaceNotFoundException;
import br.com.alura.dojoplaces.validation.EditPlaceRegisterValidation;
import br.com.alura.dojoplaces.validation.NewPlaceRegisterValidation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaceController {

    private final PlaceService placeService;
    private final NewPlaceRegisterValidation newPlaceRegisterValidation;
    private final EditPlaceRegisterValidation editPlaceRegisterValidation;

    @InitBinder("newPlaceForm")
    public void newPlaceValidatorBinder(WebDataBinder binder) {
        binder.addValidators(newPlaceRegisterValidation);
    }

    @InitBinder("editPlaceForm")
    public void editPlaceValidatorBinder(WebDataBinder binder) {
        binder.addValidators(editPlaceRegisterValidation);
    }

    public PlaceController(
            PlaceService placeService,
            NewPlaceRegisterValidation newPlaceRegisterValidation,
            EditPlaceRegisterValidation editPlaceRegisterValidation
    ) {
        this.placeService = placeService;
        this.newPlaceRegisterValidation = newPlaceRegisterValidation;
        this.editPlaceRegisterValidation = editPlaceRegisterValidation;
    }

    //CRIAR
    @GetMapping("/places/create")
    public String getPlaces(Model model, NewPlaceForm newPlaceForm) {
        model.addAttribute("placeDto", newPlaceForm);
        return "/createLocal";
    }

    //EDITAR
    @GetMapping("/places/edit/{id}")
    public String getplace(@PathVariable("id") Long id, @RequestParam(defaultValue = "false") boolean isDirty, EditPlaceForm editPlaceForm, Model model) throws PlaceNotFoundException {
        final var form = isDirty ? editPlaceForm : this.placeService.getEditPlaceForm(id);
        model.addAttribute("editPlaceForm", form);
        return "/editLocal";
    }

    //CRIAR
    @PostMapping("/places/register")
    public String register(@Valid NewPlaceForm newPlaceForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return this.getPlaces(model, newPlaceForm);
        this.placeService.register(newPlaceForm);
        return "redirect:/places";
    }

    //EDITAR
    @PostMapping("/places/edit/{id}")
    public String editLocal(@PathVariable("id") Long id, @Valid EditPlaceForm editPlaceForm, BindingResult bindingResult, Model model) throws PlaceNotFoundException {
        if (bindingResult.hasErrors()) return this.getplace(id, true, editPlaceForm, model);
        this.placeService.update(id, editPlaceForm);
        return "redirect:/places";
    }

    //LISTAR
    @GetMapping("/places")
    public String listPlaces(Model model) {
        List<ListingPlace> places = this.placeService.getPlaces();
        model.addAttribute("places", places);
        return "/listLocal";
    }

}
