package com.feSchulz.services;

import com.feSchulz.data.dto.v1.PersonDTO;
import com.feSchulz.data.dto.v2.PersonDTOv2;
import com.feSchulz.exception.ResourceNotFoundException;
import com.feSchulz.mapper.ObjectMapper;
import com.feSchulz.mapper.custom.PersonMapper;
import com.feSchulz.model.Person;
import com.feSchulz.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);

    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");
        Person entity = ObjectMapper.parseObject(person,Person.class);
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }
    public PersonDTOv2 createv2(PersonDTOv2 person) {

        logger.info("Creating one Person!");
        Person entity = converter.convertEntityToDTO(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }


    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}