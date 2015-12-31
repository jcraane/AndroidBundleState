package nl.capaxit.bundlestatelib.state.annotations.field;

import nl.capaxit.bundlestatelib.state.annotations.ArgumentState;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;
import nl.capaxit.bundlestatelib.util.StringUtil;

import java.lang.reflect.Field;

/**
 * Factory for determining the field name of a field.
 *
 * @author jcraane
 */
public class FieldNameFactory {
    /**
     * Determines the name of the field to use as key to save/restore the fields state.
     * @param bundleState May contain an optional name() which, if present, is used as the name of the key.
     * @param field If BundleState.name() is empty, the name of the field is used as the key to save/restore the field state.
     * @return Name to use when saving/restoring the field state to the Bundle.
     */
    public static String getFieldStateName(final BundleState bundleState, final Field field) {
        if (StringUtil.isNullOrEmpty(bundleState.name())) {
            return field.getName();
        }

        return bundleState.name();
    }

    /**
     * Determines the name of the field to use as key to save/restore the fields state.
     * @param argumentState May contain an optional name() which, if present, is used as the name of the key.
     * @param field If BundleState.name() is empty, the name of the field is used as the key to save/restore the field state.
     * @return Name to use when saving/restoring the field state to the Bundle.
     */
    public static String getFieldStateName(final ArgumentState argumentState, final Field field) {
        if (StringUtil.isNullOrEmpty(argumentState.name())) {
            return field.getName();
        }

        return argumentState.name();
    }
}
