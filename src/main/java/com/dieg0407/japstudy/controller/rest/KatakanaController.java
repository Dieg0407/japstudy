package com.dieg0407.japstudy.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dieg0407.japstudy.model.Card;
import com.dieg0407.japstudy.service.KatakanaService;

@RestController
@RequestMapping("/api/v1/katakana")
public class KatakanaController {
    private final KatakanaService katakanaService;

    public KatakanaController(final KatakanaService katakanaService) {
        this.katakanaService = katakanaService;
    }

    @GetMapping(path = "/random", produces = "application/json;charset=UTF-8")
    public Card random(
            @RequestParam(value = "exclude", required = false) List<String> exclude) {
        Optional<Card> randomCard;
        if (exclude == null || exclude.isEmpty()) {
            randomCard = katakanaService.random(List.of());
        } else {
            randomCard = katakanaService.random(exclude);
        }

        if (randomCard.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204), "No more cards available");
        }

        return randomCard.get();
    }

    @GetMapping(path = "/all", produces = "application/json;charset=UTF-8")
    public List<Card> all() {
        return katakanaService.all();
    }
}
