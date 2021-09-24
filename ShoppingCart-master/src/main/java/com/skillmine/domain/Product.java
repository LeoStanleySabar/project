package com.skillmine.domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title", length = 10485760)
	private String title;

	@Column(name = "category", length = 10485760)
	private String category;

	@Column(name = "image", length = 10485760)
	private String image;

	@Column(name = "description", length = 10485760)
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "rating")
	private Float rating;

	public Product() {

	}

	public Product(String title, String category, String image, String description,
			Double price, Float rating) {
		super();
		this.title = title;
		this.category = category;
		this.image = image;
		this.description = description;
		this.price = price;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

}
