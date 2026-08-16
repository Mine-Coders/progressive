package minecoders.progressive.api;

import java.lang.annotation.*;

@SuppressWarnings("unused")
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface NotImplemented {
    /**
     * <p>The optional description</p>
     */
    String value() default "";
}
