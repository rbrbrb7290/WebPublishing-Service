package com.web.publishing.shoppingmall.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_db")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userId;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer productId;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"userPassword", "confirmPassword"})
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"pdDate", "pdDetail" , "pdContent", "pdAmount", "pdCategory"})
    @JoinColumn(name = "product_id")
    private Product product;
    private String date;
    private Integer price;
}
