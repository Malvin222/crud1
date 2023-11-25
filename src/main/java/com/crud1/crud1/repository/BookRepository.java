package com.crud1.crud1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud1.crud1.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
