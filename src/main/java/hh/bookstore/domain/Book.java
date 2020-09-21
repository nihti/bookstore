package hh.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // muutettu AUTO:sta IDENTITY:ksi
	private Long id; // annotaatio @notnull poistettu niin rupesi toimimaan
	private String title, author;
	// private double price;
	// Id = column in a table
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null) 
			return "Book [title=" + title + ", author=" + author + ", id=" + id + "]";
		else 
			return "Book [title=" + title + ", author=" + author + ", id=" + id + "]";
	}

	
}
