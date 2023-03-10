//package kr.co.e4net.util;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//    private static final long serialVersionUID = -2550185165626007488L;
//    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;
//    @Value("${jwt.secret}")
//    private String secret;
//
//    //jwt 토큰에서 사용자 이름 검색.
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    //jwt 토큰에서 만료 날짜 검색.
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // JWT에서 회원 정보 추출.
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
//
//    //check if the token has expired
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    //Jwt 생성.
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    //Jwt 발급.
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//            .signWith(SignatureAlgorithm.HS512, secret).compact();
//    }
//
//    // 토큰유효성 + 만료일자 확인.
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//}