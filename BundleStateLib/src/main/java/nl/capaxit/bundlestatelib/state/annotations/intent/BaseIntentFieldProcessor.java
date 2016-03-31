package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentData;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;
import nl.capaxit.bundlestatelib.util.StringUtil;

/**
 * Created by jamiecraane on 31/03/16.
 */
public abstract class BaseIntentFieldProcessor implements IntentFieldProcessor {
    @Override
    public void process(IntentProvider intentProvider, final IntentData intentData, final Field field) {
        final String value = intentProvider.getIntent().getExtras().getString(intentData.name());
        if (isRequiredValueNotPresentAndNoDefault(intentData, value)) {
            throw new IllegalArgumentException(String.format("Intent data %s is marked as required but not present.", intentData.name()));
        }

        doProcess(intentProvider.getTarget(), value, field);
    }

    public abstract void doProcess(Object target, String value, Field field);

    private boolean isRequiredValueNotPresentAndNoDefault(final IntentData intentData, final String value) {
        return StringUtil.isNullOrEmpty(value) && intentData.required() && StringUtil.isNullOrEmpty(intentData.defaultValue());
    }
}
