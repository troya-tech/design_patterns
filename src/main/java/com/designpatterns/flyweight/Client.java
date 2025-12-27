package com.designpatterns.flyweight;

public class Client {

    public static void main(String[] args) {

        CharacterFlyweight a1 =
                CharacterFlyweightFactory.getCharacter('A', "Arial", 12);

        CharacterFlyweight a2 =
                CharacterFlyweightFactory.getCharacter('A', "Arial", 12);

        CharacterFlyweight b =
                CharacterFlyweightFactory.getCharacter('B', "Arial", 12);

        // same flyweight instance
        System.out.println(a1 == a2); // true

        a1.draw(10, 20);
        a2.draw(30, 40);
        b.draw(50, 60);

        System.out.println(
                "Total flyweights created: " +
                        CharacterFlyweightFactory.cacheSize()
        );
    }
}
