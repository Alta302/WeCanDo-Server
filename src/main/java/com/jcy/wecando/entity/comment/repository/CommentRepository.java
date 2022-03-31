package com.jcy.wecando.entity.comment.repository;

import com.jcy.wecando.entity.comment.Comment;
import com.jcy.wecando.entity.done.Done;
import com.jcy.wecando.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByCommentId(Long commentId);
    List<Comment> findByDone(Done done);
    void deleteByCommentId(Long commentId);
    void deleteAllByDone(Done done);
    void deleteAllByUser(User user);
}