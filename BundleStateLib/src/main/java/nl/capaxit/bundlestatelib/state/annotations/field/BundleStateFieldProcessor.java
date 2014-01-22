package nl.capaxit.bundlestatelib.state.annotations.field;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.lang.reflect.Field;

/**
 * BundleState annotation processor for a specific field.
 *
 * @author jcraane
 */
public interface BundleStateFieldProcessor {
    /**
     * Saves the state of the field to the given Bundle.
     * @param bundleState The BundleSate annotation describing the field to save.
     * @param field The which contain the value to save.
     * @param target The object that holds the field.
     * @param outState The Bundle to save the field state to.
     * @throws IllegalAccessException If the state of the field could not be saved to the Bundle.
     */
    void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException;

    /**
     * Restores the state of the field from the given bundle.
     * @param bundleState The BundleSate annotation describing the field to restore.
     * @param field The field to restore the saved state in.
     * @param target The object that holds the field.
     * @param savedInstanceState The Bundle to restore the state of the field from.
     * @throws IllegalAccessException If the state of the field could not be restored from the Bundle. A null Bundle does not result in an
     * Exception since a null Bundle is a valid Android state. There is simply no state to restore (first time startup for example).
     */
    void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException;
}
