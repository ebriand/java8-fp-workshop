package fr.zenika.fp;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Exo1 {

    private List<DBZCharacter> dbzCharacters;

    private DBZCharacter sonGoku;

    private DBZCharacter piccolo;

    private DBZCharacter krillin;

    private DBZCharacter sonGohan;

    private DBZCharacter vegeta;

    @Before
    public void init() {
        sonGoku = new DBZCharacter("Son Goku", "Vegeta", 32000, "Kamehameha");
        piccolo = new DBZCharacter("Piccolo", "Namek", 3500, "Special Beam Cannon");
        krillin = new DBZCharacter("Krillin", "Earth", 1770);
        sonGohan = new DBZCharacter("Son Gohan", "Earth", 981);
        vegeta = new DBZCharacter("Vegeta", "Vegeta", 18000, "Final Flash");
        dbzCharacters = Stream.of(piccolo, krillin, sonGoku, sonGohan, vegeta).collect(Collectors.toList());
    }

    @Test
    public void shouldFindEarthlings() {
        // TODO: Implement lambda to find earthlings
        List<DBZCharacter> earthLings =
                dbzCharacters.stream()
                        .filter(c -> "Earth".equals(c.getHomePlanet()))
                        .collect(Collectors.toList());

        assertThat(earthLings, hasItems(sonGohan, krillin));
        assertThat(earthLings, not(hasItems(sonGoku, vegeta, piccolo)));
    }

    @Test
    public void shouldBeOver9000() {
        // TODO: Implement lambda to find whose power is over NINE THOUSANDS!!!!
        List<DBZCharacter> powerfulCharacters =
                dbzCharacters.stream()
                        .filter(c -> c.getPower() > 9000)
                        .collect(Collectors.toList());

        assertThat(powerfulCharacters, hasItems(sonGoku, vegeta));
        assertThat(powerfulCharacters, not(hasItems(krillin, sonGohan, piccolo)));
    }

    @Test
    public void shouldReturnNames() {
        // TODO: Implement lambda to extract names
        List<String> characterNames =
                dbzCharacters.stream()
                        .map(DBZCharacter::getName)
                        .collect(Collectors.toList());

        assertThat(characterNames, hasItems("Son Goku", "Son Gohan", "Piccolo", "Krillin", "Vegeta"));
    }

    @Test
    public void shouldReturnNamesOfPowerfulCharacters() {
        // TODO: Implement lambda to extract names of powerful characters (over NINE THOUNSANDS!!!!!)
        List<String> characterNames =
                dbzCharacters.stream()
                        .filter(c -> c.getPower() > 9000)
                        .map(DBZCharacter::getName)
                        .collect(Collectors.toList());

        assertThat(characterNames, hasItems("Son Goku", "Vegeta"));
    }

    @Test
    public void shouldSortByPower() {
        // TODO: Implement lambda to sort by power
        List<DBZCharacter> charactersSortedByPower =
                dbzCharacters.stream()
                        .sorted(comparing(DBZCharacter::getPower).reversed())
                        .collect(Collectors.toList());

        assertThat(charactersSortedByPower.get(0).getPower(), is(32000));
    }

    @Test
    public void shouldReturnMaxPower() {
        // TODO: Implement lambda to return max power
        int maxPower =
                dbzCharacters.stream()
                        .mapToInt(DBZCharacter::getPower)
                        .max().getAsInt();

        assertThat(maxPower, is(32000));
    }

    @Test
    public void shouldReturnNameOfMostPowerfulCharacter() {
        // TODO: Implement lambda to return the name of the most porwerful character
        String mostPowerfulCharacter = dbzCharacters.stream()
                .max(comparing(DBZCharacter::getPower)).get().getName();

        assertThat(mostPowerfulCharacter, is("Son Goku"));
    }


    @Test
    public void shouldReturnAveragePower() {
        // TODO: Implement lambda to return average power
        double averagePower = dbzCharacters.stream()
                .mapToInt(DBZCharacter::getPower)
                .average().getAsDouble();

        assertThat(averagePower, is(11250.2));
    }

    @Test
    public void shouldReturnNumberOfSaiyan() {
        // TODO: Implement lambda to return number of saiyan
        long numberOfSaiyan = dbzCharacters.stream()
                .filter(c -> "Vegeta".equals(c.getHomePlanet()))
                .count();

        assertThat(numberOfSaiyan, is(2L));
    }

    @Test
    public void shouldReturnCharacterNameWhoUseKamehameha() throws Exception {
        // TODO: Implement lambda to return character name when giving special move name
        String characterWhoUseKamehameha =
                dbzCharacters.stream()
                        .filter(c -> c.getSpecialMove().map("Kamehameha"::equals).orElse(false))
                        .map(DBZCharacter::getName)
                        .findFirst().get();

        assertThat(characterWhoUseKamehameha, is("Son Goku"));
    }

    @Test
    public void shouldReturnSpecialMoveWhenGivingCharacterName() throws Exception {
        // TODO: Implement lambda to return special move name when giving character name
        String sonGokuSpecialMove =
                dbzCharacters.stream()
                        .filter(c -> "Son Goku".equals(c.getName()))
                        .findFirst().get().getSpecialMove().map(identity()).orElse("");
        String sonGohanSpecialMove =
                dbzCharacters.stream()
                        .filter(c -> "Son Gohan".equals(c.getName()))
                        .findFirst().get().getSpecialMove().map(identity()).orElse("");

        assertThat(sonGokuSpecialMove, is("Kamehameha"));
        assertThat(sonGohanSpecialMove, is(""));
    }

    @Test
    public void shouldReturnSpecialMoves() throws Exception {
        // TODO: Implement lambda to return special move names
        List<String> specialMoves =
                dbzCharacters.stream()
                        .map(DBZCharacter::getSpecialMove)
                        .flatMap(speciaMove -> speciaMove.isPresent() ? Stream.of(speciaMove.get()) : Stream.empty())
                        .collect(Collectors.toList());

        assertThat(specialMoves, hasItems("Kamehameha", "Special Beam Cannon", "Final Flash"));
    }

}
