package nl.capaxit.bundlestatelib.state.annotations;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Insert documentation here.
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
                        final Class fieldType = field.getType();
                        if (fieldType.isAssignableFrom(String.class)) {
                            if (savedInstanceState.getString(bundleState.name()) != null) {
                                field.setAccessible(true);
                                field.set(target, savedInstanceState.getString(bundleState.name()));
                            }
                        }

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
                    final Class fieldType = field.getType();
                    if (fieldType.isAssignableFrom(String.class)) {
                        field.setAccessible(true);
                        outState.putString(bundleState.name(), (String) field.get(target));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not restore bundle state, see the exception for details.", e);
        }

    }
}
