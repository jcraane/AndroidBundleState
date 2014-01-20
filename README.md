AndroidBundleState
==================

Libarry which provide utilities which makes handling activity/fragment state more easy and transparent.

The BundleStateLib provides a BundleState annotation and corresponding base activities/fragments which process 
the BundleState annotation.

Everyone who creates Android applications comes to a point where the application is tested when the device is rotated.
Rotating the device means Android destroys and recreates the current activity. If the state that is present in the activity 
is not saved correctly, the state is lost and user experience is affected.

The proper way to handle device orientation changes and acivity destroy/resume is by using the Bundle. 

IMPORTANT: Bundle state is GONE when the application crashes or shuts down. To have state survive application
restarts use another mechanism like preferecens or a SQLite database.

Using the Bundle to save and restore state can be cumbersome. You have to implement a couple of lifecycle methods which are duplicated
in every activity that must save/restore its state.

This project aims to make saving and storing state using the Bundle easy and transparant.

Example:

public class StateDemoActivity extends BundleStateActivity {
    @BundleState("state_name") // This field is saved/restored in the Bundle.
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.state_demo_activity);

        findViewById(R.id.random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                name = String.valueOf(new Random().nextInt(100));
                ((TextView) findViewById(R.id.name)).setText(name);
            }
        });

        ((TextView) findViewById(R.id.name)).setText(name);
    }
}

