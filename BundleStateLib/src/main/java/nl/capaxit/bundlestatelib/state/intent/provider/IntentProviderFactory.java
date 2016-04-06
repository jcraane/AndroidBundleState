package nl.capaxit.bundlestatelib.state.intent.provider;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by jamiecraane on 31/03/16.
 */
public class IntentProviderFactory {
    public static IntentProvider create(final Object target) {
        if (target instanceof Activity) {
            return new ActivityIntentProvider((Activity) target);
        }

        if (target instanceof FragmentActivity) {
            return new FragmentActivityIntentProvider((FragmentActivity) target);
        }

        if (target instanceof Fragment) {
            return new FragmentIntentProvider((Fragment) target);
        }

        if (target instanceof android.support.v4.app.Fragment) {
            return new nl.capaxit.bundlestatelib.state.intent.provider.v4.FragmentIntentProvider((android.support.v4.app.Fragment) target);
        }

        throw new IllegalArgumentException(String.format("No IntentProvider found for %s.", target));
    }
}
