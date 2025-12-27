package com.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFlyweightFactory {

    private static final Map<String, CharacterFlyweight> CACHE = new HashMap<>();

    public static CharacterFlyweight getCharacter(
            char character, String font, int fontSize) {

        String key = character + "-" + font + "-" + fontSize;

        if (!CACHE.containsKey(key)) {
            CACHE.put(
                    key,
                    new CharacterFlyweightImpl(character, font, fontSize)
            );
        }

        return CACHE.get(key);
    }

    public static int cacheSize() {
        return CACHE.size();
    }
}
