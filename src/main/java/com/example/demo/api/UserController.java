package com.example.demo.api;


import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/auth")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/signup")
    public String newUser(@RequestBody User user) throws InterruptedException {
        String r =  userService.newUser(user);
        if(r.equals("wrong")){
            return "error";
        }else{
            return r;
        }
    }

    @PostMapping(path = "/signin")
    public Token signIn(@RequestBody User user) throws InterruptedException {
       String token =  userService.signIn(user.getAccount(), user.getPassword());
       Thread.sleep(2000);
       return new Token(token);
    }

    @GetMapping(value = "/hasAccount/{account}")
    public int checkAccount(@PathVariable String account) {
        return userService.checkAccount(account);
    }

    @GetMapping(value = "/hasEmail/{email}")
    public int checkEmail(@PathVariable String email) {
        return userService.checkEmail(email);
    }
}
