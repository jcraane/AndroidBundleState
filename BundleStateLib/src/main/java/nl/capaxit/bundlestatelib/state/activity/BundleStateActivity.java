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
        BundleStateAnnotationProcessor.restoreStateIfPresent(this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleStateAnnotationProcessor.saveState(this, outState);
    }
}
