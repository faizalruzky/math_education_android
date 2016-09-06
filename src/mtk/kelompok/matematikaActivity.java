package mtk.kelompok;


import mtk.arifandy.com.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class matematikaActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View materi = findViewById(R.id.materi); 
    	materi.setOnClickListener((OnClickListener) this);
    	View soal = findViewById(R.id.soal); 
    	soal.setOnClickListener((OnClickListener) this);
    	View about = findViewById(R.id.about); 
    	about.setOnClickListener((OnClickListener) this);
    	View help = findViewById(R.id.help); 
    	help.setOnClickListener((OnClickListener) this);
    	View exit = findViewById(R.id.keluar); 
    	exit.setOnClickListener((OnClickListener) this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
        
        case R.id.materi:
        	Intent menu = new Intent(this, pilihkelas.class);
            startActivity(menu);
             break;
        case R.id.soal:
        	Intent menu3 = new Intent(this, pilihkelassoal.class);
        	startActivity(menu3);
        	break;
        case R.id.about:
        	Intent menu1 = new Intent(this, tentang.class);
            startActivity(menu1);
              break;
        case R.id.help:
        	Intent menu2 = new Intent(this, bantuan.class);
            startActivity(menu2);
              break;
        case R.id.keluar:
        	AlertDialog.Builder mauKeluar = new AlertDialog.Builder(matematikaActivity.this);
    		mauKeluar.setMessage("Yakin Anda Mau Keluar ?").setCancelable(false)
    		.setPositiveButton("YA",new AlertDialog.OnClickListener(){
    			
    			public void onClick(DialogInterface arg0,int arg1){
    				Intent exit = new Intent (Intent.ACTION_MAIN);
    				exit.addCategory(Intent.CATEGORY_HOME);
    				exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    				startActivity(exit);
    			}
    		})
    		.setNegativeButton("TIDAK",new AlertDialog.OnClickListener(){
    			
    			public void onClick(DialogInterface dialog,int arg1){
    			dialog.cancel();
    			}	
    		});
    		AlertDialog judul = mauKeluar.create();
    		judul.setTitle("Keluar ?");
    		judul.show();
        }
    }
}