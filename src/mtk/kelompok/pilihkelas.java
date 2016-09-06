package mtk.kelompok;

import mtk.arifandy.com.R;
import mtk.kelompok.pilihkelas;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.app.Activity;


import android.content.Intent;


public class pilihkelas extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pilihkelas);
	
		 /**
         * Creating all buttons instances
         * */
        Button materi4 = (Button) findViewById(R.id.kelas4);
        Button materi3 = (Button) findViewById(R.id.kelas3);
        Button materi5 = (Button) findViewById(R.id.kelas5);
        Button materi2 = (Button) findViewById(R.id.kelas2);
        Button materi1 = (Button) findViewById(R.id.kelas1);
        Button materi6 = (Button) findViewById(R.id.kelas6);
       
      
        
        
               
        /**
         * Handling all button click events
         * */
        
        // Listening to News Feed button click
            materi4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), materikelas4.class);
				startActivity(i);
	}
			
            });
           materi3.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), materikelas3.class);
    				startActivity(i);
    	}
    			
                });
          
           materi5.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), materikelas5.class);
   				startActivity(i);
   	}
   			
               });
           materi2.setOnClickListener(new View.OnClickListener() {
      			
      			public void onClick(View view) {
      				// Launching News Feed Screen
      				Intent i = new Intent(getApplicationContext(), materikelas2.class);
      				startActivity(i);
      	}
      			
                  });
           materi1.setOnClickListener(new View.OnClickListener() {
     			
     			public void onClick(View view) {
     				// Launching News Feed Screen
     				Intent i = new Intent(getApplicationContext(), materikelas1.class);
     				startActivity(i);
     	}
     			
                 });
           materi6.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), materikelas4.class);
   				startActivity(i);
   	}
   			
               });
         
           
	}


}

