package br.com.jorge.springjwtauth.services;

import br.com.jorge.springjwtauth.models.enums.UserRole;
import br.com.jorge.springjwtauth.models.mocks.UserMock;
import br.com.jorge.springjwtauth.models.request.UserRegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserMock.getMockUser(username);
    }

    public UserMock newUser(UserRegisterRequest request) {
        var user = UserMock.builder()
                .username(request.username())
                .password(new BCryptPasswordEncoder().encode(request.password()))
                .role(UserRole.valueOf(request.role()))
                .build();
        UserMock.usersMock.add(user);
        return user;
    }

    public List<UserMock> users() {
        return UserMock.usersMock;
    }

}
