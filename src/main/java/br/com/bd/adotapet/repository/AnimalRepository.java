package br.com.bd.adotapet.repository;

import br.com.bd.adotapet.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;




public interface AnimalRepository extends MongoRepository<Animal,String> {


    int countByDisponivel(boolean b);


    @Query(value = "db.animal.count()" )
    long totalAnimais();



   @Query(value = "{$group: { _id: null, idade: { $avg: '$idade' } } }")
    double calcularMediaIdade();

    @Query("{$match: { disponivel: true } }")
    long contarAdocoesRealizadas();

    @Query(value = "{$group: { _id: null, especie: {disponivel : true} } }")
    String adotadoPorEspecie();


}


