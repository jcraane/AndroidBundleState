package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.util.StringUtil;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class SerializableExtraFieldProcessor extends BaseExtraFieldProcessor {
    @Override
    public void doProcess(final Object target, final String value, final Field field, final IntentExtra intentExtra) {
        field.setAccessible(true);
        try {
            final String newValue = !StringUtil.isNullOrEmpty(value) ? value : intentExtra.defaultValue();
            field.set(target, newValue);
        } catch (IllegalAccessException e) {
            // Ignore for now
        }
    }
}
