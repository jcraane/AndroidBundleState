package nl.capaxit.bundlestatelib.state.activity;

import android.app.Activity;
import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleStateAnnotationProcessor;

/**
 * Insert documentation here.
 *
 * TODO: Add annotation cache and separate the processing from the activity/lifecycle.
 * @author jcraane
 */
public class BundleStateActivity extends Activity{
    private static final String TAG = BundleStateActivity.class.getSimpleName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreBundleState(savedInstanceState);
    }

    private void restoreBundleState(final Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            BundleStateAnnotationProcessor.storeState(this, savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleStateAnnotationProcessor.restoreState(this, outState);
    }
}
