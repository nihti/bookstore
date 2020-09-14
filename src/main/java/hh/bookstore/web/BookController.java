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

import java.util.ArrayList;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepo;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", bookrepo.findAll());
		return "booklist";
	}
	
	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
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
}
