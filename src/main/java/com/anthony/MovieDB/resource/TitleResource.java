package com.anthony.MovieDB.resource;

import com.anthony.MovieDB.model.Title;
import com.anthony.MovieDB.model.Response;
import com.anthony.MovieDB.service.implementation.TitleServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/title")
@RequiredArgsConstructor
public class TitleResource {
    private final TitleServiceImplementation titleService;

    @GetMapping("/movies")
    public ResponseEntity<Response> getAllMovies() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("movies", titleService.getAllMovies()))
                        .message(("Movies retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/shows")
    public ResponseEntity<Response> getAllShows() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("shows", titleService.getAllShows()))
                        .message(("Shows retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getTitle(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("title", titleService.getTitle(id)))
                        .message(("Title retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("")
    public ResponseEntity<Response> saveTitle(@RequestBody @Valid Title title) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("title", titleService.createTitle(title)))
                        .message(("Title created"))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateTitle(@PathVariable("id") Long id, @RequestBody @Valid Title titleRequest) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("title", titleService.updateTitle(id, titleRequest)))
                        .message(("Title updated"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTitle(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", titleService.deleteTitle(id)))
                        .message(("Title deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/{title_id}/genre")
    public ResponseEntity<Response> putGenresInTitle(@PathVariable("title_id") Long title_id, @RequestBody @Valid HashMap<String, ArrayList<Long>> genres_ids) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("title", titleService.putGenresInTitle(title_id, genres_ids)))
                        .message(("Gender in title associeted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{title_id}/genre")
    public ResponseEntity<Response> deleteGenresInTitle(@PathVariable("title_id") Long title_id, @RequestBody @Valid HashMap<String, ArrayList<Long>> genres_ids) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", titleService.deleteGenresInTitle(title_id, genres_ids)))
                        .message(("Gender in movie deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
