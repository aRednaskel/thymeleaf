package com.thymeleaf.learn.Thymeleaf.infrastructure.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import com.thymeleaf.learn.Thymeleaf.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public User getUserByFirstAndLastname(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastNameContainsAllIgnoreCase(firstName, lastName)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users;

        if (name != null && (name.trim().length() > 0)) {
            users = userRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
        } else {
            users = findAll();
        }
        return users;
    }
}
