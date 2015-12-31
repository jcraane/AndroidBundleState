package nl.capaxit.bundlestatelib.state.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When a field is annotation with the BundleState annotation, the field is stored/retrieved from the arguments (fragment only) if the fragment extends he proper superclass. For fragments this is the {@link nl.capaxit.bundlestatelib.state.fragment.BundleStateFragment} or a {@link nl.capaxit.bundlestatelib.state.fragment.BundleStateFragmentActivity}
 *
 * @author jcraane
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArgumentState {
    /**
     * (Optional) The name of the key to save/restore field state.
     * @return The name of the key to save/restore field state.
     */
    String name() default "";
}
