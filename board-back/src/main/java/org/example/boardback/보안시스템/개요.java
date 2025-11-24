package org.example.boardback.보안시스템;

/**
 * == 프로젝트 보안 흐름 설명 ==
 * : Spring Security + JWT (Access/Refresh)
 *  + DB에 저장하는 RefreshToken + 커스텀 필터 구조(현 코드 구조)
 *
 *  cf) OAuth2(카카오/구글/네이버) 구현 이전 구조
 *
 * 1. 전체 구조: 예) 학교 시스템 비유
 *      회원가입   - "학생부"에 이름 등록하기
 *      로그인     - "학생증" 발급 받기
 *
 *      AccessToken) (복도 돌아다닐 때 보여주는)1일짜리 학생증 (학생이 소지)
 *      RefreshToken) 학생증 재발급 권한 기록 (교무실에 보관)
 *
 *      JWT 필터: JwtAuthenticationFilter) (복도에서) 학생증(token) 검사를 하는 "선도부"
 *      Spring Security 설정: WebSecurityConfig) 교칙 설정
 *                           >> 어디는 누구나 들어와도 되고, 어디는 학생만, 어디는 교사만 출입 가능
 *
 *      로그아웃 - "학생증 재발급 원한 기록(RefreshToken)" 삭제
 *      OAuth2 - "카카오/구글/네이버 등"이 대신 학생증을 발급해주고, 해당 학생증으로 학교에 출입하는 것
 *
 *  2. Spring Security 설정 (WebSecurityConfig)
 *      : 교칙 설정과 복도 선도부 배치
 *
 *      config/WebSecurityConfig.java
 *      security/filter/JwtAuthenticationFilter.java
 *              /provider/JwtProvider/java
 *              /user/*
 *              /handler/*
 *
 *  2-1. WebSecurityConfig 역할
 *      : @EnableWebSecurity + SecurityFilterChain을 사용하여
 *
 *      1) 세션 사용 안 함 (STATELESS)
 *          - 옛날 방식: 서버가 로그인 세션을 기억
 *          - 지금 방식: 서버는 세션 안 쓰고, 매 요청마다 JWT 검사
 *                  > 선도부/선생님은 기억이 없음 - 학생증(토큰) 자체에 정보가 들어있음
 *
 *
 * */

public class 개요 {
}
