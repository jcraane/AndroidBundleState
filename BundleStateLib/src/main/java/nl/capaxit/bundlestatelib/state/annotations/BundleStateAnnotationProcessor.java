package nl.capaxit.bundlestatelib.state.annotations;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.field.BundleStateFieldProcessor;

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
        if (savedInstanceState != null || arguments != null) {
            try {
                final Field[] fields = target.getClass().getDeclaredFields();
                for (final Field field : fields) {
                    if (field.isAnnotationPresent(BundleState.class) && savedInstanceState != null) {
                        restoreBundleState(target, savedInstanceState, field);
                    }

                    if (field.isAnnotationPresent(ArgumentState.class) && arguments == null) {
                        Log.i(TAG, "arguments is null, make sure you call setArguments(new Bundle()) in the Fragments constructor.");
                    }

                    if (field.isAnnotationPresent(ArgumentState.class) && arguments != null) {
                        restoreArgumentState(target, arguments, field);
                    }
                }
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
            }
        }
    }

    private static void restoreBundleState(final Object target, final Bundle savedInstanceState, final Field field) throws IllegalAccessException {
        final BundleState bundleState = field.getAnnotation(BundleState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.restoreState(bundleState, field, target, savedInstanceState);
    }

    private static void restoreArgumentState(final Object target, final Bundle savedInstanceState, final Field field) throws IllegalAccessException {
        final ArgumentState argumentState = field.getAnnotation(ArgumentState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.restoreState(argumentState, field, target, savedInstanceState);
    }

    public static void saveState(final Object target, final Bundle outState, final Bundle arguments) {
        try {
            final Field[] fields = target.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(BundleState.class)) {
                    saveBundleState(target, outState, field);
                }

                if (field.isAnnotationPresent(ArgumentState.class) && arguments == null) {
                    Log.i(TAG, "arguments is null, make sure you call setArguments(new Bundle()) in the Fragments constructor.");
                }

                if (field.isAnnotationPresent(ArgumentState.class) && arguments != null) {
                    saveArgumentState(target, arguments, field);
                }
            }
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
        }

    }

    private static void saveBundleState(final Object target, final Bundle outState, final Field field) throws IllegalAccessException {
        final BundleState bundleState = field.getAnnotation(BundleState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.saveState(bundleState, field, target, outState);
    }

    private static void saveArgumentState(final Object target, final Bundle outState, final Field field) throws IllegalAccessException {
        final ArgumentState argumentState = field.getAnnotation(ArgumentState.class);
        final BundleStateFieldProcessor processor = BundleStateFieldProcessorFactory.getProcessor(field);
        processor.saveState(argumentState, field, target, outState);
    }
}
