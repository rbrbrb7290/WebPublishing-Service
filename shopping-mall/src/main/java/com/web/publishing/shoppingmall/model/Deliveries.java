package com.web.publishing.shoppingmall.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="deliveries_db")
public class Deliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressId;
    private String addressUserId;
    private String orderId;
    private String orderUserId;

}
