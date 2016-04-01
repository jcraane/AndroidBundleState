package nl.capaxit.bundlestate.demo.second;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import nl.capaxit.bundlestate.demo.R;
import nl.capaxit.bundlestatelib.state.activity.BundleStateActivity;
import nl.capaxit.bundlestatelib.state.annotations.IntentExtra;

/**
 * Created by jamiecraane on 30/03/16.
 */
public class SecondActivity extends BundleStateActivity {
    public static final String INTENT_STRING_VALUE = "intent:stringValue";
    public static final String INTENT_STRING_DEFAULT = "intent:stringValueDefault";
    public static final String INTENT_INTEGER = "intent:integerValue";
    public static final String INTENT_INTEGER_DEFAULT = "intent:integerValueDefault";
    public static final String INTENT_BOOLEAN = "intent:booleanValue";
    public static final String INTENT_BOOLEAN_DEFAULT = "intent:booleanValueDefault";
    public static final String INTENT_OBJECT = "intent:objectValue";

    @IntentExtra(name = INTENT_STRING_VALUE, required = true)
    private String stringValue;

    @IntentExtra(name = INTENT_STRING_DEFAULT, defaultValue = "StandaardWaarde")
    private String stringWithDefault;

    @IntentExtra(name = INTENT_INTEGER)
    private int intValue;

    @IntentExtra(name = INTENT_INTEGER_DEFAULT, defaultValue = "10")
    private int intValueDefault;

//    @IntentData(name = INTENT_BOOLEAN)
    private boolean booleanValue;

//    @IntentData(name = INTENT_BOOLEAN_DEFAULT, defaultValue = "true")
    private boolean booleanValueDefault;

    private PersonData objectValue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final String values = new StringBuilder("stringValue = ").append(stringValue).append("\n")
                .append("stringWithDefault = ").append(stringWithDefault).append("\n")
                .append("intValue = ").append(intValue).append("\n")
                .append("intValueDefault = ").append(intValueDefault).append("\n")
                .append("booleanValue = ").append(booleanValue)
                .append("booleanValueDefault = ").append(booleanValueDefault)
                .append("objectValue = ").append(objectValue).append("\n").toString();
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
