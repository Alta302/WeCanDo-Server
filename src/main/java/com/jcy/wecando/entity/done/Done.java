package com.jcy.wecando.entity.done;

import com.jcy.wecando.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Done {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doneId;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    private String title;

    private String content;

    private LocalDate writeAt;
}