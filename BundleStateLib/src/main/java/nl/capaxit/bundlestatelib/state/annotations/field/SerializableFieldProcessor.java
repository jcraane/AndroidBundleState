package nl.capaxit.bundlestatelib.state.annotations.field;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * BundleStateFieldProcessor for String types.
 *
 * @author jcraane
 */
public class SerializableFieldProcessor implements BundleStateFieldProcessor {
    @Override
    public void saveState(final BundleState bundleState, final Field field, final Object target, final Bundle outState) throws IllegalAccessException {
        field.setAccessible(true);
        outState.putSerializable(FieldNameFactory.getFieldStateName(bundleState, field), (Serializable) field.get(target));
    }

    @Override
    public void restoreState(final BundleState bundleState, final Field field, final Object target, final Bundle savedInstanceState) throws IllegalAccessException {
        if (savedInstanceState.getSerializable(FieldNameFactory.getFieldStateName(bundleState, field)) != null) {
            field.setAccessible(true);
            field.set(target, savedInstanceState.getSerializable(FieldNameFactory.getFieldStateName(bundleState, field)));
        }
    }
}
