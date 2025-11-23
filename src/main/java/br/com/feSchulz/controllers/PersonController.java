package br.com.feSchulz.controllers;

import br.com.feSchulz.data.dto.PersonDTO;
import br.com.feSchulz.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;
import java.util.List;

@RestController
// ↑ @RestController indica que esta classe expõe endpoints REST.
//   Ela combina: @Controller + @ResponseBody
//   Ou seja, todos os métodos retornam JSON automaticamente.
@RequestMapping("/person")
// ↑ Define o caminho base do endpoint.
//   Ex: http://localhost:8080/person
public class PersonController {

    @Autowired
    private PersonServices service;
    // ↑ Injeta automaticamente o Service que contém as regras de negócio.
    //   Isso evita instanciar manualmente (como no código comentado abaixo).
    //   // private PersonServices service = new PersonServices();


    // -----------------------------------------------------------------------------
    // GET - Buscar todas as pessoas
    // -----------------------------------------------------------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // ↑ Mapeia requisições GET em /person
    //   Exemplo: GET http://localhost:8080/person
    //   produces = o retorno será JSON
    public List<PersonDTO> findAll() {
        return service.findAll();
        // ↑ Chama o service que busca todos do banco e retorna o DTO
    }


    // -----------------------------------------------------------------------------
    // GET - Buscar por ID
    // -----------------------------------------------------------------------------
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    // ↑ Mapeia GET /person/{id}
    //   Exemplo: GET http://localhost:8080/person/5
    public PersonDTO findById(@PathVariable("id") Long id) {
        // @PathVariable liga o {id} da URL ao parâmetro do método
        PersonDTO person = service.findById(id);
        person.setBirthDay(new GregorianCalendar());
        person.setPhoneNumber("(47) 9999-9999");
        person.setNomeDaMae("Maria");
        person.setNomePai("José");
        person.setSensitiveData("teste A");
        return person;
    }


    // -----------------------------------------------------------------------------
    // POST - Criar nova pessoa
    // -----------------------------------------------------------------------------
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    // ↑ Mapeia POST /person
    //   consumes = recebe corpo em JSON
    //   produces = retorna JSON
    public PersonDTO create(@RequestBody PersonDTO person) {
        // @RequestBody lê o JSON enviado no corpo da requisição
        return service.create(person);
    }


    // -----------------------------------------------------------------------------
    // PUT - Atualizar pessoa
    // -----------------------------------------------------------------------------
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    // ↑ Mapeia PUT /person
    public PersonDTO update(@RequestBody PersonDTO person) {
        // @RequestBody → JSON → DTO
        return service.update(person);
    }


    // -----------------------------------------------------------------------------
    // DELETE - Remover pessoa
    // -----------------------------------------------------------------------------
    @DeleteMapping(value = "/{id}")
    // ↑ Mapeia DELETE /person/{id}
    //   Ex: DELETE http://localhost:8080/person/10
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        // Retorna HTTP 204 - No Content (sem conteúdo)
        return ResponseEntity.noContent().build();
    }
}
