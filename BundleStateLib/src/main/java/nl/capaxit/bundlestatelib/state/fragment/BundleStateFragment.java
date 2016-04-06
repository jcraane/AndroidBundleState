package nl.capaxit.bundlestatelib.state.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.annotations.BundleStateAnnotationProcessor;

/**
 * BundleState annotation enabled {@link android.app.Fragment}.
 *
 * @author jcraane
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BundleStateFragment extends Fragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BundleStateAnnotationProcessor.restoreStateIfPresent(this, savedInstanceState, getArguments());
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BundleStateAnnotationProcessor.processIntentExtras(this);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleStateAnnotationProcessor.saveState(this, outState, getArguments());
    }
}
