package br.com.bd.adotapet.controller;

import br.com.bd.adotapet.model.Animal;
import br.com.bd.adotapet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class AnimaisController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("")
    public String home(Model model) {
        long totalAnimais = animalService.totalAnimais();
        double mediaIdadeAnimais = animalService.calcularMediaIdadeAnimais();
        int totalAdocoes = animalService.contarAdocoesRealizadas();

        model.addAttribute("totalAnimais", totalAnimais);
        model.addAttribute("mediaIdadeAnimais", mediaIdadeAnimais);
        model.addAttribute("totalAdocoes", totalAdocoes);
        return "home";
    }

    @GetMapping("/animal")
    public String exibirFormularioCadastro(Model model) {
        List<String> especiesCachorro = Arrays.asList(
                "Golden Retriever", "Labrador Retriever",
                "Bulldog Inglês","Poodle", "Bulldog Francês"
        );

        model.addAttribute("especies", especiesCachorro);
        model.addAttribute("animal", new Animal());
        return "cadAnimal";
    }



    @PostMapping("/animal")
    public String cadastrarAnimal(@ModelAttribute("animal") Animal animal) {
        animal.setDisponivel(true);
        animalService.salvarAnimal(animal);
        return "redirect:/";
    }

    @GetMapping("/animal/listagem")
    public String exibirListagemAnimais(Model model) {
        List<Animal> animais = animalService.listarAnimais();
        model.addAttribute("animais", animais);
        return "listaAnimal";
    }

    @GetMapping("/animal/{id}/apagar")
    public String apagarAnimal(@PathVariable("id") String id) {
        animalService.apagarAnimal(id);
        return "redirect:/animal/listagem";
    }

}
