package nl.capaxit.bundlestatelib.state.activity;

import android.app.Activity;
import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.lang.reflect.Field;

/**
 * Insert documentation here.
 *
 * @author jcraane
 */
public class BundleStateActivity extends Activity{
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreBundleState(savedInstanceState);
    }

    private void restoreBundleState(final Bundle savedInstanceState) {
        try {
            final Field[] fields = this.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(BundleState.class)) {
                    final BundleState bundleState = field.getAnnotation(BundleState.class);
                    final Class fieldType = field.getType();
                    if (fieldType.getSimpleName().equals("String")) {
                        if (savedInstanceState != null && savedInstanceState.getString(bundleState.name()) != null) {
                            field.setAccessible(true);
                            field.set(this, savedInstanceState.getString(bundleState.name()));
                        }
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        try {
            final Field[] fields = this.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(BundleState.class)) {
                    final BundleState bundleState = field.getAnnotation(BundleState.class);
                    final Class fieldType = field.getType();
                    if (fieldType.getSimpleName().equals("String")) {
                        field.setAccessible(true);
                        outState.putString(bundleState.name(), (String) field.get(this));
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
