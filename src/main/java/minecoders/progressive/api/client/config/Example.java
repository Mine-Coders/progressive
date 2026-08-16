package minecoders.progressive.api.client.config;

import minecoders.progressive.api.UserConfigurableSetting;
import minecoders.progressive.integration.MidnightLibIntegration;

@SuppressWarnings({"CanBeFinal", "unused"})
public class Example {
    public static UserConfigurableSetting<Boolean> example = new UserConfigurableSetting<>(true,
        () -> MidnightLibIntegration.exampleClient);
}
