package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("products", productsService.getAll());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productsService.add(product);
        return "redirect:/";
    }

//    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
//    public String viewProduct(@PathVariable(value = "id") int id, Model model) {
//        model.addAttribute("product", productsService.getById(id));
//        return "view";
//    }
//или так
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewProduct(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        modelAndView.addObject("product", productsService.getById(id));
        return modelAndView;
    }
//Объясните, пожалуйста, в каких случаях применение ModelAndView имеет смысл
}
