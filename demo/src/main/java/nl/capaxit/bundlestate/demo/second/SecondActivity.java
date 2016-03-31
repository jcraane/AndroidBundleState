package nl.capaxit.bundlestate.demo.second;

import android.os.Bundle;
import android.widget.TextView;

import nl.capaxit.bundlestate.demo.R;
import nl.capaxit.bundlestatelib.state.activity.BundleStateActivity;
import nl.capaxit.bundlestatelib.state.annotations.IntentData;

/**
 * Created by jamiecraane on 30/03/16.
 */
public class SecondActivity extends BundleStateActivity {
    public static final String INTENT_DATA = "intent:data";

    @IntentData(name = INTENT_DATA, required = true)
    private String intentData;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((TextView) findViewById(R.id.intentData)).setText(intentData);
    }
}
