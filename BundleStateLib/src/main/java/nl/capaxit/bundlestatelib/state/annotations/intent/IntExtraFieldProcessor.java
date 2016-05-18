package nl.capaxit.bundlestatelib.state.annotations.intent;

import android.util.Log;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Intent extra field processor for ints.
 *
 * Created by jamiecraane on 31/03/16.
 */
public class IntExtraFieldProcessor extends BaseExtraFieldProcessor {
    private static final String TAG = IntExtraFieldProcessor.class.getSimpleName();

    @Override
    public void process(IntentProvider intentProvider, final IntentExtra intentExtra, final Field field) {
        logIfRequiredValueIsNotPresentWithoutDefault(intentExtra, intentProvider);
        final int value = intentProvider.getIntent().getExtras().getInt(intentExtra.name());
        processExtra(intentProvider, intentProvider.getTarget(), value, field, intentExtra);
    }

    private void processExtra(final IntentProvider intentProvider, final Object target, final int value, final Field field, final IntentExtra intentExtra) {
        field.setAccessible(true);
        try {
            final int newValue = intentProvider.containsKey(intentExtra.name()) ? value : Integer.parseInt(intentExtra.defaultValue());
            field.set(target, newValue);
        } catch (IllegalAccessException e) {
            // Ignore for now
        } catch (NumberFormatException e) {
            Log.e(TAG, String.format("Unable to parse defaultValue [%s]", intentExtra.defaultValue()), e);
        }
    }
}
