package br.com.vinicius.LaborProcessControl.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Reclamantes")
public class Complainant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(length = 10)
    private String birthDate;
    @Column(length = 20)
    private String nationality;
    @Column(length = 30)
    private String profession;
    @Column(nullable = false, unique = true, length = 12)
    private String rg;
    @Column(nullable = false, length = 20)
    private String organRg;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(length = 20)
    private String district;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 20)
    private String bank;
    @Column(nullable = false, length = 10)
    private String agency;
    @Column(nullable = false, length = 10)
    private String account;
    @Column(length = 4)
    private String op;
    @Column(nullable = false, length = 10)
    private String typeAccount;
    @Column(nullable = false, length = 100)
    private String contacts;
    @Column(length = 50)
    private String email;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "complainant")
    private List<LawSuit> lawSuits;

    public Complainant() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrganRg() {
        return organRg;
    }

    public void setOrganRg(String organRg) {
        this.organRg = organRg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(o instanceof Complainant)) return false;

        Complainant that = (Complainant) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (rg != null ? !rg.equals(that.rg) : that.rg != null) return false;
        if (organRg != null ? !organRg.equals(that.organRg) : that.organRg != null) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (uf != null ? !uf.equals(that.uf) : that.uf != null) return false;
        if (cep != null ? !cep.equals(that.cep) : that.cep != null) return false;
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;
        if (agency != null ? !agency.equals(that.agency) : that.agency != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (op != null ? !op.equals(that.op) : that.op != null) return false;
        if (typeAccount != null ? !typeAccount.equals(that.typeAccount) : that.typeAccount != null) return false;
        if (contacts != null ? !contacts.equals(that.contacts) : that.contacts != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        return lawSuits != null ? lawSuits.equals(that.lawSuits) : that.lawSuits == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        result = 31 * result + (organRg != null ? organRg.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (agency != null ? agency.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (op != null ? op.hashCode() : 0);
        result = 31 * result + (typeAccount != null ? typeAccount.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (lawSuits != null ? lawSuits.hashCode() : 0);
        return result;
    }
}
