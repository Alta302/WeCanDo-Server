package com.jcy.wecando.entity.user;

import com.jcy.wecando.entity.comment.Comment;
import com.jcy.wecando.entity.recomment.Recomment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;

    private Boolean isCommentNotification;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Done> dones;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recomment> recomments;

    public User updateIsComment(Boolean isComment) {
        this.isCommentNotification = isComment;

        return this;
    }
}