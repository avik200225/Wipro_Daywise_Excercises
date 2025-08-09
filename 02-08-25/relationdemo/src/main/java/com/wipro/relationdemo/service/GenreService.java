package com.wipro.relationdemo.service;

import com.wipro.relationdemo.entity.Genre;
import com.wipro.relationdemo.repo.GenreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepo genreRepo;

    public GenreService(GenreRepo genreRepository) {
        this.genreRepo = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepo.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepo.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    public Genre createGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    public void deleteGenre(Long id) {
        genreRepo.deleteById(id);
    }
}
