package fc5.toy3.board.domain.member.controller;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {

    String USER_USERNAME = "test_user";
    String ADMIN_USERNAME = "test_admin";
    String PASSWORD = "password";
    String USER = "USER";
    String ADMIN = "ADMIN";

    String username() default USER_USERNAME;
    String password() default PASSWORD;
    String[] authorities() default { USER };
}
