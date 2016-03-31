package nl.capaxit.bundlestatelib.state.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jamiecraane on 30/03/16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IntentData {
    /**
     * The name of the intent-key to save/restore field state.
     * @return The name of the key to save/restore field state.
     */
    String name() default "";

    /**
     * If true, an IllegalArgumentException is thrown if this key is not present in the intent.
     *
     * @return
     */
    boolean required() default false;

    String defaultValue() default "";
}
