package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@Service
public class ProductService {

    private ProductsRepo productsRepo;

    @Autowired
    public ProductService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public Products addProduct(Products products) {
        productsRepo.save(products);
        return products;
    }

    public List<Products> getProducts() {
        return productsRepo.findAll();
    }

    public List<Products> getAllFeaturedProducts() {
        return productsRepo.findAllByIs_featured();
    }

    public List<Products> getProductById(Long id) {
        return productsRepo.findProductsById(id);
    }

    public List<Products> searchProduct(String keyword) {
        if (keyword != null) {
            return productsRepo.searchProduct(keyword);
        }
        return productsRepo.findAll();
    }
}