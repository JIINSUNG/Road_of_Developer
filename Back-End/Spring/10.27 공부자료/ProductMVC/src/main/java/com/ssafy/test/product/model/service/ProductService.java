package com.ssafy.test.product.model.service;

import java.util.List;

import com.ssafy.test.product.model.dto.Product;

public interface ProductService {
	void regist(Product product);

	void remove(String code);

	Product search(String code);

	List<Product> searchAll();
}
