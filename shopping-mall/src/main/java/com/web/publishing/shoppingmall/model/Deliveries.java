package com.web.publishing.shoppingmall.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="deliveries_db")
public class Deliveries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressId;
    private String addressUserId;
    private String orderId;
    private String orderUserId;

}
