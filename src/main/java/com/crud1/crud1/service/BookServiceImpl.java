package com.crud1.crud1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.crud1.crud1.domain.Book;
import com.crud1.crud1.dto.BookDTO;
import com.crud1.crud1.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    
    @Override
    public Long bookregister(BookDTO bookdto) {
        Book book = modelMapper.map(bookdto, Book.class);
        Long bookno = bookRepository.save(book).getBookno();
        return bookno;
    }
    
    @Override
    public List<BookDTO> getBooklist(){
        List<Book> bookDTOs = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : bookDTOs){
            BookDTO bookDTO = BookDTO.builder()
            .bookno(book.getBookno())
            .bookname(book.getBookname())
            .bookauthor(book.getBookauthor())
            .bookcontent(book.getBookcontent())
            .bookregdate(book.getBookregdate())
            .bookmoddate(book.getBookmoddate())
            .build();
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public void bookremove(Long bookno) {
        bookRepository.deleteById(bookno);
    }
    @Override
    public void bookmodify(BookDTO bookdto) {
        Optional<Book> result = bookRepository.findById(bookdto.getBookno());
        Book book = result.orElseThrow();
        book.bookchange(bookdto.getBookname(), bookdto.getBookcontent(),bookdto.getBookauthor());
        bookRepository.save(book);
    }



}
