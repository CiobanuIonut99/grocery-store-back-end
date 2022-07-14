package com.grocerystore.mapper;

import com.grocerystore.dto.ProductDto;
import com.grocerystore.entity.Product;

public class ProductMapper {

    public static ProductDto productToProductDto(Product product)
    {
        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productWeight(product.getProductWeight())
                .build();

    }

    public static Product productDtoToProduct(ProductDto productDto)
    {
        return Product.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .productWeight(productDto.getProductWeight())
                .build();

    }


}
