package nl.capaxit.bundlestatelib.state.activity;

import android.app.Activity;
import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleStateAnnotationProcessor;

/**
 * BundleState annotation enabled {@link android.app.Activity}.
 *
 * @author jcraane
 */
public class BundleStateActivity extends Activity{
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BundleStateAnnotationProcessor.restoreStateIfPresent(this, savedInstanceState, null);
        BundleStateAnnotationProcessor.processIntentExtras(this);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleStateAnnotationProcessor.saveState(this, outState, null);
    }
}
