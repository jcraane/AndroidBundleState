package nl.capaxit.bundlestatelib;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import nl.capaxit.bundlestatelib.state.activity.BundleStateActivity;
import nl.capaxit.bundlestatelib.state.annotations.BundleState;

import java.util.Random;

public class StateDemoActivity extends BundleStateActivity {
    @BundleState(name = "state_name")
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_demo_activity);

        ((Button) findViewById(R.id.random)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                name = String.valueOf(new Random().nextInt(1000000));
                ((TextView) findViewById(R.id.name)).setText(name);
            }
        });

        ((TextView) findViewById(R.id.name)).setText(name);
    }

}
