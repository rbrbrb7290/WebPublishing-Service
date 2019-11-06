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
@Table(name="custom_db")
public class Custom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String logoImageUrl;
    private String bankAdmin;
    private String tellNumber;
    private String bank;


//    TODO 추가 정보 조사

}
