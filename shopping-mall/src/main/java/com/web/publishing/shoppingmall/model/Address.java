package com.web.publishing.shoppingmall.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address_db")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private User userId;
    private String tellNumber;
    private String address;

}
