package nl.capaxit.bundlestatelib.state.annotations;

import nl.capaxit.bundlestatelib.state.annotations.field.BundleStateFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.field.StringFieldProcessor;

import java.lang.reflect.Field;

/**
 * Factory for field processors of the BundleState annotation.
 *
 * A cache can be introduced here if needed.
 *
 * @author jcraane
 */
public final class BundleStateFieldProcessorFactory {
    private BundleStateFieldProcessorFactory() {
    }

    public static BundleStateFieldProcessor getProcessor(final Field field) {
        if (field.getType().isAssignableFrom(String.class)) {
            return new StringFieldProcessor();
        }

        throw new IllegalArgumentException("field cannot be saved/restored to/from a Bundle.");
    }
}
