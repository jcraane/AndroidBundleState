package nl.capaxit.bundlestatelib.state.intent.provider;

import android.app.Fragment;
import android.content.Intent;

/**
 * Created by jamiecraane on 06/04/16.
 */
public class FragmentIntentProvider implements IntentProvider {
    private final Fragment fragment;

    public FragmentIntentProvider(final Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public Intent getIntent() {
        return fragment.getActivity().getIntent();
    }

    @Override
    public Object getTarget() {
        return fragment;
    }

    @Override
    public boolean containsKey(final String key) {
        if (fragment.getActivity().getIntent() == null
                || fragment.getActivity().getIntent().getExtras() == null) {
            return false;
        }

        return fragment.getActivity().getIntent().getExtras().containsKey(key);
    }
}
