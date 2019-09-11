package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductsServiceCriteria;
import com.geekbrains.services.ProductsServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private ProductsServiceCrud productsServiceCrud;
    private ProductsServiceCriteria productsServiceCriteria;

    @Autowired
    public void setProductsService(ProductsServiceCrud productsServiceCrud) {
        this.productsServiceCrud = productsServiceCrud;
    }

    @Autowired
    public void setProductsServiceCriteria(ProductsServiceCriteria productsServiceCriteria) {
        this.productsServiceCriteria = productsServiceCriteria;
    }

    @GetMapping("/")
    public String showProductsPage(Model model) {
        List<Product> productsList = productsServiceCriteria.findAll();
        model.addAttribute("products", productsList);
        return "products";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String getFormResult(Model model, @RequestParam(name = "min_price") Integer min, @RequestParam(name = "max_price") Integer max) {
//Закомментировано - использование ProductServiceCrud
//        List<Product> productsList = null;
//        if(min != null) {
//            productsList = productsServiceCrud.findByCostGreaterThanEqual(min);
//        }
//        if (max != null) {
//            productsList = productsServiceCrud.findByCostLessThanEqual(max);
//        }
//        if (min == null && max == null) {
//            productsList = productsServiceCrud.findAll();
//        }
//        if (min != null && max != null) {
//            productsList = productsServiceCrud.findByCostGreaterThanEqualAndCostLessThanEqual(min, max);
//        }
        List<Product> productsList = productsServiceCriteria.findAll(min, max);
        model.addAttribute("products", productsList);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "products";
    }
}
