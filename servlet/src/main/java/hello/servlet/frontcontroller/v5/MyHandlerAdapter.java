package hello.servlet.frontcontroller.v5;

import hello.servlet.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelView handle(HttpServletResponse response, HttpServletRequest request, Object handler) throws ServletException, IOException;
}
