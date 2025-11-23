package br.com.feSchulz.services;

import br.com.feSchulz.data.dto.PersonDTO;
import br.com.feSchulz.exception.ResourceNotFoundException;
import br.com.feSchulz.mapper.ObjectMapper;
import br.com.feSchulz.model.Person;
import br.com.feSchulz.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
// ↑ Indica ao Spring que esta classe é um "Service", ou seja,
//   contém regras de negócio. O Spring cria um bean dessa classe
//   e permite injeção de dependência em outras partes do sistema.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    // ↑ Exemplo de contador thread-safe (não está sendo usado aqui).
    //   AtomicLong garante que incrementos funcionem sem problemas
    //   quando houver múltiplas threads.

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());
    // ↑ Logger usado para registrar logs no sistema.
    //   Importante para depuração, auditoria e rastreamento de requisições.

    @Autowired
    PersonRepository repository;
    // ↑ Injeta automaticamente o PersonRepository.
    //   Permite acessar banco de dados sem criar instâncias manualmente.


    // -----------------------------------------------------------------------------
    // MÉTODO - BUSCAR TODOS
    // -----------------------------------------------------------------------------
    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");
        // ↑ Registra no log que está buscando todos os registros.

        // findAll() → retorna List<Person> do banco de dados
        // ObjectMapper.parseListObjects → converte List<Person> para List<PersonDTO>
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }


    // -----------------------------------------------------------------------------
    // MÉTODO - BUSCAR POR ID
    // -----------------------------------------------------------------------------
    public PersonDTO findById(Long id) {

        logger.info("Finding one Person!");

        // findById() retorna Optional<Person>.
        // orElseThrow -> se não encontrar, lança uma exceção personalizada.
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Converter a entidade para DTO antes de devolver.
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }


    // -----------------------------------------------------------------------------
    // MÉTODO - CRIAR NOVA PESSOA
    // -----------------------------------------------------------------------------
    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");

        // Converte DTO → Entity (Person)
        Person entity = ObjectMapper.parseObject(person, Person.class);

        // Salva no banco e converte de volta para DTO
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }


    // -----------------------------------------------------------------------------
    // MÉTODO - ATUALIZAR PESSOA EXISTENTE
    // -----------------------------------------------------------------------------
    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");

        // Busca a pessoa no banco. Se não existir → lança exceção.
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Atualiza os dados encontrados
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        // Salva e retorna como DTO
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }


    // -----------------------------------------------------------------------------
    // MÉTODO - APAGAR POR ID
    // -----------------------------------------------------------------------------
    public void delete(Long id) {

        logger.info("Deleting one Person!");

        // Busca o registro antes de excluir
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Exclui do banco de dados
        repository.delete(entity);
    }
}
