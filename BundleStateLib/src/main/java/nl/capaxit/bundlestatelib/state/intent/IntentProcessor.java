package nl.capaxit.bundlestatelib.state.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentData;
import nl.capaxit.bundlestatelib.state.annotations.intent.IntentFieldProcessor;
import nl.capaxit.bundlestatelib.state.annotations.intent.IntentFieldProcessorFactory;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class IntentProcessor {
    public static void processIntentAnnotation(final IntentProvider intentProvider, final Field field) {
        final IntentData intentData = field.getAnnotation(IntentData.class);
        final IntentFieldProcessor fieldProcesor = IntentFieldProcessorFactory.getFieldProcesor(field);
        fieldProcesor.process(intentProvider, intentData, field);
    }
}
