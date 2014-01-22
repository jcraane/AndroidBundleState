package nl.capaxit.bundlestatelib.state.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When a field is annotation with the BundleState annotation, the field is stored/retrieved from the Bundle if the activity extends
 * the proper superclass. For activities this is the {@link nl.capaxit.bundlestatelib.state.activity.BundleStateActivity} or a subclass of it.
 *
 * The other classes which support the BundleState annotation are:
 * <ul>
 *     <li>{@link nl.capaxit.bundlestatelib.state.fragment.BundleStateFragment} </li>
 *     <li>{@link nl.capaxit.bundlestatelib.state.fragment.v4.BundleStateFragment} </li>
 *     <li>{@link nl.capaxit.bundlestatelib.state.fragment.BundleStateFragmentActivity} </li>
 * </ul>
 *
 * @author jcraane
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BundleState {
    /**
     * (Optional) The name of the key to save/restore field state.
     * @return The name of the key to save/restore field state.
     */
    String name() default "";
}
