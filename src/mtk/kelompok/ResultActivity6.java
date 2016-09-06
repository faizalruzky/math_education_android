package mtk.kelompok;



import mtk.arifandy.com.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity6 extends Activity
{

	private TextView	result;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		result = (TextView) findViewById(R.id.hasil);

		Bundle b = getIntent().getExtras();
		if (b != null)
		{
			result.setText("Nama : " + b.getString("user")
					+ "\n Score : " + b.getInt("score")
					+ "\n time : " + b.getInt("time")
					);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();

		startActivity(new Intent(this, SoalActivity6.class));
		finish();
	}

}
