package com.anthony.MovieDB.resource;

import com.anthony.MovieDB.model.Poster;
import com.anthony.MovieDB.model.Response;
import com.anthony.MovieDB.service.implementation.PosterServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/title/poster")
@RequiredArgsConstructor
public class PosterResource {
    private final PosterServiceImplementation posterService;

    @GetMapping("")
    public ResponseEntity<Response> getAllPoster() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("posters", posterService.getAllPosters()))
                        .message(("Posters retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPoster(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("poster", posterService.getPoster(id)))
                        .message(("Poster retrieved"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/{title_id}")
    public ResponseEntity<Response> savePoster(@PathVariable("title_id") Long movie_id, @RequestBody @Valid Poster poster) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("poster", posterService.createPoster(movie_id, poster)))
                        .message(("Poster created"))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/{title_id}")
    public ResponseEntity<Response> updatePoster(@PathVariable("title_id") Long title_id, @RequestBody @Valid Poster posterRequest) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("poster", posterService.updatePoster(title_id, posterRequest)))
                        .message(("Poster updated"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePoster(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", posterService.deletePoster(id)))
                        .message(("Poster deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
