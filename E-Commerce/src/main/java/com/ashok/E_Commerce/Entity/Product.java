package com.ashok.E_Commerce.Entity;

import jakarta.persistence.*;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String ImageName;
    private String ImageType;

    @Lob
    private byte[] ImageData;

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageType() {
        return ImageType;
    }

    public void setImageType(String imageType) {
        ImageType = imageType;
    }

    public byte[] getImageData() {
        return ImageData;
    }

    public void setImageData(byte[] image) {
        ImageData = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return productAvailable;
    }

    public void setAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public int getQuantity() {
        return stockQuantity;
    }

    public void setQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
