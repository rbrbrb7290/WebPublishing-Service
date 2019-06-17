package com.web.publishing.shoppingmall.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admin_db")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String adminId;
    String adminPassword;
    String name;
    String tellNumber;
    String bank;

}
