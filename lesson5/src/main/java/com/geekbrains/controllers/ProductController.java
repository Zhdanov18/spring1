package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.specifications.ProductSpecs;
import com.geekbrains.services.ProductsServicePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
    private ProductsServicePaging productsServicePaging;

    public static final int PAGE_SIZE = 2;

    @Autowired
    public void setProductsServicePaging(ProductsServicePaging productsServicePaging) {
        this.productsServicePaging = productsServicePaging;
    }

//Пагинация с использованием PagingAndSortingRepository<Product, Long>
//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public String listProducts(Model model,
//                               @RequestParam("page") Optional<Integer> page,
//                               @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(PAGE_SIZE);
//        Page<Product> productsPage = productsServicePaging.findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, "cost")));
//        model.addAttribute("productsPage", productsPage);
//        int totalPages = productsPage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        return "products";
//    }

    @GetMapping(value = "/products")
    public String productPage(Model model,
                              @RequestParam(value = "page") Optional<Integer> page,
                              @RequestParam(value = "size") Optional<Integer> size,
                              @RequestParam(value = "min", required = false) Integer min,
                              @RequestParam(value = "max", required = false) Integer max
    ) {
        final int currentPage = page.orElse(1);
        int pageSize = size.orElse(PAGE_SIZE);

        Specification<Product> spec = Specification.where(null);
        StringBuilder filters = new StringBuilder();
        if(min != null) {
            spec = spec.and(ProductSpecs.costGreaterThanOrEq(min));
            filters.append("&min=" + min);
        }
        if(max != null) {
            spec = spec.and(ProductSpecs.costLessThanOrEq(max));
            filters.append("&max=" + max);
        }

        Page<Product> productsPage = productsServicePaging.getProductsWithPagingAndFiltering(currentPage - 1, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "cost"), spec);

        model.addAttribute("productsPage", productsPage);
        model.addAttribute("filters", filters);
 //потом разобраться как в th: вытащить  из строки min и max, а пока чтобы вставали значения в поля:
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        int totalPages = productsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "products";
    }

    @GetMapping(value = "/products/edit")
    public String editPage(Model model, @RequestParam(value = "id") Long id) {
        Product product = productsServicePaging.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping(value = "/products/edit")
    public String editPage(Model model, @ModelAttribute("product") Product product) {
        productsServicePaging.update(product);
        return "redirect:/products";
    }
}
