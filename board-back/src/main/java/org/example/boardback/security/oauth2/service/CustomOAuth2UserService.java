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
    // User Entity를 Spring Security에서 사용하는 UserPrincipal로 변환하는 매퍼
    private final UserPrincipalMapper userPrincipalMapper;

    /**
     * OAuth2 로그인 시 provider(google, kakao, naver)로부터 사용자 정보를 가져와
     *  , 프로젝트 서비스의 User 엔티티로 저장/업데이트 한 뒤
     *  >> 최종적으로, Spring Security가 이해할 수 있는 OAuth2User(UserPrincipal) 행태로 리턴
     * */
    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 1. provider로 부터 사용자 정보 가져오기
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 2. registrationId로 provider 구분
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        AuthProvider provider = mapProvider(registrationId);

        // 3. provider 별로 attributes를 공통 포맷으로 변환
        OAuth2UserInfo userInfo = convertToUserInfo(provider, oAuth2User.getAttributes());

        // 4. DB에 사용자 생성/수정
        User user = upsertUser(provider, userInfo);

        // 5. 프로젝트 서비스에서 사용하는 UserPrincipal로 래핑
        return userPrincipalMapper.toPrincipal(user.getUsername());
    }

    private AuthProvider mapProvider(String registrationId) {

    }

    private OAuth2UserInfo convertToUserInfo(AuthProvider provider, Map<String, Object> attributes) {

    }

    @Transactional
    protected User upsertUser(AuthProvider provider, OAuth2UserInfo userInfo) {

    }
}
