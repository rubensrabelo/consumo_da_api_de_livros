package com.course.api.book.data.dto;

import com.course.api.book.model.Book;

import java.util.List;

public record ApiResponse(
        List<Book> results
) {
}
