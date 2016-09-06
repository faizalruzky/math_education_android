package mtk.kelompok;


import java.util.Collections;
import java.util.List;

import mtk.arifandy.com.R;
import mtk.kelompok.entity.Quiz;

import mtk.kelompok.util.DBAdapter1;
import mtk.kelompok.util.Utils;


import com.actionbarsherlock.app.SherlockActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity class
 * 
 * @author pratama
 * 
 */
public class SoalActivity1 extends SherlockActivity implements OnClickListener
{
	private static final String	TAG			= SoalActivity1.class.getName();

	private TextView			soal, user, txtScore, soalCounter, timer;
	private Button				btnNext;
	private RadioGroup			rg_answer;
	private RadioButton			rb_A, rb_B, rb_C;

	private DBAdapter1			mDb;
	private List<Quiz>			mListQuiz;
	private Quiz				mQuiz;
	private CountDownTimer		mCountDownTimer;

	private int					mScore;
	private int					mTime		= 0;
	private int					currentSoal	= 0;
	private static final int	milisecond	= 1000;
	private static final int	second		= 90;
	private static final int	detik		= second * milisecond;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// instance dbAdapter
		mDb = DBAdapter1.getInstance(this);

		// get data soal
		mListQuiz = mDb.getAllSoal1();
		
		// acak list
		Collections.shuffle(mListQuiz);

		setupView();

		// tampilkan input username
		showInputUser();
	}

	/**
	 * state awal quiz..
	 */
	private void mulaiQuiz()
	{
		setupSoal();

		setupTimer();
	}

	/**
	 * input user name
	 */
	private void showInputUser()
	{
		LayoutInflater mInflater = LayoutInflater.from(this);
		View v = mInflater.inflate(R.layout.input_user, null);

		final AlertDialog dialog = new AlertDialog.Builder(this).create();

		dialog.setView(v);
		dialog.setTitle("Input Username");

		final Button btnOk = (Button) v.findViewById(R.id.btnOk);
		final EditText inputUser = (EditText) v.findViewById(R.id.inputUser);

		btnOk.setOnClickListener(new View.OnClickListener()
		{

			public void onClick(View v)
			{
				user.setText(inputUser.getText().toString());

				mulaiQuiz();

				dialog.dismiss();

			}
		});

		dialog.show();

	}

	/**
	 * Set timer
	 */
	private void setupTimer()
	{
		mCountDownTimer = new CountDownTimer(detik, 1000)
		{

			@Override
			public void onTick(long millisUntilFinished)
			{
				// TODO Auto-generated method stub
				timer.setText("time: " + millisUntilFinished / 1000 +
						" detik");
				mTime = (int) (millisUntilFinished / 1000);
			}

			@Override
			public void onFinish()
			{
				// TODO Auto-generated method stub
				timer.setText("time: 0 detik");
				Toast.makeText(SoalActivity1.this, "Waktu Habis",
						Toast.LENGTH_SHORT).show();
			}
		};

		mCountDownTimer.start();

	}

	/**
	 * setup soal
	 */
	private void setupSoal()
	{
		Utils.TRACE(TAG, "Soal ke - " + currentSoal);
		Utils.TRACE(TAG, "Size - " + mListQuiz.size());

		// clear checked radiobutton
		rg_answer.clearCheck();

		// get soal berdasar index
		mQuiz = mListQuiz.get(currentSoal);

		// set counter soal
		soalCounter.setText("Soal ke - " + (currentSoal + 1));
		// set soalnya
		soal.setText(mQuiz.getSoal());

		rb_A.setText("A. " + mQuiz.getJawaban_a());
		rb_B.setText("B. " + mQuiz.getJawaban_b());
		rb_C.setText("C. " + mQuiz.getJawaban_c());

		currentSoal++;
	}

	/**
	 * Untuk setup view
	 */
	private void setupView()
	{
		soal = (TextView) findViewById(R.id.txtSoal);
		soalCounter = (TextView) findViewById(R.id.txtSoalCount);
		txtScore = (TextView) findViewById(R.id.txtScore);
		user = (TextView) findViewById(R.id.txtUser);
		timer = (TextView) findViewById(R.id.timer);

		txtScore.setText("Score : " + mScore);

		rb_A = (RadioButton) findViewById(R.id.rb_A);
		rb_B = (RadioButton) findViewById(R.id.rb_B);
		rb_C = (RadioButton) findViewById(R.id.rb_C);
		rg_answer = (RadioGroup) findViewById(R.id.rgAnswer);
		btnNext = (Button) findViewById(R.id.btnNext);

		btnNext.setOnClickListener(this);

	}

	public void onClick(View v)
	{
		if (v == btnNext)
		{

			if (getAnswer().equals(mQuiz.getJawaban_benar().toUpperCase()))
			{
				mScore += 10;
				txtScore.setText("Score : " + mScore);
				// setupSoal();
			}

			if (currentSoal < mListQuiz.size())
			{
				setupSoal();
			} else
			{
				mTime = second - mTime;

				Bundle bundle = new Bundle();
				bundle.putString("user", user.getText().toString());
				bundle.putInt("score", mScore);
				bundle.putInt("time", mTime);

				Intent i = new Intent(SoalActivity1.this, ResultActivity1.class);
				i.putExtras(bundle);
				startActivity(i);
				finish();

			}

			Utils.TRACE(TAG, "Your score " + mScore);

		}

	}

	/**
	 * Method untuk mengecek radio button yang dipilih
	 * 
	 * @return nilai A, B atau C
	 */
	private String getAnswer()
	{
		switch (rg_answer.getCheckedRadioButtonId())
		{
			case R.id.rb_A:
				return "A";
			case R.id.rb_B:
				return "B";
			case R.id.rb_C:
				return "C";
		}
		return "";
	}

}
