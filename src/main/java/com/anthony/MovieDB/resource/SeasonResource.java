package com.anthony.MovieDB.resource;

import com.anthony.MovieDB.model.Response;
import com.anthony.MovieDB.model.Season;
import com.anthony.MovieDB.service.implementation.SeasonServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/title/season")
@RequiredArgsConstructor
public class SeasonResource {
    private final SeasonServiceImplementation seasonService;


    @PostMapping("/{title_id}")
    public ResponseEntity<Response> saveSeason(@PathVariable("title_id") Long title_id, @RequestBody @Valid Season season) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("season", seasonService.createSeason(title_id, season)))
                        .message(("Season created"))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteSeason(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", seasonService.deleteSeason(id)))
                        .message(("Season deleted"))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
