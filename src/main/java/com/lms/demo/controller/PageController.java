package com.lms.demo.controller;


import com.lms.demo.pojo.Borrow;
import com.lms.demo.service.BookService;
import com.lms.demo.service.BorrowService;
import com.lms.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String showBookPage(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("nickname", userDetails.getUsername());
        model.addAttribute("book_list", bookService.getBook());
        return "book"; // 返回Thymeleaf视图名称，不需要加后缀
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showStudentPage(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("nickname", userDetails.getUsername());
        model.addAttribute("student_list",studentService.getAll());
        return "student";
    }
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String showBorrowPage(Model model, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("nickname", userDetails.getUsername());
        List<Borrow> allBorrowInfo = borrowService.getAllBorrowInfo();
        if (allBorrowInfo != null) {
            model.addAttribute("borrow_list",allBorrowInfo);
            model.addAttribute("borrow_nums", allBorrowInfo.size());
        }
        model.addAttribute("book_nums", bookService.getBook().size());
        model.addAttribute("student_nums", studentService.getAll().size());


        return "index";
    }
}
