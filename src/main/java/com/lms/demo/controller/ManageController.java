package com.lms.demo.controller;


import com.lms.demo.service.BookService;
import com.lms.demo.service.BorrowService;
import com.lms.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BorrowService borrowService;
    @GetMapping("/add-book")
    protected String showAddBookPage(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("nickname", userDetails.getUsername());
        return "add-book";
    }

    @PostMapping("/add-book")
    protected String handleAddBook(@RequestParam("title") String name, @RequestParam("price") double price){
        bookService.addBookInfo(name,price);
        return "redirect:/book";

    }
    @GetMapping("/add-borrow")
    protected String showAddBorrowPage(Authentication authentication,Model model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("nickname", userDetails.getUsername());
        model.addAttribute("book_list",bookService.getUncheckedBook());
        model.addAttribute("student_list",studentService.getAll());
        return "add-borrow";
    }

    @PostMapping("/add-borrow")
    protected String handleAddBorrow(@RequestParam("student") String sid, @RequestParam("book") String bid) {
        if (bid!=null&&sid!=null&&borrowService.addBorrowInfo(bid,sid)) {
            return "redirect:/index";
        }
        else {
            return "redirect:/index";
        }

    }
    @GetMapping("/delete-book")
    protected String showDeleteBookPage(@RequestParam("bid") String id){
        if (bookService.deleteBookInfo(id)) {
            return "redirect:/book";
        }
        return "redirect:/book";

    }
    @GetMapping("/return-book")
    protected String showDeleteBorrowPage(@RequestParam("id") String id){
        if (borrowService.deleteBorrowInfo(id)) {
            return "redirect:/index";
        }
        return "redirect:/index";
    }

}
