package br.com.vinicius.LaborProcessControl.responses;

import org.springframework.http.HttpStatus;

import java.util.List;

public class SaveResponse {

    private HttpStatus status;
    private List<String> errors;
    private String messageSucess;

    public SaveResponse() {}

    public SaveResponse(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public SaveResponse(HttpStatus status, String messageSucess) {
        this.status = status;
        this.messageSucess = messageSucess;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getMessageSucess() {
        return messageSucess;
    }

    public void setMessageSucess(String messageSucess) {
        this.messageSucess = messageSucess;
    }
}
