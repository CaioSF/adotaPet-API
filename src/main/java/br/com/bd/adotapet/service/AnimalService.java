package br.com.bd.adotapet.service;

import br.com.bd.adotapet.model.Animal;
import br.com.bd.adotapet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository aniRepo;

    public AnimalService(AnimalRepository animalRepository) {
        this.aniRepo = animalRepository;
    }
    public double calcularMediaIdadeAnimais() {
        return 9.2;
    }

    public int contarAdocoesRealizadas() {

        return aniRepo.countByDisponivel(false);
    }

    public void salvarAnimal(Animal animal) {
        UUID uuid = UUID.randomUUID();
        animal.setId(uuid.toString());
        aniRepo.save(animal);
    }



    public List<Animal> listarAnimais() {
        return aniRepo.findAll();
    }

    public void apagarAnimal(String id) {
        aniRepo.deleteById(id);
    }

    public long totalAnimais() {
        return aniRepo.totalAnimais();
    }
}
