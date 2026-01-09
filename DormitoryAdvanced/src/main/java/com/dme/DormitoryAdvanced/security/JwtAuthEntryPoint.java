package com.dme.DormitoryAdvanced.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// --- DÜZELTME BAŞLANGIÇ ---
// import javax.naming.AuthenticationException; // <-- BU YANLIŞ, SİLİN
import org.springframework.security.core.AuthenticationException; // <-- BU DOĞRU, EKLEYİN
// --- DÜZELTME BİTİŞ ---

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}