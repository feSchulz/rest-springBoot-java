package br.com.feSchulz.data.dto;

import br.com.feSchulz.serializer.GenderSerializer;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @JsonPropertyOrder
 * Define a ordem em que os campos aparecerão ao converter o objeto para JSON.
 * Isso não muda nada no funcionamento, apenas organiza melhor sua exibição.
 */
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "birthDay",
        "phoneNumber",
        "address",
        "gender",
        "nomeDaMae",
        "nomePai"
})
@JsonFilter("PersonFilter")
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * @JsonProperty("first_Name")
     * Quando o objeto for enviado como JSON, o campo aparecerá como "first_Name".
     *
     * Exemplo no JSON:
     * {
     *     "first_Name": "Felipe"
     * }
     *
     * O Jackson também usará esse nome ao RECEBER JSON.
     */
    @JsonProperty("first_Name")
    private String firstName;

    /**
     * Mesmo funcionamento do @JsonProperty acima, porém aplicado ao campo lastName.
     */
    @JsonProperty("last_Name")
    private String lastName;

    /**
     * @JsonFormat(pattern = "dd/MM/yyyy")
     * Define o padrão de data quando converter para JSON:
     *
     * Exemplo: 21/11/2025
     *
     */
    @JsonFormat(pattern = "dd/MM/yyyy")
    private GregorianCalendar birthDay;
    @JsonIgnore
    private String address;

    private String sensitiveData;
    @JsonInclude(JsonInclude.Include.NON_EMPTY) // quando for vazio ele não será enviado
    private String phoneNumber;
    @JsonSerialize(using= GenderSerializer.class)
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL) // quando for nullo ele não será enviado
    private String nomeDaMae;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomePai;

    // =========================================================================
    // GETTERS E SETTERS
    // =========================================================================

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

    public GregorianCalendar getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(GregorianCalendar birthDay) {
        this.birthDay = birthDay;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }
    // =========================================================================
    // MÉTODOS equals() E hashCode()
    // =========================================================================


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO personDTO)) return false;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getBirthDay(), personDTO.getBirthDay()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getSensitiveData(), personDTO.getSensitiveData()) && Objects.equals(getPhoneNumber(), personDTO.getPhoneNumber()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getNomeDaMae(), personDTO.getNomeDaMae()) && Objects.equals(getNomePai(), personDTO.getNomePai());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthDay(), getAddress(), getSensitiveData(), getPhoneNumber(), getGender(), getNomeDaMae(), getNomePai());
    }
}
