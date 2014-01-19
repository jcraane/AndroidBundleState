package nl.capaxit.bundlestatelib.state.annotations.field;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.lang.reflect.Field;

/**
 * BundleStateFieldProcessor for String types.
 *
 * @author jcraane
 */
public class LongFieldProcessor implements BundleStateFieldProcessor {
    @Override
    public void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.getType().isPrimitive()) {
            // primitives can not be null.
            outState.putLong(bundleState.name(), (Long) field.get(target));
        } else {
            final Long value = (Long) field.get(target);
            if (value != null) {
                outState.putLong(bundleState.name(), value);
            }
        }
    }

    @Override
    public void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException {
        if (savedInstanceState.getString(bundleState.name()) != null) {
            field.setAccessible(true);
            field.set(target, savedInstanceState.getLong(bundleState.name()));
        }
    }
}
