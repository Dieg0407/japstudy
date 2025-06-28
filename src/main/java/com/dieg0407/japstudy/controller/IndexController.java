package com.dieg0407.japstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hiragana")
    public String hiragana() {
        return "hiragana";
    }

    @GetMapping("/hiragana/start")
    public String hiraganaStart() {
        return "hiragana/start";
    }

    @GetMapping("/katakana")
    public String katakana() {
        return "katakana";
    }

    @GetMapping("/katakana/start")
    public String katakanaStart() {
        return "katakana/start";
    }

    @GetMapping("/kanji")
    public String kanji() {
        return "kanji";
    }
}
