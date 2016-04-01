package nl.capaxit.bundlestatelib.state.annotations.intent;

import java.lang.reflect.Field;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;
import nl.capaxit.bundlestatelib.util.StringUtil;

/**
 * Created by jamiecraane on 31/03/16.
 */
public abstract class BaseExtraFieldProcessor implements ExtraFieldProcessor {
    @Override
    public void process(IntentProvider intentProvider, final IntentExtra intentExtra, final Field field) {
        final String value = intentProvider.getIntent().getExtras().getString(intentExtra.name());
        if (isRequiredValueNotPresentAndNoDefault(intentExtra, value)) {
            throw new IllegalArgumentException(String.format("Intent data %s is marked as required but not present.", intentExtra.name()));
        }

        doProcess(intentProvider.getTarget(), value, field, intentExtra);
    }

    public abstract void doProcess(Object target, String value, Field field, IntentExtra intentExtra);

    private boolean isRequiredValueNotPresentAndNoDefault(final IntentExtra intentExtra, final String value) {
        return StringUtil.isNullOrEmpty(value) && intentExtra.required() && StringUtil.isNullOrEmpty(intentExtra.defaultValue());
    }
}
