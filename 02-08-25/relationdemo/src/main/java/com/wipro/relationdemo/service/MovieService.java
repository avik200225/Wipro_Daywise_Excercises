package com.wipro.relationdemo.service;
import com.wipro.relationdemo.entity.Movie;
import com.wipro.relationdemo.entity.Genre;
import com.wipro.relationdemo.repo.MovieRepo;
import com.wipro.relationdemo.repo.GenreRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    private final MovieRepo movieRepository;
    private final GenreRepo genreRepository;

    public MovieService(MovieRepo movieRepository, GenreRepo genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie addGenreToMovie(Long movieId, Long genreId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new RuntimeException("Genre not found"));
        movie.addGenre(genre);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
