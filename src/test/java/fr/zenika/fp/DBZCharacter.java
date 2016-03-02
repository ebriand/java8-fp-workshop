package fr.zenika.fp;

import java.util.Optional;

public class DBZCharacter {

    private String name;

    private String homePlanet;

    private int power;

    private Optional<String> specialMove;

    public DBZCharacter(String name, String homePlanet, int power, String specialMove) {
        this.name = name;
        this.homePlanet = homePlanet;
        this.power = power;
        this.specialMove = Optional.of(specialMove);
    }

    public DBZCharacter(String name, String homePlanet, int power) {
        this.name = name;
        this.homePlanet = homePlanet;
        this.power = power;
        this.specialMove = Optional.empty();
    }

    public String getName() {
        return name;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public int getPower() {
        return power;
    }

    public Optional<String> getSpecialMove() {
        return specialMove;
    }
}
