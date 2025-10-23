package br.com.feSchulz;

import br.com.feSchulz.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonServices {

    private final AtomicLong conter = new AtomicLong();
    private Logger log = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findALL() {
        log.info("Retornando todas as pessoas");
        List<Person> pesosas = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person per = mockPerson(i);
            pesosas.add(per);
        }

        return pesosas;
    }

    private Person mockPerson(int i) {
        Person per = new Person();
        per.setId(conter.incrementAndGet());
        per.setFirstName("FirstName " + i);
        per.setLastName("LastName " + i);
        per.setAddress("address " + i);
        per.setGender("M");
        return per;

    }

    public Person findById(String id) {
        log.info("Encontrando uma pesssoa pelo ID");

        Person per = new Person();
        per.setId(conter.incrementAndGet());
        per.setFirstName("Felipe");
        per.setLastName("Schulz");
        per.setAddress("Joinville");
        per.setGender("M");
        return per;
    }

    public Person create(Person person) {
        log.info("Criando uma pessoa");
        return person;
    }

    public Person update(Person person) {
        log.info("Atualizando uma pessoa");
        person.setFirstName("Tadeu");
        return person;
    }

    public void delete(String id) {

       log.info("Deletando uma Pessoa");
    }

}
