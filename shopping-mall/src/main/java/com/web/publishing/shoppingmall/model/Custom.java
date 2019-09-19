package com.web.publishing.shoppingmall.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="custom_db")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String logoImageUrl;


//    TODO 추가 정보 조사

}
