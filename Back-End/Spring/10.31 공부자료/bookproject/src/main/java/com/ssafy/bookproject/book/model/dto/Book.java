package com.ssafy.bookproject.book.model.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiParam(value = "책 고유번호", required = true)
	private String isbn;
	@ApiParam(value = "책 제목")
	private String title;
	@ApiParam(value="책 저자")
	private String author;
	@ApiParam(value="책 가격")
	private int price;
	@ApiParam(value="책 설명")
	private String describ;
	@ApiParam(value="책 이미지")
	private String img;

	public Book() {
	}

	public Book(String isbn, String title, String author, int price, String describ, String img) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.describ = describ;
		this.img = img;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", describ="
				+ describ + ", img=" + img + "]";
	}

}
