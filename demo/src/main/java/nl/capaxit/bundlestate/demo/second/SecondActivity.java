package nl.capaxit.bundlestate.demo.second;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import nl.capaxit.bundlestate.demo.R;
import nl.capaxit.bundlestatelib.state.activity.BundleStateActivity;
import nl.capaxit.bundlestatelib.state.annotations.IntentData;

/**
 * Created by jamiecraane on 30/03/16.
 */
public class SecondActivity extends BundleStateActivity {
    public static final String INTENT_STRING_VALUE = "intent:stringValue";
    public static final String INTENT_STRING_DEFAULT = "intent:stringValueDefault";

    @IntentData(name = INTENT_STRING_VALUE, required = true)
    private String stringValue;

    @IntentData(name = INTENT_STRING_DEFAULT, defaultValue = "StandaardWaarde")
    private String stringWithDefault;

    private int intValue;

    private PersonData objectValue;

    private boolean booleanValue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final String values = new StringBuilder("stringValue = ").append(stringValue).append("\n")
                .append("stringWithDefault = ").append(stringWithDefault).append("\n")
                .append("intValue = ").append(intValue).append("\n")
                .append("objectValue = ").append(objectValue).append("\n")
                .append("booleanValue = ").append(booleanValue).toString();
        ((TextView) findViewById(R.id.intentData)).setText(values);
    }

    public static class PersonData implements Serializable {
        private static final long serialVersionUID = 3994991407139088449L;

        private final String firstName;
        private final String lastName;

        public PersonData(final String firstName, final String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("PersonData{");
            sb.append("firstName='").append(firstName).append('\'');
            sb.append(", lastName='").append(lastName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
