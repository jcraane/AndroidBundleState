package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class SerializableIntentFieldProcessor extends BaseIntentFieldProcessor {
    @Override
    public void doProcess(final Object target, final String value, final Field field) {
        field.setAccessible(true);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            // Ignore for now
        }
    }
}
