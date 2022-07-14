package com.grocerystore.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductDto {

    private Long productId;

    private String productName;

    private Double productPrice;

    private Double productWeight;


}
