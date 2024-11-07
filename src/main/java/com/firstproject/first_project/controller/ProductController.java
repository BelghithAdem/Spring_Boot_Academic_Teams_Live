package com.firstproject.first_project.controller;

import com.firstproject.first_project.model.Product;
import com.firstproject.first_project.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        Product product1 = new Product();
        model.addAttribute("ProductForm", product1);
        return "New_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("ProductForm") Product product1) {
        productService.createProduct(product1);
        return "redirect:/all";
    }

    @RequestMapping("/all")
    public String listProducts(Model model) {
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "liste_products";
    }

    // Edit Product Form
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        } else {
            return "redirect:/all"; // Redirect if the product is not found
        }
        return "update_product";
    }

    // Update Product
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        productService.updateProduct(id, product);  // Assuming updateProduct method exists in ProductService
        return "redirect:/all";
    }

    // Delete Product
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/all";
    }
}
