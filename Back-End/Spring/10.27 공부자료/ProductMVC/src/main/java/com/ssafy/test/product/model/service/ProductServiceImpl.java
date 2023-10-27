package com.ssafy.test.product.model.service;

import java.sql.SQLException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.test.ProductException;
import com.ssafy.test.product.model.dao.ProductDao;
import com.ssafy.test.product.model.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private ProductDao productDao;
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	public void regist(Product product) {
		try {
			Product find = productDao.search(product.getCode());
			if(find != null) throw new ProductException("이미 등록된 상품 정보입니다.");
			productDao.regist(product);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductException("상품 정보 등록 중 오류 발생!!!!");
		}

	}

	@Transactional
	public void remove(String code) {
		try {
			Product find = productDao.search(code);
			if(find == null) throw new ProductException("삭제할 상품 정보가 없습니다");
			productDao.remove(code);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductException("상품 정보 삭제 중 오류 발생!!!!");
		}
	}

	@Transactional(readOnly = true)
	public Product search(String code) {
		try {
			Product find = productDao.search(code);
			if(find == null) throw new ProductException("검색된 상품이 없습니다!!!!");
			return find;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductException("상품 정보 등록 중 오류 발생!!!!");
		}
		
		
	}

	@Transactional(readOnly = true)
	public List<Product> searchAll() {
		try {
			return productDao.searchAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductException("전체 상품 정보 조회 중 오류 발생");
		}		
	}



}
