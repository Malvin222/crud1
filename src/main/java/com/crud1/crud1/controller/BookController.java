package com.crud1.crud1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud1.crud1.dto.BookDTO;
import com.crud1.crud1.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/register")
    public void bookRegisterGet(){
        log.info("=====GET book register=====");
    }

    @PostMapping("/register")
    public String bookRegisterPost(BookDTO bookdto){
        log.info("=====POST book register=====");

        bookService.bookregister(bookdto);
        return "redirect:/book/register";
    }

    @GetMapping("/list")
    public void booklist(Model model){

        List<BookDTO> bookDTOList = bookService.findAll();
        model.addAttribute("bookDTOList", bookDTOList);
        log.info("=====bookDTOList=====");
        log.info(bookDTOList);
    }
    
}
