package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountEmailDTO extends BaseDTO {

    @NotNull
    @Size(min = 5, max = 30)
    private String email;

    public AccountEmailDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEmailDTO that = (AccountEmailDTO) o;

        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccountEmailDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
