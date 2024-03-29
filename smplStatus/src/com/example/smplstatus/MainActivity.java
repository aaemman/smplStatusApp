package com.example.smplstatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;

import com.facebook.Session;

public class MainActivity extends FragmentActivity {

	private String TAG = "MainActivity";
	private TextView lblEmail;

	private MainFragment mainFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// try {
		// PackageInfo info = getPackageManager().getPackageInfo(
		// "com.example.testfacebookapp", PackageManager.GET_SIGNATURES);
		// for (Signature signature : info.signatures) {
		// MessageDigest md = MessageDigest.getInstance("SHA");
		// md.update(signature.toByteArray());
		// System.out.println("-------------------------"+
		// Base64.encodeToString(md.digest(), Base64.DEFAULT));
		// }
		// } catch (NameNotFoundException e) {
		//
		// } catch (NoSuchAlgorithmException e) {}

		// lblEmail = (TextView) findViewById(R.id.welcome);
		//
		// LoginButton authButton = (LoginButton) findViewById(R.id.authButton);
		// authButton.setOnErrorListener(new OnErrorListener() {
		//
		// @Override
		// public void onError(FacebookException error) {
		// Log.i(TAG, "Error " + error.getMessage());
		// }
		// });
		// // set permission list, Don't foeget to add email
		// authButton.setReadPermissions(Arrays.asList("basic_info","email"));
		// // session state call back event
		// authButton.setSessionStatusCallback(new Session.StatusCallback() {
		//
		// @Override
		// public void call(Session session, SessionState state, Exception
		// exception) {
		//
		// if (session.isOpened()) {
		// Log.i(TAG,"Access Token"+ session.getAccessToken());
		// Request.executeMeRequestAsync(session,
		// new Request.GraphUserCallback() {
		// @Override
		// public void onCompleted(GraphUser user,Response response) {
		// if (user != null) {
		// Log.i(TAG,"User ID "+ user.getId());
		// Log.i(TAG,"Email "+ user.asMap().get("email"));
		// String email = (String)
		// response.getGraphObject().getProperty("email");
		// lblEmail.setText(email);
		// }
		// }
		// });
		// }
		//
		// }
		// });
		// }
		//
		// @Override
		// public void onActivityResult(int requestCode, int resultCode, Intent
		// data) {
		// super.onActivityResult(requestCode, resultCode, data);
		// Session.getActiveSession().onActivityResult(this, requestCode,
		// resultCode, data);
		// }
		// }

		// -------------------------------------------------------------------------------------------------

		//
		//
		// @Override
		// protected void onCreate(Bundle savedInstanceState) {
		// super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		//
		// // start Facebook Login
		// Session.openActiveSession(this, true, new Session.StatusCallback() {
		//
		// // callback when session changes state
		// @Override
		// public void call(Session session, SessionState state, Exception
		// exception) {
		// if (session.isOpened()) {
		// // make request to the /me API
		// Request.executeMeRequestAsync(session, new
		// Request.GraphUserCallback() {
		//
		// // callback after Graph API response with user object
		// @Override
		// public void onCompleted(GraphUser user, Response response) {
		// if (user != null) {
		// TextView welcome = (TextView) findViewById(R.id.welcome);
		// welcome.setText("Hello " + user.getName() + "!");
		// }
		// }
		// });
		// }
		// }
		// });
		// }

		// -----------------------------------------------------------------------------------

		// APP_ID = getString(R.string.app_id);

		if (savedInstanceState == null) {
			// Add the fragment on initial activity setup
			mainFragment = new MainFragment();
			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, mainFragment).commit();
		} else {
			// Or set the fragment from restored state info
			mainFragment = (MainFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
