package com.crud1.crud1.service;

import java.util.List;

import com.crud1.crud1.dto.BookDTO;

public interface BookService {
    Long bookregister(BookDTO bookdto);

    List<BookDTO> findAll();

    void bookremove(Long bookno);

    void bookmodify(BookDTO bookdto);

}
