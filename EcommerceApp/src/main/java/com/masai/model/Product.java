package com.masai.model;

import com.fasterxml.jackson.annotation.*;
import com.masai.model.DTO.*;
import lombok.*;
import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productID;

    @NotNull
//    @URL
    private String imageURL;

    @NotNull
    private String productName;

    @NotNull
    private String description;

    @NotNull
    private Integer price;

    @ManyToOne
    @JsonIgnore
    private Category category;

}
