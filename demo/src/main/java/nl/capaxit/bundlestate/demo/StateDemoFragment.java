package nl.capaxit.bundlestate.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import nl.capaxit.bundlestatelib.state.annotations.ArgumentState;
import nl.capaxit.bundlestatelib.state.fragment.v4.BundleStateFragment;

/**
 * Created by jamiecraane on 31/12/15.
 */
public class StateDemoFragment extends BundleStateFragment {
    @ArgumentState
    private String name;

    @ArgumentState
    private int number;

    public StateDemoFragment() {
        setArguments(new Bundle());
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.state_demo_frag, null);

        view.findViewById(R.id.random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int value = new Random().nextInt(100);
                number = value;
                name = String.valueOf(value);
                ((TextView) view.findViewById(R.id.name)).setText("" + number + " " + name);
            }
        });

        ((TextView) view.findViewById(R.id.name)).setText("" + number + " " + name);
        return view;
    }
}
