package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY   = "Entered the onRestart() method";
	private static final String RESUME_KEY    = "Entered the Resume() method";
	private static final String START_KEY     = "Entered the Start() method";
	private static final String CREATE_KEY    = "Entered the Create() method";
	private static final String PAUSE_KEY     = "Entered the Pause() method";
	private static final String DESTROY_KEY   = "Entered the Destroy() method";
	private static final String STOP_KEY      = "Entered the Stop() method";
	
	private static final String CREATE_STATE  = "";
	private static final String START_STATE   = "";
	private static final String RESTART_STATE = "";
	private static final String RESUME_STATE  = "";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	// DONE:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
    private int mStart   = 0;
    private int mRestart = 0;
    private int mCreate  = 0;
    private int mResume  = 0;


	// DONE: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView mTvRestart;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// DONE: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate  = (TextView) findViewById(R.id.create);
        mTvStart   = (TextView) findViewById(R.id.start);
        mTvResume  = (TextView) findViewById(R.id.resume);
        mTvRestart = (TextView) findViewById(R.id.restart);


		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// DONE:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to start
				Intent myIntent = new Intent(ActivityOne.this, ActivityTwo.class);
				
				// Launch the Activity using the intent
				ActivityOne.this.startActivity(myIntent);
			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// DONE:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_STATE);
			mStart = savedInstanceState.getInt(START_STATE);
			mRestart = savedInstanceState.getInt(RESTART_STATE);
			mResume = savedInstanceState.getInt(RESUME_STATE);
		}

		// DONE: Emit LogCat message
        Log.i(TAG,CREATE_KEY);

		// DONE:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate += 1;
        displayCounts();

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// DONE: Emit LogCat message
		Log.i(TAG,START_KEY);

		// DONE:
		// Update the appropriate count variable
		// Update the user interface
        mStart += 1;
        displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// DONE: Emit LogCat message
		Log.i(TAG,RESUME_KEY);

		// DONE:
		// Update the appropriate count variable
		// Update the user interface
        mResume += 1;
        displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// DONE: Emit LogCat message
		Log.i(TAG,PAUSE_KEY);
	}

	@Override
	public void onStop() {
		super.onStop();

		// DONE: Emit LogCat message
		Log.i(TAG,STOP_KEY);
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// DONE: Emit LogCat message
		Log.i(TAG,"Entered the Activity1.onRestart() method");

		// DONE:
		// Update the appropriate count variable
		// Update the user interface
        mRestart += 1;
        displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// DONE: Emit LogCat message
		Log.i(TAG,DESTROY_KEY);

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// DONE:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(START_STATE, mStart);
		savedInstanceState.putInt(RESTART_STATE, mRestart);
		savedInstanceState.putInt(RESUME_STATE, mResume);
		savedInstanceState.putInt(CREATE_STATE, mCreate);
		
		super.onSaveInstanceState(savedInstanceState);
	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
