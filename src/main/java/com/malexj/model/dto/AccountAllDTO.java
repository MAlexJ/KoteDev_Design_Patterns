package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;
import com.malexj.model.enums.Roles;
import com.malexj.model.enums.UserStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountAllDTO extends BaseDTO {

    @NotNull
    @Size(min=1, max=30)
    private String name;

    @NotNull
    @Size(min=1, max=30)
    private String password;

    @NotNull
    @Size(min=3, max=30)
    private String email;

    @NotNull
    private Roles role;

    @NotNull
    private UserStatus status;

    public AccountAllDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountAllDTO that = (AccountAllDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (role != that.role) return false;
        return status == that.status;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
