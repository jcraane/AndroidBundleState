package nl.capaxit.bundlestatelib.state.annotations.field;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.lang.reflect.Field;

/**
 * BundleStateFieldProcessor for String types.
 *
 * @author jcraane
 */
public class IntegerFieldProcessor implements BundleStateFieldProcessor {
    @Override
    public void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.getType().isPrimitive()) {
            // primitives can not be null.
            outState.putInt(bundleState.value(), (Integer) field.get(target));
        } else {
            final Integer value = (Integer) field.get(target);
            if (value != null) {
                outState.putInt(bundleState.value(), value);
            }
        }
    }

    @Override
    public void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException {
        if (savedInstanceState.getString(bundleState.value()) != null) {
            field.setAccessible(true);
            field.set(target, savedInstanceState.getInt(bundleState.value()));
        }
    }
}
