package pl.paw.calc.utils.enums;

public enum MovieGenreEnum {
    ACTION(1, "Akcji"),
    HORROR(2, "Horror"),
    COMEDY(3, "Komedia"),
    ADVENTURE(4, "Przygodowy");

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
