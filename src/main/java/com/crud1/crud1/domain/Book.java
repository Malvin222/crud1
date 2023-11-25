package com.crud1.crud1.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookno;

    @Column(nullable = false)
    private String bookname;

    @Column(nullable = false)
    private String bookauthor;

    @Column(nullable = false)
    private String bookcontent;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime bookregdate; //초판발행

    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime bookmoddate;
    
    public void bookchange(String bookname, String bookauthor, String bookcontent){
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookcontent = bookcontent;
    }

}
