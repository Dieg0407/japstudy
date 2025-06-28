package com.dieg0407.japstudy.model;

import java.util.Optional;

public record Card(String character, String romaji, Optional<String> meaning) {

}
