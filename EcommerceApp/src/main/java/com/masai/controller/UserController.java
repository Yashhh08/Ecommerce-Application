package com.masai.controller;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.model.DTO.*;
import com.masai.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    USER SERVICE

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws CustomException{

        User registered = userService.registerUser(user);

        return new ResponseEntity<>(registered,HttpStatus.CREATED);

    }

    @PatchMapping("/updatePassword")
    public ResponseEntity<String> updateUserPassword(@Valid @RequestBody UserDTO userDTO) throws CustomException{

        String updated = userService.updateUserPassword(userDTO);

        return new ResponseEntity<>(updated,HttpStatus.OK);

    }


//    PRODUCT SERVICE

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll() throws CustomException{

        List<Product> products = productService.findAll();

        return new ResponseEntity<>(products,HttpStatus.OK);

    }


    @GetMapping("/product/{productName}")
    public ResponseEntity<Product> findByName(@PathVariable("productName") String productName) throws CustomException{

        Product product = productService.findByName(productName);

        return new ResponseEntity<>(product,HttpStatus.OK);

    }

    @GetMapping("/product/category/{categoryName}")
    public ResponseEntity<List<Product>> findByCategoryName(@PathVariable("categoryName") String categoryName) throws CustomException{

        List<Product> products = productService.findByCategoryName(categoryName);

        return new ResponseEntity<>(products,HttpStatus.OK);

    }


}

