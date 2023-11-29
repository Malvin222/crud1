package com.crud1.crud1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<BookDTO> findAll(){
        List<Book> bookDTOs = bookRepository.findAll();
        
        return bookDTOs.stream()
            .map(book -> modelMapper.map(book,BookDTO.class))
            .collect(Collectors.toList());
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
