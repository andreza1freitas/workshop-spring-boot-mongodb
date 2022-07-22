package com.andrezafreitas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrezafreitas.workshopmongo.domain.Post;
import com.andrezafreitas.workshopmongo.repository.PostRepository;
import com.andrezafreitas.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTtitle(String text) {
		return repo.searchTitle(text);
	}
}
	
