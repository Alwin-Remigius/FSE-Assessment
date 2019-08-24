package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book
{
	@Id
	@Column(name = "bookId")
	private Integer bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private double price;
	
	@Column(name = "publishDate")
	private String publishDate;
	

	@Column(name = "volume")
	private Integer volume;


	
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * @param bookId
	 * @param title
	 * @param price
	 * @param volume
	 * @param publishDate
	 * @param kB
	 */
	public Book(Integer bookId, String title, double price, Integer volume, String publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
		public Book() {
			
		}
	
	

}