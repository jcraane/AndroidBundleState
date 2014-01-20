package nl.capaxit.bundlestatelib.state.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When a field is annotation with the BundleState annotation, the field is stored/retrieved from the Bundle if the activity extends
 * the proper superclass. For activities this is the BundleStateActivity or a subclass of it.
 *
 * For fragments this is the TODO.
 *
 * @author jcraane
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BundleState {
    String value() default "";
}
