package pl.paw.cinema.utils.enums;

import lombok.Getter;

@Getter
public enum MovieGenreEnum {
    COMEDY(3, "Komedia"),
    ACTION(1, "Akcji"),
    HORROR(2, "Horror"),
    ADVENTURE(4, "Przygodowy"),
    THRILLER(5, "Thriller"),
    FAMILY_MOVIE(6, "Film familijny");

    private final int number;
    private final String name;

    MovieGenreEnum(int number, String name){
        this.number = number;
        this.name = name;
    }

    private String getName(){
        return name;
    }

    private int getNumber(){
        return number;
    }
}