package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.io.Serializable;
import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class SerializableExtraFieldProcessor extends BaseExtraFieldProcessor {
    @Override
    public void process(IntentProvider intentProvider, final IntentExtra intentExtra, final Field field) {
        logIfRequiredValueIsNotPresentWithoutDefault(intentExtra, intentProvider);
        final Serializable value = intentProvider.getIntent().getExtras().getSerializable(intentExtra.name());
        processExtra(intentProvider, intentProvider.getTarget(), value, field, intentExtra);
    }

    private void processExtra(final IntentProvider intentProvider, final Object target, final Serializable value, final Field field, final IntentExtra intentExtra) {
        field.setAccessible(true);
        try {
            final Object newValue = intentProvider.containsKey(intentExtra.name()) ? value : intentExtra.defaultValue();
            field.set(target, newValue);
        } catch (IllegalAccessException e) {
            // Ignore for now
        }
    }
}
