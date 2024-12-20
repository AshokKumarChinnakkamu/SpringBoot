package com.ashok.E_Commerce.Service;

import com.ashok.E_Commerce.Entity.Product;
import com.ashok.E_Commerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
     ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateById(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public void deleteById(int id) {
    repo.deleteById(id);
    }

    public Product getBySearch(String keyword) {
    return (Product) repo.getBySearch(keyword);
    }
}
