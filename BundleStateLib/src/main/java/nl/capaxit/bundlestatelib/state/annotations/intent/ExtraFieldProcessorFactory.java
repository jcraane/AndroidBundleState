package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class ExtraFieldProcessorFactory {
    public static ExtraFieldProcessor getFieldProcesor(final Field field) {
        final Class<?> type = field.getType();
        if (isInt(type)) {
            return new IntExtraFieldProcessor();
        }

        if (isLong(type)) {
            return new LongExtraFieldProcessor();
        }

        if (isBoolean(type)) {
            return new BooleanExtraFieldProcessor();
        }

        return new SerializableExtraFieldProcessor();
    }

    private static boolean isBoolean(final Class<?> type) {
        return type == boolean.class || type == Boolean.class;
    }

    private static boolean isLong(final Class<?> type) {
        return type == long.class || type == Long.class;
    }

    private static boolean isInt(final Class<?> type) {
        return type == int.class || type == Integer.class;
    }
}
