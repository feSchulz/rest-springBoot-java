package com.feSchulz.mapper.custom;

import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;
import com.feSchulz.data.dto.v2.PersonDTOv2;
import com.feSchulz.model.Person;
@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person) {
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBirthDay(new GregorianCalendar());
        return dto;
    }

    public Person convertEntityToDTO(PersonDTOv2 person) {
        Person dto = new Person();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }


}
