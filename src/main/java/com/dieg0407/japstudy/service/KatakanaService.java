package com.dieg0407.japstudy.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dieg0407.japstudy.model.Card;

public interface KatakanaService {
    /**
     * Returns a random Katakana card, excluding the characters specified in the
     * exclude list.
     *
     * @param exclude List of characters to exclude from the random selection.
     * @return An Optional containing a random Katakana card, or an empty Optional
     *         if no cards are available.
     */
    Optional<Card> random(List<String> exclude);

    /**
     * Returns all available Katakana cards.
     *
     * @return A list of all Katakana cards.
     */
    List<Card> all();

    @Service
    public static class KatakanaServiceImpl implements KatakanaService {

        private static final Map<String, Card> katakanaMap;

        static {
            katakanaMap = new LinkedHashMap<>();
            katakanaMap.put("ア", new Card("ア", "a", Optional.of("a")));
            katakanaMap.put("イ", new Card("イ", "i", Optional.of("i")));
            katakanaMap.put("ウ", new Card("ウ", "u", Optional.of("u")));
            katakanaMap.put("エ", new Card("エ", "e", Optional.of("e")));
            katakanaMap.put("オ", new Card("オ", "o", Optional.of("o")));
            katakanaMap.put("カ", new Card("カ", "ka", Optional.of("ka")));
            katakanaMap.put("キ", new Card("キ", "ki", Optional.of("ki")));
            katakanaMap.put("ク", new Card("ク", "ku", Optional.of("ku")));
            katakanaMap.put("ケ", new Card("ケ", "ke", Optional.of("ke")));
            katakanaMap.put("コ", new Card("コ", "ko", Optional.of("ko")));
            katakanaMap.put("サ", new Card("サ", "sa", Optional.of("sa")));
            katakanaMap.put("シ", new Card("シ", "shi", Optional.of("shi")));
            katakanaMap.put("ス", new Card("ス", "su", Optional.of("su")));
            katakanaMap.put("セ", new Card("セ", "se", Optional.of("se")));
            katakanaMap.put("ソ", new Card("ソ", "so", Optional.of("so")));
            katakanaMap.put("タ", new Card("タ", "ta", Optional.of("ta")));
            katakanaMap.put("チ", new Card("チ", "chi", Optional.of("chi")));
            katakanaMap.put("ツ", new Card("ツ", "tsu", Optional.of("tsu")));
            katakanaMap.put("テ", new Card("テ", "te", Optional.of("te")));
            katakanaMap.put("ト", new Card("ト", "to", Optional.of("to")));
            katakanaMap.put("ナ", new Card("ナ", "na", Optional.of("na")));
            katakanaMap.put("ニ", new Card("ニ", "ni", Optional.of("ni")));
            katakanaMap.put("ヌ", new Card("ヌ", "nu", Optional.of("nu")));
            katakanaMap.put("ネ", new Card("ネ", "ne", Optional.of("ne")));
            katakanaMap.put("ノ", new Card("ノ", "no", Optional.of("no")));
            katakanaMap.put("ハ", new Card("ハ", "ha", Optional.of("ha")));
            katakanaMap.put("ヒ", new Card("ヒ", "hi", Optional.of("hi")));
            katakanaMap.put("フ", new Card("フ", "fu", Optional.of("fu")));
            katakanaMap.put("ヘ", new Card("ヘ", "he", Optional.of("he")));
            katakanaMap.put("ホ", new Card("ホ", "ho", Optional.of("ho")));
            katakanaMap.put("マ", new Card("マ", "ma", Optional.of("ma")));
            katakanaMap.put("ミ", new Card("ミ", "mi", Optional.of("mi")));
            katakanaMap.put("ム", new Card("ム", "mu", Optional.of("mu")));
            katakanaMap.put("メ", new Card("メ", "me", Optional.of("me")));
            katakanaMap.put("モ", new Card("モ", "mo", Optional.of("mo")));
            katakanaMap.put("ヤ", new Card("ヤ", "ya", Optional.of("ya")));
            katakanaMap.put("ユ", new Card("ユ", "yu", Optional.of("yu")));
            katakanaMap.put("ヨ", new Card("ヨ", "yo", Optional.of("yo")));
            katakanaMap.put("ラ", new Card("ラ", "ra", Optional.of("ra")));
            katakanaMap.put("リ", new Card("リ", "ri", Optional.of("ri")));
            katakanaMap.put("ル", new Card("ル", "ru", Optional.of("ru")));
            katakanaMap.put("レ", new Card("レ", "re", Optional.of("re")));
            katakanaMap.put("ロ", new Card("ロ", "ro", Optional.of("ro")));
            katakanaMap.put("ワ", new Card("ワ", "wa", Optional.of("wa")));
            katakanaMap.put("ヲ", new Card("ヲ", "wo", Optional.of("wo")));
            katakanaMap.put("ン", new Card("ン", "n", Optional.of("n")));

            katakanaMap.put("ガ", new Card("ガ", "ga", Optional.of("ga")));
            katakanaMap.put("ギ", new Card("ギ", "gi", Optional.of("gi")));
            katakanaMap.put("グ", new Card("グ", "gu", Optional.of("gu")));
            katakanaMap.put("ゲ", new Card("ゲ", "ge", Optional.of("ge")));
            katakanaMap.put("ゴ", new Card("ゴ", "go", Optional.of("go")));
            katakanaMap.put("ザ", new Card("ザ", "za", Optional.of("za")));
            katakanaMap.put("ジ", new Card("ジ", "ji", Optional.of("ji")));
            katakanaMap.put("ズ", new Card("ズ", "zu", Optional.of("zu")));
            katakanaMap.put("ゼ", new Card("ゼ", "ze", Optional.of("ze")));
            katakanaMap.put("ゾ", new Card("ゾ", "zo", Optional.of("zo")));
            katakanaMap.put("ダ", new Card("ダ", "da", Optional.of("da")));
            katakanaMap.put("ヂ", new Card("ヂ", "ji", Optional.of("ji")));
            katakanaMap.put("ヅ", new Card("ヅ", "zu", Optional.of("zu")));
            katakanaMap.put("デ", new Card("デ", "de", Optional.of("de")));
            katakanaMap.put("ド", new Card("ド", "do", Optional.of("do")));
            katakanaMap.put("バ", new Card("バ", "ba", Optional.of("ba")));
            katakanaMap.put("ビ", new Card("ビ", "bi", Optional.of("bi")));
            katakanaMap.put("ブ", new Card("ブ", "bu", Optional.of("bu")));
            katakanaMap.put("ベ", new Card("ベ", "be", Optional.of("be")));
            katakanaMap.put("ボ", new Card("ボ", "bo", Optional.of("bo")));
            katakanaMap.put("パ", new Card("パ", "pa", Optional.of("pa")));
            katakanaMap.put("ピ", new Card("ピ", "pi", Optional.of("pi")));
            katakanaMap.put("プ", new Card("プ", "pu", Optional.of("pu")));
            katakanaMap.put("ペ", new Card("ペ", "pe", Optional.of("pe")));
            katakanaMap.put("ポ", new Card("ポ", "po", Optional.of("po")));

            // combinations
            katakanaMap.put("キャ", new Card("キャ", "kya", Optional.of("kya")));
            katakanaMap.put("キュ", new Card("キュ", "kyu", Optional.of("kyu")));
            katakanaMap.put("キョ", new Card("キョ", "kyo", Optional.of("kyo")));
            katakanaMap.put("シャ", new Card("シャ", "sha", Optional.of("sha")));
            katakanaMap.put("シュ", new Card("シュ", "shu", Optional.of("shu")));
            katakanaMap.put("ショ", new Card("ショ", "sho", Optional.of("sho")));
            katakanaMap.put("チャ", new Card("チャ", "cha", Optional.of("cha")));
            katakanaMap.put("チュ", new Card("チュ", "chu", Optional.of("chu")));
            katakanaMap.put("チョ", new Card("チョ", "cho", Optional.of("cho")));
            katakanaMap.put("ニャ", new Card("ニャ", "nya", Optional.of("nya")));
            katakanaMap.put("ニュ", new Card("ニュ", "nyu", Optional.of("nyu")));
            katakanaMap.put("ニョ", new Card("ニョ", "nyo", Optional.of("nyo")));
            katakanaMap.put("ヒャ", new Card("ヒャ", "hya", Optional.of("hya")));
            katakanaMap.put("ヒュ", new Card("ヒュ", "hyu", Optional.of("hyu")));
            katakanaMap.put("ヒョ", new Card("ヒョ", "hyo", Optional.of("hyo")));
            katakanaMap.put("ミャ", new Card("ミャ", "mya", Optional.of("mya")));
            katakanaMap.put("ミュ", new Card("ミュ", "myu", Optional.of("myu")));
            katakanaMap.put("ミョ", new Card("ミョ", "myo", Optional.of("myo")));
            katakanaMap.put("リャ", new Card("リャ", "rya", Optional.of("rya")));
            katakanaMap.put("リュ", new Card("リュ", "ryu", Optional.of("ryu")));
            katakanaMap.put("リョ", new Card("リョ", "ryo", Optional.of("ryo")));
            katakanaMap.put("ギャ", new Card("ギャ", "gya", Optional.of("gya")));
            katakanaMap.put("ギュ", new Card("ギュ", "gyu", Optional.of("gyu")));
            katakanaMap.put("ギョ", new Card("ギョ", "gyo", Optional.of("gyo")));
            katakanaMap.put("ジャ", new Card("ジャ", "ja", Optional.of("ja")));
            katakanaMap.put("ジュ", new Card("ジュ", "ju", Optional.of("ju")));
            katakanaMap.put("ジョ", new Card("ジョ", "jo", Optional.of("jo")));
            katakanaMap.put("ビャ", new Card("ビャ", "bya", Optional.of("bya")));
            katakanaMap.put("ビュ", new Card("ビュ", "byu", Optional.of("byu")));
            katakanaMap.put("ビョ", new Card("ビョ", "byo", Optional.of("byo")));
            katakanaMap.put("ピャ", new Card("ピャ", "pya", Optional.of("pya")));
            katakanaMap.put("ピュ", new Card("ピュ", "pyu", Optional.of("pyu")));
            katakanaMap.put("ピョ", new Card("ピョ", "pyo", Optional.of("pyo")));
        }

        @Override
        public Optional<Card> random(List<String> exclude) {
            if (exclude.size() == katakanaMap.size()) {
                return Optional.empty();
            }

            final List<Card> possibleCards = katakanaMap.values().stream()
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
            return katakanaMap.values().stream()
                    .toList();
        }
    }
}
