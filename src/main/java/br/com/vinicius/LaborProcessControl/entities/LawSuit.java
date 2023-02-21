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
    @Column(name = "Id_Processo")
    private Long lawSuitId;
    @Column(nullable = false, unique = true, length = 25)
    private String lawSuitNumber;
    @ManyToOne
    @JoinColumn(name = "complainantId")
    private Complainant complainant;
    @ManyToMany
    @JoinTable(name = "lawSuit_Defendant",
            joinColumns = @JoinColumn(name = "lawSuit_id"),
            inverseJoinColumns = @JoinColumn(name = "defendant_id"))
    private List<Defendant> defendants;

    @OneToMany(mappedBy = "lawSuit")
    private List<Progress> progress;
    public LawSuit(){}

    public Long getLawSuitId() {
        return lawSuitId;
    }

    public void setLawSuitId(Long lawSuitId) {
        this.lawSuitId = lawSuitId;
    }

    public String getlawSuitNumber() {
        return lawSuitNumber;
    }

    public void setlawSuitNumber(String lawSuitNumber) {
        this.lawSuitNumber = LawSuit.this.lawSuitNumber;
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

        if (lawSuitId != null ? !lawSuitId.equals(lawSuit.lawSuitId) : lawSuit.lawSuitId != null) return false;
        if (lawSuitNumber != null ? !lawSuitNumber.equals(lawSuit.lawSuitNumber) : lawSuit.lawSuitNumber != null)
            return false;
        if (complainant != null ? !complainant.equals(lawSuit.complainant) : lawSuit.complainant != null) return false;
        return defendants != null ? defendants.equals(lawSuit.defendants) : lawSuit.defendants == null;
    }

    @Override
    public int hashCode() {
        int result = lawSuitId != null ? lawSuitId.hashCode() : 0;
        result = 31 * result + (lawSuitNumber != null ? lawSuitNumber.hashCode() : 0);
        result = 31 * result + (complainant != null ? complainant.hashCode() : 0);
        result = 31 * result + (defendants != null ? defendants.hashCode() : 0);
        return result;
    }
}