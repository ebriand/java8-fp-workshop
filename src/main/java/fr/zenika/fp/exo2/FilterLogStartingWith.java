package fr.zenika.fp.exo2;

public class FilterLogStartingWith implements IFilter {

    private String prefix;

    public FilterLogStartingWith(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean accept(String message) {
        return message.startsWith(prefix);
    }
}
