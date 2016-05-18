package nl.capaxit.bundlestatelib.state.annotations.intent;

import android.content.Intent;

import junit.framework.TestCase;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Created by jamiecraane on 18/05/16.
 */
public class SerializableExtraFieldProcessorTest extends TestCase {
    public void testSetField() throws Exception {
        final Target target = new Target();
        final Field[] fields = target.getClass().getDeclaredFields();
        final Field field = fields[0];
        final IntentExtra annotation = (IntentExtra) field.getAnnotations()[0];
        new SerializableExtraFieldProcessor().process(new MockIntentProvider("newValue", target), annotation, field);

        assertEquals("newValue", target.value);
    }

    public void testSetFieldNull() throws Exception {
        final Target target = new Target();
        final Field[] fields = target.getClass().getDeclaredFields();
        final Field field = fields[0];
        final IntentExtra annotation = (IntentExtra) field.getAnnotations()[0];
        new SerializableExtraFieldProcessor().process(new MockIntentProvider(null, target), annotation, field);

        assertNull(target.value);
    }

    private static class MockIntentProvider implements IntentProvider {
        private final Target target;
        private final String intentValue;

        private MockIntentProvider(final String intentValue, final Target target) {
            this.intentValue = intentValue;
            this.target = target;
        }

        @Override
        public Intent getIntent() {
            final Intent intent = new Intent();
            intent.putExtra("testData", intentValue);
            return intent;
        }

        @Override
        public Object getTarget() {
            return target;
        }

        @Override
        public boolean containsKey(final String key) {
            return true;
        }
    }

    private static class Target {
        @IntentExtra(name = "testData")
        private String value;
    }
}