package nl.capaxit.bundlestate.demo;

import android.os.Bundle;
import nl.capaxit.bundlestatelib.state.fragment.BundleStateFragmentActivity;

/**
 * Demo/sample activity.
 */
public class StateDemoFragmentActivity extends BundleStateFragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_demo_fragment_activity);
    }
}
