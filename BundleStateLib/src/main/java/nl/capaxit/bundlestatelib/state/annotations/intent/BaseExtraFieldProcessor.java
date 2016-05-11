package nl.capaxit.bundlestatelib.state.annotations.intent;

import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.intent.provider.IntentProvider;
import nl.capaxit.bundlestatelib.util.StringUtil;

/**
 * Created by jamiecraane on 06/04/16.
 */
public abstract class BaseExtraFieldProcessor implements ExtraFieldProcessor {
    protected final void throwExceptionIfRequiredValueIsNotPresentWithoutDefault(final IntentExtra intentExtra, final IntentProvider provider) {
        if (provider.getIntent().getExtras() == null && intentExtra != null && intentExtra.required()) {
            if (!provider.getIntent().getExtras().containsKey(intentExtra.name()) && StringUtil.isNullOrEmpty(intentExtra.defaultValue())) {
                throw new IllegalArgumentException(String.format("Intent data %s is marked as required but not present and no default value is specified.", intentExtra.name()));
            }
        }
    }
}