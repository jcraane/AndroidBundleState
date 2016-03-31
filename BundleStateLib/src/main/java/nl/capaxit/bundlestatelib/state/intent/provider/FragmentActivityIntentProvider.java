package nl.capaxit.bundlestatelib.state.intent.provider;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class FragmentActivityIntentProvider implements IntentProvider {
    private final FragmentActivity fragmentActivity;

    public FragmentActivityIntentProvider(final FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public Intent getIntent() {
        return fragmentActivity.getIntent();
    }

    @Override
    public Object getTarget() {
        return fragmentActivity;
    }
}
