package nl.capaxit.bundlestatelib.state.annotations.field;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.lang.reflect.Field;

/**
 * BundleStateFieldProcessor for String types.
 *
 * @author jcraane
 */
public class StringFieldProcessor implements BundleStateFieldProcessor {
    @Override
    public void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException {
        field.setAccessible(true);
        outState.putString(bundleState.value(), (String) field.get(target));
    }

    @Override
    public void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException {
        if (savedInstanceState.getString(bundleState.value()) != null) {
            field.setAccessible(true);
            field.set(target, savedInstanceState.getString(bundleState.value()));
        }
    }
}
