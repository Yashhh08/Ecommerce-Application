package com.masai.service;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.repositery.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.parameters.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Product add(Product product, String categoryName) throws CustomException {

        Optional<Product> productExist = productRepo.findByProductName(product.getProductName());

        if(productExist.isPresent())
        {
            throw new CustomException("product "+product.getProductName().toUpperCase()+" already exist");
        }
        else
        {
            Category category = categoryRepo.findByCategoryName(categoryName).orElseThrow(()->new CustomException("Category "+categoryName.toUpperCase()+" does not exist"));

            category.getProducts().add(product);

            product.setCategory(category);

            return productRepo.save(product);
        }

    }

    @Override
    public Product delete(String productName) throws CustomException {

        Product product = productRepo.findByProductName(productName).orElseThrow(()->new CustomException(productName+" does not exist"));

        productRepo.delete(product);

        return product;

    }

    @Override
    public Product update(String productName, Product product) throws CustomException {

        Product exist = productRepo.findByProductName(productName).orElseThrow(()->new CustomException(productName+" does not exist"));

        product.setProductID(exist.getProductID());

        return productRepo.save(product);

    }

    @Override
    public List<Product> findAll() throws CustomException {

        List<Product> products = productRepo.findAll();

        if(products.isEmpty())
        {
            throw new CustomException("No products found");
        }
        else
        {
            return products;
        }

    }

    @Override
    public Product findByName(String productName) throws CustomException {

        Product exist = productRepo.findByProductName(productName).orElseThrow(()->new CustomException(productName+" does not exist"));

        return exist;

    }

    @Override
    public List<Product> findByCategoryName(String categoryName) throws CustomException {

        Category category = categoryRepo.findByCategoryName(categoryName).orElseThrow(()->new CustomException("Category "+categoryName.toUpperCase()+" does not exist"));

        List<Product> products = productRepo.findByCategory(category);

        if(products.isEmpty())
        {
            throw new CustomException("No product found");
        }
        else
        {
            return products;
        }

    }
}
