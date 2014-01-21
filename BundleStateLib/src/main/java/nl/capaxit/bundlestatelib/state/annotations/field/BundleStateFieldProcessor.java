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
    void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException;
    void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException;
}
