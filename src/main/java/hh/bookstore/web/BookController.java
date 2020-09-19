package hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.CategoryRepository;


import java.util.ArrayList;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepo;
	
	@Autowired
	private CategoryRepository caterepo;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", bookrepo.findAll());
		
		return "booklist";
	}
	
	// Add
	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", caterepo.findAll());
		return "addbook";
	}
	
    @PostMapping("/save")
    public String save(Book book){
        bookrepo.save(book);
        return "redirect:booklist";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookrepo.deleteById(bookId);
    	return "redirect:../booklist";
    }
    
    // Edit 
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", bookrepo.findById(bookId));
    	model.addAttribute("categories", caterepo.findAll());
    	return "editbook";
    }
}
