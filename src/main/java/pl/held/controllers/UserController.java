package pl.held.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.held.models.User;
import pl.held.repositories.UserDao;

@Controller
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/newUser")
    public String newUserForm() {
        return "newUser";
    }

    @PostMapping("/newUser")
    public String newUser(@RequestParam String username, @RequestParam String pass) {
        User user = new User();
        user.setLogin(username);
        user.setPassword(pass);
        userDao.save(user);
        return "Id dodanego użytkownika to:" + user.getId();
    }
}
