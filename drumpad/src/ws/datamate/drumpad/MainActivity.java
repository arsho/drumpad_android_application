package ws.datamate.drumpad;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends Activity {

	View bass_pad, snare_pad, tom1_pad, tom2_pad, cymbal1_pad, cymbal2_pad,
			hihat1_pad, hihat2_pad;
	MediaPlayer mp, bass_pad_mp, snare_pad_mp, tom1_pad_mp, tom2_pad_mp,
			cymbal1_pad_mp, cymbal2_pad_mp, hihat1_pad_mp, hihat2_pad_mp;
	float count = 100 * .01f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bass_pad = (View) findViewById(R.id.bass_pad);
		snare_pad = (View) findViewById(R.id.snare_pad);
		tom1_pad = (View) findViewById(R.id.tom1_pad);
		tom2_pad = (View) findViewById(R.id.tom2_pad);
		cymbal1_pad = (View) findViewById(R.id.cymbal1_pad);
		cymbal2_pad = (View) findViewById(R.id.cymbal2_pad);
		hihat1_pad = (View) findViewById(R.id.hihat1_pad);
		hihat2_pad = (View) findViewById(R.id.hihat2_pad);

		bass_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.bass);
		snare_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.snare);
		tom1_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.tom1);
		tom2_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.tom2);
		cymbal1_pad_mp = MediaPlayer.create(MainActivity.this,
				R.raw.crashcymbal);
		cymbal2_pad_mp = MediaPlayer
				.create(MainActivity.this, R.raw.ridecymbal);
		hihat1_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.openhihat);
		hihat2_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.closehihat);

		bass_pad.setOnClickListener(play_sound);
		snare_pad.setOnClickListener(play_sound);
		tom1_pad.setOnClickListener(play_sound);
		tom2_pad.setOnClickListener(play_sound);
		cymbal1_pad.setOnClickListener(play_sound);
		cymbal2_pad.setOnClickListener(play_sound);
		hihat1_pad.setOnClickListener(play_sound);
		hihat2_pad.setOnClickListener(play_sound);

	}

	View.OnClickListener play_sound = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.bass_pad:

				if (bass_pad_mp != null) {
					bass_pad_mp.stop();
					bass_pad_mp.release();
				}
				bass_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.bass);
				bass_pad_mp.setVolume(count, count);
				bass_pad_mp.start();
				break;
			case R.id.snare_pad:
				if (snare_pad_mp != null) {
					snare_pad_mp.stop();
					snare_pad_mp.release();
				}
				snare_pad_mp = MediaPlayer.create(MainActivity.this,
						R.raw.snare);
				snare_pad_mp.setVolume(count, count);
				snare_pad_mp.start();

				break;
			case R.id.tom1_pad:
				if (tom1_pad_mp != null) {
					tom1_pad_mp.stop();
					tom1_pad_mp.release();
				}
				tom1_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.tom1);

				tom1_pad_mp.setVolume(count, count);
				tom1_pad_mp.start();
				break;
			case R.id.tom2_pad:
				if (tom2_pad_mp != null) {
					tom2_pad_mp.stop();
					tom2_pad_mp.release();
				}
				tom2_pad_mp = MediaPlayer.create(MainActivity.this, R.raw.tom2);

				tom2_pad_mp.setVolume(count, count);
				tom2_pad_mp.start();
				break;
			case R.id.cymbal1_pad:
				if (cymbal1_pad_mp != null) {
					cymbal1_pad_mp.stop();
					cymbal1_pad_mp.release();
				}
				cymbal1_pad_mp = MediaPlayer.create(MainActivity.this,
						R.raw.crashcymbal);

				cymbal1_pad_mp.setVolume(count, count);
				cymbal1_pad_mp.start();
				break;
			case R.id.cymbal2_pad:
				if (cymbal2_pad_mp != null) {
					cymbal2_pad_mp.stop();
					cymbal2_pad_mp.release();
				}
				cymbal2_pad_mp = MediaPlayer.create(MainActivity.this,
						R.raw.ridecymbal);

				cymbal2_pad_mp.setVolume(count, count);
				cymbal2_pad_mp.start();

				break;
			case R.id.hihat1_pad:
				if (hihat1_pad_mp != null) {
					hihat1_pad_mp.stop();
					hihat1_pad_mp.release();
				}
				hihat1_pad_mp = MediaPlayer.create(MainActivity.this,
						R.raw.openhihat);

				hihat1_pad_mp.setVolume(count, count);
				hihat1_pad_mp.start();

				break;
			case R.id.hihat2_pad:
				if (hihat2_pad_mp != null) {
					hihat2_pad_mp.stop();
					hihat2_pad_mp.release();
				}
				hihat2_pad_mp = MediaPlayer.create(MainActivity.this,
						R.raw.closehihat);

				hihat2_pad_mp.setVolume(count, count);
				hihat2_pad_mp.start();
				break;
			default:
				break;
			}
		}

	};

	// event handler for back button press
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setMessage("Are you sure to exit?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								bass_pad_mp.stop();
								bass_pad_mp.release();
								snare_pad_mp.stop();
								snare_pad_mp.release();
								tom1_pad_mp.stop();
								tom1_pad_mp.release();
								tom2_pad_mp.stop();
								tom2_pad_mp.release();
								cymbal1_pad_mp.stop();
								cymbal1_pad_mp.release();
								cymbal2_pad_mp.stop();
								cymbal2_pad_mp.release();
								hihat1_pad_mp.stop();
								hihat1_pad_mp.release();
								hihat2_pad_mp.stop();
								hihat2_pad_mp.release();

								MainActivity.this.finish();
							}
						}).setNegativeButton("No", null).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
