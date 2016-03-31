package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class IntentFieldProcessorFactory {
    public static IntentFieldProcessor getFieldProcesor(final Field field) {
        final Class<?> type = field.getType();
        return new SerializableIntentFieldProcessor();
    }
}
