package nl.capaxit.bundlestatelib.state.annotations;

import nl.capaxit.bundlestatelib.state.annotations.field.BundleStateFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.field.IntegerFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.field.LongFieldProcessor;
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

        if (field.getType().isAssignableFrom(int.class)
            || field.getType().isAssignableFrom(Integer.class)) {
            return new IntegerFieldProcessor();
        }

        if (field.getType().isAssignableFrom(long.class)
            || field.getType().isAssignableFrom(Long.class)) {
            return new LongFieldProcessor();
        }

        throw new IllegalArgumentException("field cannot be saved/restored to/from a Bundle.");
    }
}
