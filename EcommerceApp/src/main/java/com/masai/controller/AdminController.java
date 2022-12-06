package com.masai.controller;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.model.DTO.*;
import com.masai.repositery.*;
import com.masai.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

//    USER SERVICE
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() throws CustomException{

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) throws CustomException{

        User user = userService.getUserByUsername(username);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @DeleteMapping("/deleteUser/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) throws CustomException{

        String deleted = userService.deleteUser(username);

        return new ResponseEntity<>(deleted,HttpStatus.OK);

    }


//    CATEGORY SERVICE

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws CustomException{

        Category added = categoryService.addCategory(category);

        return new ResponseEntity<>(added,HttpStatus.CREATED);

    }

    @DeleteMapping("/category/{categoryName}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("categoryName") String categoryName) throws CustomException{

        Category deleted = categoryService.deleteCategory(categoryName);

        return new ResponseEntity<>(deleted,HttpStatus.OK);

    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() throws CustomException{

        List<Category> categories = categoryService.getAllCategories();

        return new ResponseEntity<>(categories,HttpStatus.OK);

    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryName") String categoryName) throws CustomException{

        Category category = categoryService.getCategory(categoryName);

        return new ResponseEntity<>(category,HttpStatus.OK);

    }


//    PRODUCT SERVICE

    @Autowired
    private ProductService productService;

    @PostMapping("/product/{categoryName}")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product, @PathVariable("categoryName") String categoryName) throws CustomException{

        Product added = productService.add(product,categoryName);

        return new ResponseEntity<>(added,HttpStatus.CREATED);

    }

    @DeleteMapping("/product/{productName}")
    public ResponseEntity<Product> delete(@PathVariable("productName") String productName) throws CustomException{

        Product deleted = productService.delete(productName);

        return new ResponseEntity<>(deleted,HttpStatus.OK);

    }

    @PutMapping("/product/{productName}")
    public ResponseEntity<Product> update(@PathVariable("productName") String productName, @Valid @RequestBody Product product) throws CustomException{

        Product updated = productService.update(productName,product);

        return new ResponseEntity<>(updated,HttpStatus.OK);

    }

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
