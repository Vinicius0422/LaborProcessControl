package br.com.vinicius.LaborProcessControl.dtos;

import br.com.vinicius.LaborProcessControl.entities.Defendant;
import br.com.vinicius.LaborProcessControl.entities.LawSuit;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class DefendantDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long defendantId;
    private String name;
    private String cnpj;
    private String address;
    private String contacts;
    private LocalDateTime registrationDate;
    private List<LawSuit> lawSuits;

    public Long getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(Long defendantId) {
        this.defendantId = defendantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<LawSuit> getLawSuits() {
        return lawSuits;
    }

    public void setLawSuits(List<LawSuit> lawSuits) {
        this.lawSuits = lawSuits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefendantDto)) return false;

        DefendantDto that = (DefendantDto) o;

        if (defendantId != null ? !defendantId.equals(that.defendantId) : that.defendantId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cnpj != null ? !cnpj.equals(that.cnpj) : that.cnpj != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (contacts != null ? !contacts.equals(that.contacts) : that.contacts != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        return lawSuits != null ? lawSuits.equals(that.lawSuits) : that.lawSuits == null;
    }

    @Override
    public int hashCode() {
        int result = defendantId != null ? defendantId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (lawSuits != null ? lawSuits.hashCode() : 0);
        return result;
    }
}
