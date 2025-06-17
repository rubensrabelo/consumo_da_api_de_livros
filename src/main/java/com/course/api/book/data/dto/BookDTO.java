package com.course.api.book.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        String title,
        List<AuthorDTO> authors,
        List<String> languages,
        int downloadCount
) {
}
