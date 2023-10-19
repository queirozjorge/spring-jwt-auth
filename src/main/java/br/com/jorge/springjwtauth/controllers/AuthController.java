package br.com.jorge.springjwtauth.controllers;

import br.com.jorge.springjwtauth.models.mocks.UserMock;
import br.com.jorge.springjwtauth.models.request.UserCredentialsRequest;
import br.com.jorge.springjwtauth.models.request.UserRegisterRequest;
import br.com.jorge.springjwtauth.models.response.LoginResponse;
import br.com.jorge.springjwtauth.services.AuthService;
import br.com.jorge.springjwtauth.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody @Valid UserCredentialsRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserMock) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterRequest request) {
        return ResponseEntity.ok(authService.newUser(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserMock>> users() {
        return ResponseEntity.ok(authService.users());
    }

}
