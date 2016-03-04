package fr.zenika.fp.exo1;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<DBZCharacter> earthLings = dbzCharacters;

        assertThat(earthLings, hasItems(sonGohan, krillin));
        assertThat(earthLings, Matchers.not(hasItems(sonGoku, vegeta, piccolo)));
    }

    @Test
    public void shouldBeOver9000() {
        // TODO: Implement lambda to find whose power is over NINE THOUSANDS!!!!
        List<DBZCharacter> powerfulCharacters = dbzCharacters;

        assertThat(powerfulCharacters, hasItems(sonGoku, vegeta));
        assertThat(powerfulCharacters, Matchers.not(hasItems(krillin, sonGohan, piccolo)));
    }

    @Test
    public void shouldReturnNames() {
        // TODO: Implement lambda to extract names
        List<String> characterNames = new ArrayList<>();

        assertThat(characterNames, hasItems("Son Goku", "Son Gohan", "Piccolo", "Krillin", "Vegeta"));
    }

    @Test
    public void shouldReturnNamesOfPowerfulCharacters() {
        // TODO: Implement lambda to extract names of powerful characters (over NINE THOUNSANDS!!!!!)
        List<String> characterNames = new ArrayList<>();

        assertThat(characterNames, hasItems("Son Goku", "Vegeta"));
    }

    @Test
    public void shouldSortByPower() {
        // TODO: Implement lambda to sort by power
        List<DBZCharacter> charactersSortedByPower = dbzCharacters;

        assertThat(charactersSortedByPower.get(0).getPower(), is(32000));
    }

    @Test
    public void shouldReturnMaxPower() {
        // TODO: Implement lambda to return max power
        int maxPower = 0;

        assertThat(maxPower, is(32000));
    }

    @Test
    public void shouldReturnStrongestCharacterByReduce() {
        // TODO: Implement lambda to sort by power
        DBZCharacter strongestCharacter = null;

        assertThat(strongestCharacter, is(sonGoku));
    }

    @Test
    public void shouldReturnNameOfMostPowerfulCharacter() {
        // TODO: Implement lambda to return the name of the most porwerful character
        String mostPowerfulCharacter = "";

        assertThat(mostPowerfulCharacter, is("Son Goku"));
    }

    @Test
    public void shouldReturnAveragePower() {
        // TODO: Implement lambda to return average power
        double averagePower = 0d;

        assertThat(averagePower, is(11250.2));
    }

    @Test
    public void shouldReturnNumberOfSaiyan() {
        // TODO: Implement lambda to return number of saiyan
        long numberOfSaiyan = 0L;

        assertThat(numberOfSaiyan, is(2L));
    }

    @Test
    public void shouldReturnCharacterNameWhoUseKamehameha() throws Exception {
        // TODO: Implement lambda to return character name when giving special move name
        String characterWhoUseKamehameha = "Kamehameha";

        assertThat(characterWhoUseKamehameha, is("Son Goku"));
    }

    @Test
    public void shouldReturnSpecialMoveWhenGivingCharacterName() throws Exception {
        // TODO: Implement lambda to return special move name when giving character name
        String sonGokuSpecialMove = "Son Goku";
        String sonGohanSpecialMove = "Son Gohan";

        assertThat(sonGokuSpecialMove, is("Kamehameha"));
        assertThat(sonGohanSpecialMove, is(""));
    }

    @Test
    public void shouldReturnSpecialMoves() throws Exception {
        // TODO: Implement lambda to return special move names
        List<String> specialMoves = new ArrayList<>();

        assertThat(specialMoves, hasItems("Kamehameha", "Special Beam Cannon", "Final Flash"));
    }

}
