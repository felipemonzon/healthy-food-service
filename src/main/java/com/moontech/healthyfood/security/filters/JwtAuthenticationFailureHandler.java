package com.moontech.healthyfood.security.filters;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

  private final HttpStatus statusErrorResponse;

  public JwtAuthenticationFailureHandler(HttpStatus statusErrorResponse) {
    this.statusErrorResponse = statusErrorResponse;
  }

  public JwtAuthenticationFailureHandler() {
    this.statusErrorResponse = HttpStatus.UNAUTHORIZED;
  }

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    response.setStatus(statusErrorResponse.value());
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().append(this.jsonResponse());
  }

  private String jsonResponse() {
    long date = new Date().getTime();
    return "{\"timestamp\": "
        + date
        + ", "
        + "\"status\": "
        + statusErrorResponse.value()
        + ", "
        + "\"error\": \"Unauthorized\", "
        + "\"message\": \"Authentication failed: bad credentials\", "
        + "\"path\": \"/login\"}";
  }
}
