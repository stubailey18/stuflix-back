package stubailey18.stuflix.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepo repo;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) throws DuplicateUserException {
        if (repo.findByEmailIgnoreCase(user.getEmail()).isPresent()) {
            throw new DuplicateUserException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
