package org.example.boardback.security.oauth2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.boardback.common.enums.AuthProvider;
import org.example.boardback.entity.user.User;
import org.example.boardback.repository.user.RoleRepository;
import org.example.boardback.repository.user.UserRepository;
import org.example.boardback.security.oauth2.user.OAuth2UserInfo;
import org.example.boardback.security.user.UserPrincipalMapper;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

// DB 사용자 생성 / 업데이트
@Slf4j  // Simple Logging Facade for Java: 로깅 기능을 간편하게 하는 Lombok
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserPrincipalMapper userPrincipalMapper;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    }

    private AuthProvider mapProvider(String registrationId) {

    }

    private OAuth2UserInfo convertToUserInfo(AuthProvider provider, Map<String, Object> attributes) {

    }

    @Transactional
    protected User upsertUser(AuthProvider provider, OAuth2UserInfo userInfo) {

    }
}
