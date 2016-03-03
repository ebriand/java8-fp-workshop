package fr.zenika.fp.exo2;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface Logger {
    void log(String message);

    default Logger filter(Predicate<String> filter) {
        Objects.nonNull(filter);
        return message -> {
            if (filter.test(message)) {
                log(message);
            }
        };
    }
}
