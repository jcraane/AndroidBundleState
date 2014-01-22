package nl.capaxit.bundlestatelib.state.fragment.v4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import nl.capaxit.bundlestatelib.state.annotations.BundleStateAnnotationProcessor;

/**
 * BundleState annotation enabled v4 (support) {@link android.support.v4.app.Fragment}.
 *
 * @author jcraane
 */
public class BundleStateFragment extends Fragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BundleStateAnnotationProcessor.restoreStateIfPresent(this, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleStateAnnotationProcessor.saveState(this, outState);
    }
}
