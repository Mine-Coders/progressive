package minecoders.progressive.integration;

import eu.midnightdust.lib.config.MidnightConfig;
import minecoders.progressive.api.config.Example;

@SuppressWarnings({"CanBeFinal", "unused"})
public class MidnightLibIntegration extends MidnightConfig {
    public static final String EXAMPLE = "example";

    // Example Category
    @Entry(category = EXAMPLE) public static boolean example = Example.example.getDefaultValue();
    @Client @Entry(category = EXAMPLE) public static boolean exampleClient = Example.example.getDefaultValue();
}
