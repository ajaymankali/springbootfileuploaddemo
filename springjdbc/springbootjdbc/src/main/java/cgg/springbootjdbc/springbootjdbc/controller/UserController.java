package cgg.springbootjdbc.springbootjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.springbootjdbc.springbootjdbc.entities.User1;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public ResponseEntity<List<User1>> getAllUsers(){
        List<User1> users =  jdbcTemplate.query("select * from User1",new BeanPropertyRowMapper<User1>(User1.class));
       return new ResponseEntity<List<User1>>(users,HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User1> addUser(@RequestBody User1 user) {
        String query = "insert into User1 (username, password, email, role) values(?, ?, ?, ?)";
        int i = jdbcTemplate.update(query, user.username(), user.password(), user.email(), user.email());
        return new ResponseEntity<User1>(user, HttpStatus.OK);
    }
    
}
