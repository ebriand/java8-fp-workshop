package fr.zenika.fp.exo2;

public class FilterLogger implements ILogger {

    private IFilter filter;

    private ILogger logger;

    public FilterLogger(IFilter filter, ILogger logger) {
        this.filter = filter;
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        if (!filter.filter(message)) {
            logger.log(message);
        }
    }
}
