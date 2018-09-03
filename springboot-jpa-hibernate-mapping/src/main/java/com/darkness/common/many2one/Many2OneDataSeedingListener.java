package com.darkness.common.many2one;

import com.darkness.entity.many2one.Category;
import com.darkness.entity.many2one.Product;
import com.darkness.service.many2one.CategoryService;
import com.darkness.service.many2one.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Component
public class Many2OneDataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Save data
        saveDataWithCategory();
        //saveDataWithProduct();

        //get data
        List<Category> categories = categoryService.findAll();
        categories.forEach(System.out::println);
        List<Product> products = productService.findAll();
        products.forEach(System.out::println);
    }

    private void saveDataWithCategory() {
        // Category
        Category phone = new Category("Phone");
        Category laptop = new Category("Laptop");

        // Product
        Product iphone = new Product("IphoneX", 100.0d, phone);
        Product samsung = new Product("Note-8", 50.5, phone);
        Product macbook = new Product("Macbook Pro 2018", 200.7, laptop);
        Product dell = new Product("Dell XXX", 140.3, laptop);

        // save mock data
        phone.setProducts(new HashSet<Product>() {{
            add(iphone);
            add(samsung);
        }});
        laptop.setProducts(new HashSet<Product>() {{
            add(macbook);
            add(dell);
        }});

        categoryService.save(phone);
        categoryService.save(laptop);
    }

    private void saveDataWithProduct() {
        // Category
        Category phone = new Category("Phone");
        Category laptop = new Category("Laptop");
        // Save categories
        categoryService.save(phone);
        categoryService.save(laptop);

        // Product
        Product iphone = new Product("IphoneX", 100.0d, phone);
        Product samsung = new Product("Note-8", 50.5, phone);
        Product macbook = new Product("Macbook Pro 2018", 200.7, laptop);
        Product dell = new Product("Dell XXX", 140.3, laptop);
        // Save product
        productService.save(iphone);
        productService.save(samsung);
        productService.save(macbook);
        productService.save(dell);
    }
}
