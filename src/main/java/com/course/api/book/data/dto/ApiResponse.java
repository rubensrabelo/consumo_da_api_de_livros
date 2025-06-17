package com.course.api.book.data.dto;

import com.course.api.book.model.Book;

import java.util.List;

public record ApiResponse<T>(
        int count,
        String next,
        String previous,
        List<BookDTO> results
) {}
