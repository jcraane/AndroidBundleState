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

    public static void restoreStateIfPresent(final Object target, final Bundle savedInstanceState, final Bundle arguments) {
        if (savedInstanceState != null) {
            try {
                final Field[] fields = target.getClass().getDeclaredFields();
                for (final Field field : fields) {
                    if (field.isAnnotationPresent(BundleState.class)) {
                        restoreState(target, savedInstanceState, field);
                    }

                    if (field.isAnnotationPresent(ArgumentState.class) && arguments == null) {
                        Log.i(TAG, "arguments is null, make sure you call setArguments(new Bundle()) in the Fragments constructor.");
                    }

                    if (field.isAnnotationPresent(ArgumentState.class) && arguments != null) {
                        restoreState(target, arguments, field);
                    }
                }
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
            }
        }
    }

    private static void restoreState(final Object target, final Bundle savedInstanceState, final Field field) throws IllegalAccessException {
        final BundleState bundleState = field.getAnnotation(BundleState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.restoreState(bundleState, field, target, savedInstanceState);
    }

    public static void saveState(final Object target, final Bundle outState, final Bundle arguments) {
        try {
            final Field[] fields = target.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(BundleState.class)) {
                    saveStateUsingBundleStateAnnotation(target, outState, field);
                }

                if (field.isAnnotationPresent(ArgumentState.class) && arguments == null) {
                    Log.i(TAG, "arguments is null, make sure you call setArguments(new Bundle()) in the Fragments constructor.");
                }

                if (field.isAnnotationPresent(ArgumentState.class) && arguments != null) {
                    saveStateUsingBundleStateAnnotation(target, arguments, field);
                }
            }
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
        }

    }

    private static void saveStateUsingBundleStateAnnotation(final Object target, final Bundle outState, final Field field) throws IllegalAccessException {
        final BundleState bundleState = field.getAnnotation(BundleState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.saveState(bundleState, field, target, outState);
    }
}
