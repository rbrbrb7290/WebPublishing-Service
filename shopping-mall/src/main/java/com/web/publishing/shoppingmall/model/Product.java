package com.web.publishing.shoppingmall.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_db")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pdName;
    private String pdPrice;
    private String pdAmount;
    private String pdImageUrl;
    private String pdCategory;
    private String pdDate;
    private String pdContent;
    private String pdDetail;
}
