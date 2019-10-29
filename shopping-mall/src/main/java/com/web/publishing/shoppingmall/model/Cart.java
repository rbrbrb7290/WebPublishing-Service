package com.web.publishing.shoppingmall.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_db")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name= "pd_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @OneToOne
    @JoinColumn(name = "order_user_id")
    private Order orderUserId;
    private String orderAmount;

}
