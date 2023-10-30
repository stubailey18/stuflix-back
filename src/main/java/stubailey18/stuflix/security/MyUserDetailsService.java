package stubailey18.stuflix.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stubailey18.stuflix.users.UserRepo;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo repo;

    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repo.findByEmailIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("No such email"));
        return new MyUserDetails(user);
    }
}
