package nl.capaxit.bundlestatelib.state.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import nl.capaxit.bundlestatelib.state.annotations.BundleStateAnnotationProcessor;

/**
 * BundleState annotation enabled {@link android.support.v4.app.FragmentActivity}
 *
 * @author jcraane
 */
public class BundleStateFragmentActivity extends FragmentActivity {
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
