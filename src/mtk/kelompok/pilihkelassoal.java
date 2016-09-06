package mtk.kelompok;

import mtk.arifandy.com.R;
import mtk.kelompok.pilihkelassoal;

import android.os.Bundle;
import android.view.View;


import android.widget.Button;
import android.app.Activity;


import android.content.Intent;


public class pilihkelassoal extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pilihkelassoal);
	
		 /**
         * Creating all buttons instances
         * */
        Button materi4 = (Button) findViewById(R.id.soalkelas4);
        Button materi5 = (Button) findViewById(R.id.soalkelas5);
        Button materi6 = (Button) findViewById(R.id.soalkelas6);
        Button materi3 = (Button) findViewById(R.id.soalkelas3);
        Button materi2 = (Button) findViewById(R.id.soalkelas2);
        Button materi1 = (Button) findViewById(R.id.soalkelas1);
       
     
        
        
               
        /**
         * Handling all button click events
         * */
        
        // Listening to News Feed button click
            materi4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), SoalActivity4.class);
				startActivity(i);
	}
			
            });
           materi5.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), SoalActivity5.class);
    				startActivity(i);
    	}
    			
                });
           materi6.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), SoalActivity6.class);
   				startActivity(i);
   	}
   			
               });
           materi3.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), SoalActivity.class);
   				startActivity(i);
   	}
   			
               });
          
           materi2.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), SoalActivity1.class);
   				startActivity(i);
   	}
   			
               });  
           
           materi1.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				// Launching News Feed Screen
   				Intent i = new Intent(getApplicationContext(), SoalActivity1.class);
   				startActivity(i);
   	}
   			
               });
	}


}

