package minecoders.progressive.api.config;

import minecoders.progressive.api.UserConfigurableSetting;
import minecoders.progressive.integration.MidnightLibIntegration;

@SuppressWarnings("CanBeFinal")
public class Example {
    public static UserConfigurableSetting<Boolean> example = new UserConfigurableSetting<>(true,
        () -> MidnightLibIntegration.example);
}
