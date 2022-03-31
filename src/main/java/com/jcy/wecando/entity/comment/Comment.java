package com.jcy.wecando.entity.comment;

import com.jcy.wecando.entity.recomment.Recomment;
import com.jcy.wecando.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doneId")
    private Done done;

    private String comment;

    private LocalDateTime writeAt;

    private Boolean isPublic;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Recomment> recomments;
}