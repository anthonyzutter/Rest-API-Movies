package com.anthony.MovieDB.resource;

import com.anthony.MovieDB.model.Episode;
import com.anthony.MovieDB.model.Response;
import com.anthony.MovieDB.service.implementation.EpisodeServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/title/episode")
@RequiredArgsConstructor
public class EpisodeResource {
    private final EpisodeServiceImplementation episodeService;


    @PostMapping("/{season_id}")
    public ResponseEntity<Response> saveEpisode(@PathVariable("season_id") Long season_id, @RequestBody @Valid Episode episode) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("episode", episodeService.createEpisode(season_id, episode)))
                        .message(("Episode created"))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEpisode(@PathVariable("id") Long id, @RequestBody @Valid Episode episodeRequest) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("episode", episodeService.updateEpisode(id, episodeRequest)))
                        .message(("Episode updated"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEpisode(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", episodeService.deleteEpisode(id)))
                        .message(("Episode deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
