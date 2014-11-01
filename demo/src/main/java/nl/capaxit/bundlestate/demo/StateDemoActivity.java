package nl.capaxit.bundlestate.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import nl.capaxit.bundlestatelib.state.activity.BundleStateActivity;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

/**
 * Demo/sample activity.
 */
public class StateDemoActivity extends BundleStateActivity {
    @BundleState
    private String name;

    @BundleState
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.state_demo_activity);

        findViewById(R.id.random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int value = new Random().nextInt(100);
                number = value;
                name = String.valueOf(value);
                ((TextView) findViewById(R.id.name)).setText("" + number + " " + name);
            }
        });

        ((TextView) findViewById(R.id.name)).setText("" + number + " " + name);
    }
}