package nl.capaxit.bundlestatelib.state.intent.provider;

import android.content.Intent;

/**
 * Created by jamiecraane on 31/03/16.
 */
public interface IntentProvider {
    Intent getIntent();

    Object getTarget();
}
