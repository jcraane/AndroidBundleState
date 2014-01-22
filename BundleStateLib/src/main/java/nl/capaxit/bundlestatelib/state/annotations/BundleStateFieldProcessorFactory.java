package nl.capaxit.bundlestatelib.state.annotations;

import nl.capaxit.bundlestatelib.state.annotations.field.BundleStateFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.field.SerializableFieldProcessor;

import java.lang.reflect.Field;

/**
 * Factory for field processors of the BundleState annotation.
 *
 * A cache can be introduced here if needed.
 *
 * @author jcraane
 */
public final class BundleStateFieldProcessorFactory {
    private static final BundleStateFieldProcessor FIELD_PROCESSOR = new SerializableFieldProcessor();

    private BundleStateFieldProcessorFactory() {
    }

    public static BundleStateFieldProcessor getProcessor(final Field field) {
        return FIELD_PROCESSOR;
    }
}
