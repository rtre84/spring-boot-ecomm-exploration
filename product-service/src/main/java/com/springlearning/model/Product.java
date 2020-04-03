package com.springlearning.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//
//@Entity
//@Table(name = "product")
//public class Product {
//
//    @Id
//    @Column(name = "id")
//    Long id;
//
//    @Column(name = "name")
//    String name;
//
//    @Column(name = "description")
//    String description;
//
//}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
