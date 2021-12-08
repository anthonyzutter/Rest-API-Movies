package com.anthony.MovieDB.resource;

import com.anthony.MovieDB.model.Genre;
import com.anthony.MovieDB.model.Response;
import com.anthony.MovieDB.service.implementation.GenreServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/title/genre")
@RequiredArgsConstructor
public class GenreResource {
    private final GenreServiceImplementation genreService;

    @GetMapping("")
    public ResponseEntity<Response> getGenres() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("genres", genreService.getAllGenres()))
                        .message(("Genres retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<Response> getGenresInMovie(@PathVariable("movie_id") Long movie_id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("genres", genreService.getAllGenresInMovie(movie_id)))
                        .message(("Genres retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getGenre(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("genre", genreService.getGenre(id)))
                        .message(("Genre retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("")
    public ResponseEntity<Response> saveGenre(@RequestBody @Valid Genre genre) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("genre", genreService.createGenre(genre)))
                        .message(("Genre created"))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> saveGenre(@PathVariable("id") Long id, @RequestBody @Valid Genre genreRequest) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("genre", genreService.updateGenre(id, genreRequest)))
                        .message(("Genre updated"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteGenre(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", genreService.deleteGenre(id)))
                        .message(("Genre deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
