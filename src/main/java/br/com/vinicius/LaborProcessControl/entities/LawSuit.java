package br.com.vinicius.LaborProcessControl.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Processos")
public class LawSuit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 25)
    private String numberLawSuit;
    @ManyToOne
    @JoinColumn(name = "id")
    private Complainant complainant;
    @ManyToMany
    @JoinTable(name = "lawSuit_Defendant",
            joinColumns = @JoinColumn(name = "lawSuit_id"),
            inverseJoinColumns = @JoinColumn(name = "defendant_id"))
    private List<Defendant> defendants;

    public LawSuit(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberLawSuit() {
        return numberLawSuit;
    }

    public void setNumberLawSuit(String numberLawSuit) {
        this.numberLawSuit = numberLawSuit;
    }

    public Complainant getComplainant() {
        return complainant;
    }

    public void setComplainant(Complainant complainant) {
        this.complainant = complainant;
    }

    public List<Defendant> getDefendants() {
        return defendants;
    }

    public void setDefendants(List<Defendant> defendants) {
        this.defendants = defendants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LawSuit)) return false;

        LawSuit lawSuit = (LawSuit) o;

        if (id != null ? !id.equals(lawSuit.id) : lawSuit.id != null) return false;
        if (numberLawSuit != null ? !numberLawSuit.equals(lawSuit.numberLawSuit) : lawSuit.numberLawSuit != null)
            return false;
        if (complainant != null ? !complainant.equals(lawSuit.complainant) : lawSuit.complainant != null) return false;
        return defendants != null ? defendants.equals(lawSuit.defendants) : lawSuit.defendants == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numberLawSuit != null ? numberLawSuit.hashCode() : 0);
        result = 31 * result + (complainant != null ? complainant.hashCode() : 0);
        result = 31 * result + (defendants != null ? defendants.hashCode() : 0);
        return result;
    }
}