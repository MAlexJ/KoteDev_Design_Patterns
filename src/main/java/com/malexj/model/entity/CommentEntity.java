package com.malexj.model.entity;

import com.malexj.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "pattern_id")
    private PatternEntity pattern;

    public CommentEntity() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public PatternEntity getPattern() {
        return pattern;
    }

    public void setPattern(PatternEntity pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return pattern != null ? pattern.equals(that.pattern) : that.pattern == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (pattern != null ? pattern.hashCode() : 0);
        return result;
    }
}
