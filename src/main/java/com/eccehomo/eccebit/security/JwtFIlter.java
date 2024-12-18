package com.eccehomo.eccebit.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

public class JwtFIlter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = request.getHeader(JWTConstant.JWT_HEADER);
        
          System.out.println("wt filter...."+jwt);

        if(jwt!=null) {
            jwt=jwt.substring(7);


            try {

                SecretKey key= Keys.hmacShaKeyFor(JWTConstant.SECRET_KEY.getBytes());

                Claims claims= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

                String email=String.valueOf(claims.get("email"));
                System.out.println("inside try 3");
                String authorities=String.valueOf(claims.get("authorities"));


                List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                Authentication athentication=new UsernamePasswordAuthenticationToken(email,null, auths);

                SecurityContextHolder.getContext().setAuthentication(athentication);

                System.out.println("inside try end");


            } catch (Exception e) {
                throw new RuntimeException("invalid token...");
            }
        }
        filterChain.doFilter(request, response);

    }



}
