package br.com.vinicius.LaborProcessControl.dtos;

import br.com.vinicius.LaborProcessControl.entities.Complainant;
import br.com.vinicius.LaborProcessControl.entities.Defendant;
import br.com.vinicius.LaborProcessControl.entities.LawSuit;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class LawSuitDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long lawSuitId;
    private String numberLawSuit;
    private Complainant complainant;
    private List<Defendant> defendants;

    public Long getLawSuitId() {
        return lawSuitId;
    }

    public void setLawSuitId(Long lawSuitId) {
        this.lawSuitId = lawSuitId;
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
        if (!(o instanceof LawSuitDto)) return false;

        LawSuitDto that = (LawSuitDto) o;

        if (lawSuitId != null ? !lawSuitId.equals(that.lawSuitId) : that.lawSuitId != null) return false;
        if (numberLawSuit != null ? !numberLawSuit.equals(that.numberLawSuit) : that.numberLawSuit != null)
            return false;
        if (complainant != null ? !complainant.equals(that.complainant) : that.complainant != null) return false;
        return defendants != null ? defendants.equals(that.defendants) : that.defendants == null;
    }

    @Override
    public int hashCode() {
        int result = lawSuitId != null ? lawSuitId.hashCode() : 0;
        result = 31 * result + (numberLawSuit != null ? numberLawSuit.hashCode() : 0);
        result = 31 * result + (complainant != null ? complainant.hashCode() : 0);
        result = 31 * result + (defendants != null ? defendants.hashCode() : 0);
        return result;
    }
}
