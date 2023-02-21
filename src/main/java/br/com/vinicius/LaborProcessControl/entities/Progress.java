package br.com.vinicius.LaborProcessControl.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Andamentos")
public class Progress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Andamento")
    private Long progressId;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private String progressType;
    @Column(length = 10)
    private String progressDate;
    @Column(length = 5)
    private String Hour;
    private String description;
    @ManyToOne
    @JoinColumn(name = "lawSuitId")
    private LawSuit lawSuit;

    public Progress() {}

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getProgressType() {
        return progressType;
    }

    public void setProgressType(String progressType) {
        this.progressType = progressType;
    }

    public String getProgressDate() {
        return progressDate;
    }

    public void setProgressDate(String progressDate) {
        this.progressDate = progressDate;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LawSuit getLawSuit() {
        return lawSuit;
    }

    public void setLawSuit(LawSuit lawSuit) {
        this.lawSuit = lawSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progress)) return false;

        Progress progress = (Progress) o;

        if (progressId != null ? !progressId.equals(progress.progressId) : progress.progressId != null) return false;
        if (registrationDate != null ? !registrationDate.equals(progress.registrationDate) : progress.registrationDate != null)
            return false;
        if (progressType != null ? !progressType.equals(progress.progressType) : progress.progressType != null)
            return false;
        if (progressDate != null ? !progressDate.equals(progress.progressDate) : progress.progressDate != null)
            return false;
        if (Hour != null ? !Hour.equals(progress.Hour) : progress.Hour != null) return false;
        if (description != null ? !description.equals(progress.description) : progress.description != null)
            return false;
        return lawSuit != null ? lawSuit.equals(progress.lawSuit) : progress.lawSuit == null;
    }

    @Override
    public int hashCode() {
        int result = progressId != null ? progressId.hashCode() : 0;
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (progressType != null ? progressType.hashCode() : 0);
        result = 31 * result + (progressDate != null ? progressDate.hashCode() : 0);
        result = 31 * result + (Hour != null ? Hour.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lawSuit != null ? lawSuit.hashCode() : 0);
        return result;
    }
}
