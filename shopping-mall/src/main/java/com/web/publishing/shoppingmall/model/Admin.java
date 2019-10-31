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
@Table(name="admin_db")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String adminId;
    private String adminPassword;
    @Transient
    private String confirmPassword;
    private String name;

}
