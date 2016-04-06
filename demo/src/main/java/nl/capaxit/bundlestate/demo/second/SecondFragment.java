package nl.capaxit.bundlestate.demo.second;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nl.capaxit.bundlestate.demo.R;
import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;
import nl.capaxit.bundlestatelib.state.fragment.v4.BundleStateFragment;

/**
 * Created by jamiecraane on 06/04/16.
 */
public class SecondFragment extends BundleStateFragment {
    private TextView stateInfo;

    @IntentExtra(name = SecondActivity.INTENT_STRING_VALUE)
    private String stringData;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_second, null);
        stateInfo = (TextView) view.findViewById(R.id.stateInfo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final String state = new StringBuilder("Intent extras:")
                .append("stringData = ").append(stringData).toString();
        stateInfo.setText(state);
    }
}
