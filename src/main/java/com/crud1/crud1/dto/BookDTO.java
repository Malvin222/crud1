package com.crud1.crud1.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long bookno;
    private String bookname;
    private String bookauthor;
    private String bookcontent;
    private LocalDateTime bookregdate;
    private LocalDateTime bookmoddate;
}
