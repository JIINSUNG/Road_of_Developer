package com.ssafy.test.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.test.product.model.dto.Product;
import com.ssafy.test.product.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping("/list")
	public void list(Model model)
	{
		List<Product> products = productService.searchAll();
		model.addAttribute("products", products);
	}
	
	@GetMapping("regist")
	public void regist()
	{

	}
	
	@PostMapping("regist")
	public String regist(Product product)
	{
		productService.regist(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("detail")
	public void detail(@RequestParam("code") String code, Model model) {
		System.out.println(code);
		Product product = productService.search(code);
		System.out.println("product" + product);
		model.addAttribute("product", product);
	}
	
	@GetMapping("remove")
	public String remove(String code, Model model) {
		productService.remove(code);
		return "redirect:/product/list";
	}
}
