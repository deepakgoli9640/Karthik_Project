package karthik.project.Service;

import karthik.project.Entity.Product;
import karthik.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product){

        return productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product findByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public List<Product> findByName(String name){

        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
    public Product updateProduct(Product product, Long id) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setName(product.getName());
                    p.setBarcode(product.getBarcode());
                    p.setPrice(product.getPrice());
                    p.setQuantity(product.getQuantity());
                    p.setImageUrl(product.getImageUrl());
                    p.setCategory(product.getCategory());
                    return productRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
