package nl.capaxit.bundlestatelib.state.annotations;

import android.os.Bundle;
import android.util.Log;
import nl.capaxit.bundlestatelib.state.annotations.field.BundleStateFieldProcessor;

import java.lang.reflect.Field;

/**
 * Processor for the BundleState annotation. Delegates to BundleStateFieldProcessor instances for specific
 * field type processing.
 *
 * @author jcraane
 */
public final class BundleStateAnnotationProcessor {
    private static final String TAG = BundleStateAnnotationProcessor.class.getSimpleName();

    private BundleStateAnnotationProcessor() {
    }

    public static void restoreStateIfPresent(final Object target, final Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            try {
                final Field[] fields = target.getClass().getDeclaredFields();
                for (final Field field : fields) {
                    if (field.isAnnotationPresent(BundleState.class)) {
                        final BundleState bundleState = field.getAnnotation(BundleState.class);
                        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
                        processor.restoreState(bundleState, field, target, savedInstanceState);
                    }
                }
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
            }
        }
    }

    public static void saveState(final Object target, final Bundle outState) {
        try {
            final Field[] fields = target.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(BundleState.class)) {
                    final BundleState bundleState = field.getAnnotation(BundleState.class);
                    final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
                    processor.saveState(bundleState, field, target, outState);
                }
            }
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
        }

    }
}
