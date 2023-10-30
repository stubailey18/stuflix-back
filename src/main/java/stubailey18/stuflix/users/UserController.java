package stubailey18.stuflix.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private void handleDuplicateUserException() {}

    @PostMapping
    public User registerUser(@RequestBody User user) throws DuplicateUserException {
        return service.registerUser(user);
    }
}
