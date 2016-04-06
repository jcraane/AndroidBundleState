package nl.capaxit.bundlestatelib.state.intent.provider;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class
ActivityIntentProvider implements IntentProvider {
    private final Activity target;

    public ActivityIntentProvider(final Activity target) {
        this.target = target;
    }

    @Override
    public Intent getIntent() {
        return target.getIntent();
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public boolean containsKey(final String key) {
        return target.getIntent().getExtras().containsKey(key);
    }
}
