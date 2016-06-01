package com.malexj.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.malexj.model.entity.base.BaseEntity;
import com.malexj.model.enums.PatternTag;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pattern")
public class PatternEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "tag", nullable = false)
    private PatternTag tag;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT", length = 2000)
    private String text;

    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_image", unique = true)
    private ImageEntity image;

    @OneToMany(mappedBy = "pattern")
    private List<CommentEntity> comments;

    public PatternEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PatternTag getTag() {
        return tag;
    }

    public void setTag(PatternTag tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatternEntity that = (PatternEntity) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (tag != that.tag) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        return comments != null ? comments.equals(that.comments) : that.comments == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (image != null ? 31 : 0);
        result = 31 * result + (comments != null ? 31 : 0);
        return result;
    }
}
