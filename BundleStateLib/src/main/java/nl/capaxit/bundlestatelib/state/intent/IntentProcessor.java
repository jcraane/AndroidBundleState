package nl.capaxit.bundlestatelib.state.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.annotations.intent.ExtraFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.intent.ExtraFieldProcessorFactory;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class IntentProcessor {
    public static void processIntentAnnotation(final IntentProvider intentProvider, final Field field) {
        final IntentExtra intentExtra = field.getAnnotation(IntentExtra.class);
        final ExtraFieldProcessor fieldProcesor = ExtraFieldProcessorFactory.getFieldProcesor(field);
        fieldProcesor.process(intentProvider, intentExtra, field);
    }
}
