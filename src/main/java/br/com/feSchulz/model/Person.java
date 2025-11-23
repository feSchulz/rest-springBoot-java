package br.com.feSchulz.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
// ↑ Indica que esta classe é uma entidade JPA, ou seja,
//   representa uma tabela no banco de dados.
@Table(name = "person")
// ↑ Define o nome da tabela no banco. Se não colocar, usaria "person" automaticamente,
//   mas é boa prática declarar.
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    // ↑ Define a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ↑ Informa que o ID será gerado automaticamente pelo banco (auto increment).
    //   Estratégia comum em MySQL e PostgreSQL.
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    // ↑ Configura a coluna na tabela:
    //   - name = nome da coluna no DB
    //   - nullable = false → obrigatório
    //   - length = tamanho máximo do campo VARCHAR
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    // ↑ Mesma explicação do anterior, mas para sobrenome.
    private String lastName;

    @Column(nullable = false, length = 100)
    // ↑ Sem "name", então o nome da coluna será "address".
    //   Também obrigatório.
    private String address;

    @Column(nullable = false, length = 6)
    // ↑ Campo obrigatório. Geralmente contém: "M", "F" ou "OUTRO".
    private String gender;

    public Person() {
        // Construtor padrão exigido pelo Hibernate/JPA.
    }

    // GETTERS E SETTERS --------------------------------------------------------

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    // MÉTODOS equals() E hashCode() --------------------------------------------

    @Override
    public boolean equals(Object o) {
        // O equals() define quando duas entidades Person são consideradas iguais.
        // Em entidades JPA, normalmente a comparação principal é baseada no ID.
        // Aqui ele compara todos os campos.

        if (!(o instanceof Person person)) return false;

        return Objects.equals(id, person.id)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(address, person.address)
                && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        // hashCode() deve usar os mesmos campos do equals().
        // Esse número é usado pelo Hibernate e por estruturas como HashMap/HashSet.
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
