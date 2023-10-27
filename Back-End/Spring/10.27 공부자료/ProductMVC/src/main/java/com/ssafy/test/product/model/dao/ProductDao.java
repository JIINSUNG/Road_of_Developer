package com.ssafy.test.product.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.product.model.dto.Product;

public interface ProductDao {
	void regist(Product product) throws SQLException;

	void remove(String code) throws SQLException;

	Product search(String code) throws SQLException;

	List<Product> searchAll() throws SQLException;
}
