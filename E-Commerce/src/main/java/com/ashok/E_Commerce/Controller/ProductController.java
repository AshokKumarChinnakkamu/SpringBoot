package com.ashok.E_Commerce.Controller;

import com.ashok.E_Commerce.Entity.Product;
import com.ashok.E_Commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
public ResponseEntity<Product> getById(@PathVariable int id){
        if(service.getById(id)!=null){
    return new ResponseEntity<>(service.getById(id),HttpStatus.OK);}
        else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
}

@PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
        Product product1=service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch (Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
}
@GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProduct(@PathVariable int productId){
        Product product=service.getById(productId);
        byte[] imageFile=product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
}

@PutMapping("product/{id}")
    public ResponseEntity<String> updateById(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile){
    Product product1= null;
    try {
        product1 = service.updateById(id,product,imageFile);
    } catch (IOException e) {
        return new ResponseEntity<>("FAILED TO UPDATE",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if(product1!=null) {
            return new ResponseEntity<>("UPDATED", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("FAILED TO UPDATE",HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        Product product=service.getById(id);
        if(product!=null){
            service.deleteById(id);
            return new ResponseEntity<>("DELETED SUCCESSFULLY",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("FAILED TO UPDATE",HttpStatus.NOT_FOUND);
        }
}
        @GetMapping("products/search")
    public ResponseEntity<List<Product>> getBySearch(@PathVariable String keyword){
        List<Product> products= (List<Product>) service.getBySearch(keyword);
        return  new ResponseEntity<>(products,HttpStatus.FOUND);

        }

}
