package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.Role;
import pl.paw.calc.entity.User;
import pl.paw.calc.repository.RoleRepository;
import pl.paw.calc.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

import static pl.paw.calc.utils.BcryptEncoder.passwordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public boolean isUsernameExists(String username) {
        return userRepository.existsByUserName(username);
    }
}
