package stubailey18.stuflix.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import stubailey18.stuflix.users.User;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class MyUserDetails implements UserDetails {

    private User user;

    private static String userRole;
    private static Logger logger = LoggerFactory.getLogger(MyUserDetails.class);

    public MyUserDetails(User user) {
        this.user = user;
    }

    static {
        var properties = new Properties();
        try {
            properties.load(MyUserDetails.class.getResourceAsStream("/application.properties"));
            userRole = properties.getProperty("userRole");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
