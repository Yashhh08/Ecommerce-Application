package com.masai.service;

import com.masai.exception.*;
import com.masai.model.*;
import org.springframework.security.core.parameters.*;

import java.util.*;

public interface ProductService{

    public Product add(Product product, String categoryName) throws CustomException;

    public Product delete(String productName) throws CustomException;

    public Product update(String productName, Product product) throws CustomException;

    public List<Product> findAll() throws CustomException;

    public Product findByName(String productName) throws CustomException;

    public List<Product> findByCategoryName(String categoryName) throws CustomException;

}
