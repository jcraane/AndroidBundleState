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
public class BooleanExtraFieldProcessor extends BaseExtraFieldProcessor {
    private static final String TAG = BooleanExtraFieldProcessor.class.getSimpleName();

    @Override
    public void process(IntentProvider intentProvider, final IntentExtra intentExtra, final Field field) {
        throwExceptionIfRequiredValueIsNotPresentWithoutDefault(intentExtra, intentProvider);
        final boolean value = intentProvider.getIntent().getExtras().getBoolean(intentExtra.name());
        processExtra(intentProvider, intentProvider.getTarget(), value, field, intentExtra);
    }

    private void processExtra(final IntentProvider intentProvider, final Object target, final boolean value, final Field field, final IntentExtra intentExtra) {
        field.setAccessible(true);
        try {
            final boolean newValue = intentProvider.containsKey(intentExtra.name()) ? value : Boolean.parseBoolean(intentExtra.defaultValue());
            field.set(target, newValue);
        } catch (IllegalAccessException e) {
            // Ignore for now
        } catch (NumberFormatException e) {
            Log.e(TAG, String.format("Unable to parse defaultValue [%s]", intentExtra.defaultValue()), e);
        }
    }
}
