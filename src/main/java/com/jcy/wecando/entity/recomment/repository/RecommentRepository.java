package com.jcy.wecando.entity.recomment.repository;

import com.jcy.wecando.entity.comment.Comment;
import com.jcy.wecando.entity.recomment.Recomment;
import com.jcy.wecando.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommentRepository extends JpaRepository<Recomment, Long> {
    Optional<Recomment> findByRecommentId(Long recommentId);
    void deleteByRecommentId(Long recommentId);
    List<Recomment> findAllByCommentId(Comment commentId);
    void deleteAllByCommentId(Comment commentId);
    void deleteAllByUser(User user);
}