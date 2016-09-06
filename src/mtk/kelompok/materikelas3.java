package mtk.kelompok;


import mtk.arifandy.com.R;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class materikelas3 extends Activity {
	ListView list1;
	String[] menu = new String[] { "Letak Bilangan","Operasi Tambah Kurang",
		
			"Kembali"};
	// Create an ArrayAdapter, that will actually make the Strings above
	// appear in the ListView
	// Menset nilai array ke dalam list adapater sehingga data pada array
	// akan dimunculkan dalam list


	/**
	 * Called when the activity is first created. Method ini akan dipanggil pada
	 * saat aplikasi dijalankan
	 */
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backgroundlist);
        list1 = (ListView)findViewById(R.id.list);
        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        list1.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3){
        		Intent i = null;
        		if (position == 0){
        			i = new Intent(materikelas3.this, letakbilangan.class);}
        		else if(position == 1){
        			i = new Intent(materikelas3.this, operasipenjumlahandanpengurangan.class);}
        		
    			else if(position == 2){
    				i = new Intent(materikelas3.this, matematikaActivity.class);
    				finish();}
    			else{}
        	
        	startActivity(i);
        	}
        });}
	public void onBackPressed(){
		finish();
		System.exit(0);
		}
	}
		

