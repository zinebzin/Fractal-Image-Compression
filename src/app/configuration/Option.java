package app.configuration;

import lib.comparators.Metric;

/**
 * Representation of available options to the app
 */
public enum Option {

    HELP("display this help message"),
    INPUT("the input file"),
    OUTPUT("the ouput file"),
    METRIC("the metric to use when comparing images") {

        @Override
        public String description() {
            StringBuilder descr = new StringBuilder(super.description).append('(');

            for (Metric metric : Metric.values()) {
                descr.append(String.format("%s ", metric.toString()));
            }

            return descr.append(')').toString();
        }
    },
    FUZZ("colors within this distance are considered equal"),
    QUALITY(String.format("the quality of the generated image {1..%d}", Option.MaxQuality)),
    VERBOSE("enable verbose output"),
    DEBUG("show debug messages (imlpies -verbose)"),
    LOG("also write debug messages to logfile"),;

    public final static int MaxQuality = 100;
    private String description;

    Option(String description) {
        this.description = description;
    }

    /**
     *
     * @return description of the option
     */
    public String description() {
        return this.description;
    }

    /**
     *
     * @return the option represented
     */
    public String option() {
        return '-' + this.name().toLowerCase();
    }
}