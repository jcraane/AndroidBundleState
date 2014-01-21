package nl.capaxit.bundlestatelib.state.annotations.field;

import nl.capaxit.bundlestatelib.state.annotations.BundleState;
import nl.capaxit.bundlestatelib.util.StringUtil;

import java.lang.reflect.Field;

/**
 * Insert documentation here.
 *
 * @author jcraane
 */
public class FieldNameFactory {
    public static String getFieldName(final BundleState bundleState, final Field field) {
        if (StringUtil.isNullOrEmpty(bundleState.name())) {
            return field.getName();
        }

        return bundleState.name();
    }
}
