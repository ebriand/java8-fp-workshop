package fr.zenika.fp.exo2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exo2 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldLogMessage() {
        // TODO: Refactor to have only a functional interface logger and no more SysoutLogger implementation
        Logger logger = System.out::println;
        logger.log("hello");
        assertThat(outContent.toString(), is("hello" + System.getProperty("line.separator")));
    }


    @Test
    public void shouldFilterTheFirstMessageAndLogTheSecond() {
        // TODO: Refactor to have no more Filter interface and any implementation by using built-in functional interface
        Logger logger = System.out::println;
        Logger filterLogger = logger.filter(message -> message.startsWith("w"));

        filterLogger.log("hello");
        filterLogger.log("world");
        assertThat(outContent.toString(), is("world" + System.getProperty("line.separator")));

        // TODO: Enhance functional interface Logger to take a filter and to have no more FilterLogger
    }
}
