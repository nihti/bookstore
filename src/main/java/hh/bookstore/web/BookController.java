package hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepo;
	
	@Autowired
	private CategoryRepository caterepo;

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", bookrepo.findAll());
		
		return "booklist";
	}
	
	// REST
	@GetMapping("/rest")
	public @ResponseBody List<Book> bookListRest() {
		return (List <Book>) bookrepo.findAll();
	}
	
	// REST id
	@GetMapping("book/{id}")
		public @ResponseBody Optional<Book> findBook(@PathVariable("id") Long bookId) {
			return bookrepo.findById(bookId);
	}
	
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
    @PreAuthorize("hasRole('ADMIN')")
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
