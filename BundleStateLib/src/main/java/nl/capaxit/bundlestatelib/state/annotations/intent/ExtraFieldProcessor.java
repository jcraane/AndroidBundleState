package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;

/**
 * Created by jamiecraane on 31/03/16.
 */
public interface ExtraFieldProcessor {
    void process(IntentProvider target, IntentExtra intentExtra, Field field);
}
