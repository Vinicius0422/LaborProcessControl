package br.com.vinicius.LaborProcessControl.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Reclamados")
public class Defendant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Reclamado")
    private Long defendantId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;
    @Column(length = 100)
    private String address;
    @Column(length = 60)
    private String contacts;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    private LocalDateTime logUpdate;
    @ManyToMany(mappedBy = "defendants")
    private List<LawSuit> lawSuits;

    public Defendant(){}

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

    public LocalDateTime getLogUpdate() {
        return logUpdate;
    }

    public void setLogUpdate(LocalDateTime logUpdate) {
        this.logUpdate = logUpdate;
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
        if (!(o instanceof Defendant)) return false;

        Defendant defendant = (Defendant) o;

        if (defendantId != null ? !defendantId.equals(defendant.defendantId) : defendant.defendantId != null)
            return false;
        if (name != null ? !name.equals(defendant.name) : defendant.name != null) return false;
        if (cnpj != null ? !cnpj.equals(defendant.cnpj) : defendant.cnpj != null) return false;
        if (address != null ? !address.equals(defendant.address) : defendant.address != null) return false;
        if (contacts != null ? !contacts.equals(defendant.contacts) : defendant.contacts != null) return false;
        if (registrationDate != null ? !registrationDate.equals(defendant.registrationDate) : defendant.registrationDate != null)
            return false;
        if (logUpdate != null ? !logUpdate.equals(defendant.logUpdate) : defendant.logUpdate != null) return false;
        return lawSuits != null ? lawSuits.equals(defendant.lawSuits) : defendant.lawSuits == null;
    }

    @Override
    public int hashCode() {
        int result = defendantId != null ? defendantId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (logUpdate != null ? logUpdate.hashCode() : 0);
        result = 31 * result + (lawSuits != null ? lawSuits.hashCode() : 0);
        return result;
    }
}
