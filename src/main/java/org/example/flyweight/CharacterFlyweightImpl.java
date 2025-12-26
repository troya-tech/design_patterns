package org.example.flyweight;

public class CharacterFlyweightImpl implements CharacterFlyweight {

    // intrinsic state (shared)
    private final char character;
    private final String font;
    private final int fontSize;

    public CharacterFlyweightImpl(char character, String font, int fontSize) {
        this.character = character;
        this.font = font;
        this.fontSize = fontSize;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println(
                "Drawing '" + character + "' with font=" + font +
                        ", size=" + fontSize +
                        " at (" + x + "," + y + ")"
        );
    }
}
