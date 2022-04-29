package com.jcy.wecando.service.user;

import com.jcy.wecando.entity.comment.repository.CommentRepository;
import com.jcy.wecando.entity.refresh_token.repository.RefreshTokenRepository;
import com.jcy.wecando.entity.user.User;
import com.jcy.wecando.entity.user.repository.UserRepository;
import com.jcy.wecando.error.exceptions.AlreadySignedException;
import com.jcy.wecando.error.exceptions.UserNotFoundException;
import com.jcy.wecando.payload.request.SignUpRequest;
import com.jcy.wecando.payload.response.UserResponse;
import com.jcy.wecando.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final DoneRepository doneRepository;
    private final CommentRepository commentRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtProvider jwtProvider;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        if(userRepository.existsById(signUpRequest.getId()))
            throw new AlreadySignedException();

        userRepository.save(
                User.builder()
                        .id(signUpRequest.getId())
                        .isCommentNotification(true)
                        .build()
        );
    }

    @Override
    public UserResponse getMyInfo(String token) {
        User user = userRepository.findById(jwtProvider.getId(token))
                .orElseThrow(UserNotFoundException::new);

        return UserResponse.builder()
                .id(user.getId())
                .isNotificationComment(user.getIsCommentNotification())
                .build();
    }

    @Override
    public void updateIsNotificationComment(String token, Boolean isNotificationComment) {
        User user = userRepository.findById(jwtProvider.getId(token))
                .orElseThrow(UserNotFoundException::new);

        userRepository.save(user.updateIsComment(isNotificationComment));
    }
}