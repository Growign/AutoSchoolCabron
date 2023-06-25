package co.suo.autoschool.config;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogoutService {
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    );
}
