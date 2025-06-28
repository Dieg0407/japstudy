package com.dieg0407.japstudy.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dieg0407.japstudy.model.Card;

public interface HiraganaService {
    Optional<Card> random(List<String> exclude);

    List<Card> all();

    @Service
    public static class HiraganaServiceImpl implements HiraganaService {
        private static final Map<String, Card> hiraganaMap;
        static {
            hiraganaMap = new LinkedHashMap<>();
            hiraganaMap.put("あ", new Card("あ", "a", Optional.of("a")));
            hiraganaMap.put("い", new Card("い", "i", Optional.of("i")));
            hiraganaMap.put("う", new Card("う", "u", Optional.of("u")));
            hiraganaMap.put("え", new Card("え", "e", Optional.of("e")));
            hiraganaMap.put("お", new Card("お", "o", Optional.of("o")));
            hiraganaMap.put("か", new Card("か", "ka", Optional.of("ka")));
            hiraganaMap.put("き", new Card("き", "ki", Optional.of("ki")));
            hiraganaMap.put("く", new Card("く", "ku", Optional.of("ku")));
            hiraganaMap.put("け", new Card("け", "ke", Optional.of("ke")));
            hiraganaMap.put("こ", new Card("こ", "ko", Optional.of("ko")));
            hiraganaMap.put("さ", new Card("さ", "sa", Optional.of("sa")));
            hiraganaMap.put("し", new Card("し", "shi", Optional.of("shi")));
            hiraganaMap.put("す", new Card("す", "su", Optional.of("su")));
            hiraganaMap.put("せ", new Card("せ", "se", Optional.of("se")));
            hiraganaMap.put("そ", new Card("そ", "so", Optional.of("so")));
            hiraganaMap.put("た", new Card("た", "ta", Optional.of("ta")));
            hiraganaMap.put("ち", new Card("ち", "chi", Optional.of("chi")));
            hiraganaMap.put("つ", new Card("つ", "tsu", Optional.of("tsu")));
            hiraganaMap.put("て", new Card("て", "te", Optional.of("te")));
            hiraganaMap.put("と", new Card("と", "to", Optional.of("to")));
            hiraganaMap.put("な", new Card("な", "na", Optional.of("na")));
            hiraganaMap.put("に", new Card("に", "ni", Optional.of("ni")));
            hiraganaMap.put("ぬ", new Card("ぬ", "nu", Optional.of("nu")));
            hiraganaMap.put("ね", new Card("ね", "ne", Optional.of("ne")));
            hiraganaMap.put("の", new Card("の", "no", Optional.of("no")));
            hiraganaMap.put("は", new Card("は", "ha", Optional.of("ha")));
            hiraganaMap.put("ひ", new Card("ひ", "hi", Optional.of("hi")));
            hiraganaMap.put("ふ", new Card("ふ", "fu", Optional.of("fu")));
            hiraganaMap.put("へ", new Card("へ", "he", Optional.of("he")));
            hiraganaMap.put("ほ", new Card("ほ", "ho", Optional.of("ho")));
            hiraganaMap.put("ま", new Card("ま", "ma", Optional.of("ma")));
            hiraganaMap.put("み", new Card("み", "mi", Optional.of("mi")));
            hiraganaMap.put("む", new Card("む", "mu", Optional.of("mu")));
            hiraganaMap.put("め", new Card("め", "me", Optional.of("me")));
            hiraganaMap.put("も", new Card("も", "mo", Optional.of("mo")));
            hiraganaMap.put("や", new Card("や", "ya", Optional.of("ya")));
            hiraganaMap.put("ゆ", new Card("ゆ", "yu", Optional.of("yu")));
            hiraganaMap.put("よ", new Card("よ", "yo", Optional.of("yo")));
            hiraganaMap.put("ら", new Card("ら", "ra", Optional.of("ra")));
            hiraganaMap.put("り", new Card("り", "ri", Optional.of("ri")));
            hiraganaMap.put("る", new Card("る", "ru", Optional.of("ru")));
            hiraganaMap.put("れ", new Card("れ", "re", Optional.of("re")));
            hiraganaMap.put("ろ", new Card("ろ", "ro", Optional.of("ro")));
            hiraganaMap.put("わ", new Card("わ", "wa", Optional.of("wa")));
            hiraganaMap.put("を", new Card("を", "wo", Optional.of("wo")));
            hiraganaMap.put("ん", new Card("ん", "n", Optional.of("n")));

            hiraganaMap.put("が", new Card("が", "ga", Optional.of("ga")));
            hiraganaMap.put("ぎ", new Card("ぎ", "gi", Optional.of("gi")));
            hiraganaMap.put("ぐ", new Card("ぐ", "gu", Optional.of("gu")));
            hiraganaMap.put("げ", new Card("げ", "ge", Optional.of("ge")));
            hiraganaMap.put("ご", new Card("ご", "go", Optional.of("go")));
            hiraganaMap.put("ざ", new Card("ざ", "za", Optional.of("za")));
            hiraganaMap.put("じ", new Card("じ", "ji", Optional.of("ji")));
            hiraganaMap.put("ず", new Card("ず", "zu", Optional.of("zu")));
            hiraganaMap.put("ぜ", new Card("ぜ", "ze", Optional.of("ze")));
            hiraganaMap.put("ぞ", new Card("ぞ", "zo", Optional.of("zo")));
            hiraganaMap.put("だ", new Card("だ", "da", Optional.of("da")));
            hiraganaMap.put("ぢ", new Card("ぢ", "ji", Optional.of("ji")));
            hiraganaMap.put("づ", new Card("づ", "zu", Optional.of("zu")));
            hiraganaMap.put("で", new Card("で", "de", Optional.of("de")));
            hiraganaMap.put("ど", new Card("ど", "do", Optional.of("do")));
            hiraganaMap.put("ば", new Card("ば", "ba", Optional.of("ba")));
            hiraganaMap.put("び", new Card("び", "bi", Optional.of("bi")));
            hiraganaMap.put("ぶ", new Card("ぶ", "bu", Optional.of("bu")));
            hiraganaMap.put("べ", new Card("べ", "be", Optional.of("be")));
            hiraganaMap.put("ぼ", new Card("ぼ", "bo", Optional.of("bo")));
            hiraganaMap.put("ぱ", new Card("ぱ", "pa", Optional.of("pa")));
            hiraganaMap.put("ぴ", new Card("ぴ", "pi", Optional.of("pi")));
            hiraganaMap.put("ぷ", new Card("ぷ", "pu", Optional.of("pu")));
            hiraganaMap.put("ぺ", new Card("ぺ", "pe", Optional.of("pe")));
            hiraganaMap.put("ぽ", new Card("ぽ", "po", Optional.of("po")));

            // combinations
            hiraganaMap.put("きゃ", new Card("きゃ", "kya", Optional.of("kya")));
            hiraganaMap.put("きゅ", new Card("きゅ", "kyu", Optional.of("kyu")));
            hiraganaMap.put("きょ", new Card("きょ", "kyo", Optional.of("kyo")));
            hiraganaMap.put("しゃ", new Card("しゃ", "sha", Optional.of("sha")));
            hiraganaMap.put("しゅ", new Card("しゅ", "shu", Optional.of("shu")));
            hiraganaMap.put("しょ", new Card("しょ", "sho", Optional.of("sho")));
            hiraganaMap.put("ちゃ", new Card("ちゃ", "cha", Optional.of("cha")));
            hiraganaMap.put("ちゅ", new Card("ちゅ", "chu", Optional.of("chu")));
            hiraganaMap.put("ちょ", new Card("ちょ", "cho", Optional.of("cho")));
            hiraganaMap.put("にゃ", new Card("にゃ", "nya", Optional.of("nya")));
            hiraganaMap.put("にゅ", new Card("にゅ", "nyu", Optional.of("nyu")));
            hiraganaMap.put("にょ", new Card("にょ", "nyo", Optional.of("nyo")));
            hiraganaMap.put("ひゃ", new Card("ひゃ", "hya", Optional.of("hya")));
            hiraganaMap.put("ひゅ", new Card("ひゅ", "hyu", Optional.of("hyu")));
            hiraganaMap.put("ひょ", new Card("ひょ", "hyo", Optional.of("hyo")));
            hiraganaMap.put("みゃ", new Card("みゃ", "mya", Optional.of("mya")));
            hiraganaMap.put("みゅ", new Card("みゅ", "myu", Optional.of("myu")));
            hiraganaMap.put("みょ", new Card("みょ", "myo", Optional.of("myo")));
            hiraganaMap.put("りゃ", new Card("りゃ", "rya", Optional.of("rya")));
            hiraganaMap.put("りゅ", new Card("りゅ", "ryu", Optional.of("ryu")));
            hiraganaMap.put("りょ", new Card("りょ", "ryo", Optional.of("ryo")));
            hiraganaMap.put("ぎゃ", new Card("ぎゃ", "gya", Optional.of("gya")));
            hiraganaMap.put("ぎゅ", new Card("ぎゅ", "gyu", Optional.of("gyu")));
            hiraganaMap.put("ぎょ", new Card("ぎょ", "gyo", Optional.of("gyo")));
            hiraganaMap.put("じゃ", new Card("じゃ", "ja", Optional.of("ja")));
            hiraganaMap.put("じゅ", new Card("じゅ", "ju", Optional.of("ju")));
            hiraganaMap.put("じょ", new Card("じょ", "jo", Optional.of("jo")));
            hiraganaMap.put("びゃ", new Card("びゃ", "bya", Optional.of("bya")));
            hiraganaMap.put("びゅ", new Card("びゅ", "byu", Optional.of("byu")));
            hiraganaMap.put("びょ", new Card("びょ", "byo", Optional.of("byo")));
            hiraganaMap.put("ぴゃ", new Card("ぴゃ", "pya", Optional.of("pya")));
            hiraganaMap.put("ぴゅ", new Card("ぴゅ", "pyu", Optional.of("pyu")));
            hiraganaMap.put("ぴょ", new Card("ぴょ", "pyo", Optional.of("pyo")));
        }

        @Override
        public Optional<Card> random(List<String> exclude) {
            if (exclude.size() == hiraganaMap.size()) {
                return Optional.empty();
            }

            final List<Card> possibleCards = hiraganaMap.values().stream()
                    .filter(card -> !exclude.contains(card.character()))
                    .toList();

            int randomIndex = (int) (Math.random() * possibleCards.size());
            if (randomIndex > possibleCards.size() - 1) {
                randomIndex = possibleCards.size() - 1;
            } else if (randomIndex < 0) {
                randomIndex = 0;
            }
            return Optional.of(possibleCards.get(randomIndex));
        }

        @Override
        public List<Card> all() {
            return hiraganaMap.values().stream()
                    .toList();
        }

    }
}
