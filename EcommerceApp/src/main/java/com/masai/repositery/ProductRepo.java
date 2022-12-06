package com.masai.repositery;

import com.masai.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    public Optional<Product> findByProductName(String productName);

    public List<Product> findByCategory(Category category);

}
