package com.carlosarroyoam.rest.books.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.carlosarroyoam.rest.books.dtos.AuthorResponse;
import com.carlosarroyoam.rest.books.entities.Author;
import com.carlosarroyoam.rest.books.mappers.AuthorMapper;
import com.carlosarroyoam.rest.books.repositories.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final AuthorMapper authorMapper;

	public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
		this.authorRepository = authorRepository;
		this.authorMapper = authorMapper;
	}

	public List<AuthorResponse> findAll() {
		List<Author> authors = authorRepository.findAll();
		return authorMapper.toDtos(authors);
	}

	public AuthorResponse findById(Long authorId) {
		Author authorById = authorRepository.findById(authorId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));

		return authorMapper.toDto(authorById);
	}

}
