package com.grocerystore.service;

import com.grocerystore.dto.ProductDto;
import com.grocerystore.entity.Product;
import com.grocerystore.mapper.ProductMapper;
import com.grocerystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public ProductDto save(ProductDto productDto) {
        return ProductMapper.productToProductDto(productRepository.save(ProductMapper.productDtoToProduct(productDto)));
    }

    public Product deleteById(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return product;
    }

    public ProductDto updateById(Long id, ProductDto productDto) {

        if (productRepository.findById(id).isPresent()) {
            ProductDto notUpdatedProduct = ProductMapper.productToProductDto(productRepository.findById(id).get());
            ProductDto updatedProduct = new ProductDto();


            updatedProduct.setProductId(id);

            if (productDto.getProductName() == null) {
                updatedProduct.setProductName(notUpdatedProduct.getProductName());
            } else {
                updatedProduct.setProductName(productDto.getProductName());
            }

            if (productDto.getProductPrice() == null) {
                updatedProduct.setProductPrice(notUpdatedProduct.getProductPrice());
            } else {
                updatedProduct.setProductPrice(productDto.getProductPrice());
            }

            if (productDto.getProductWeight() == null) {
                updatedProduct.setProductWeight(notUpdatedProduct.getProductWeight());
            } else {
                updatedProduct.setProductWeight(productDto.getProductWeight());
            }
            return save(updatedProduct);

        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
