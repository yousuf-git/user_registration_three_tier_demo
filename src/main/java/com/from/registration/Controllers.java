package com.from.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("/")
public class Controllers {

    @Autowired
    private Services service;

    @GetMapping("/")
    public String index() {
        return "redirect:/index.html";
    }

    // @GetMapping("/index")
    // public void indexPage(HttpServletResponse response) throws IOException {
    //     response.setHeader("Content-Type", "text/html;charset=utf-8"); // specify the content is html
    //     return "index";
    // }

    @GetMapping("/home")
    public String getHome() {
        return "redirect:/home.html";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "redirect:/signup.html";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "redirect:/login.html";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> postSignup(@RequestBody User user) {
        if (user == null || user.getEmail() == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)     // code: 400
                .body("User cannot be null");
        }
        if (service.addUser(user)) {
            return ResponseEntity
                .status(HttpStatus.OK)      
                .body("User added successfully");
        }
        return ResponseEntity
                .status(HttpStatus.CONFLICT)        // code: 409
                .body("User already exists");
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@RequestBody User user) {
        if (user == null || user.getEmail() == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)     // code: 400
                .body("Invalid name or email");
        }
        User fetchedUser = service.loginUser(user);
        if (fetchedUser != null) {
            /*
            // Script that fetches user data from the server saves it in the local storage
            So we have to return the user data from here
                const data = await response.json();
                localStorage.setItem('firstName', data.firstName);
                localStorage.setItem('lastName', data.lastName);
                localStorage.setItem('email', data.email);
                localStorage.setItem('address', data.address);
             */
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(fetchedUser);     // I'm Sending User data in the body

        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)   // code: 404
                .body("User not found with this email and password !");
    }


}
