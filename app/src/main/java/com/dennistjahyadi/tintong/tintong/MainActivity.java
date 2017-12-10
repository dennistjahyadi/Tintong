package com.dennistjahyadi.tintong.tintong;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar.LayoutParams;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import java.util.Random;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends Activity implements OnTouchListener {
	GameScreen screen;
	boolean allow = true;
	AdView adView;
	AdRequest adRequest;
	InterstitialAd mInterstitialAd;
	String adUnitId = "ca-app-pub-4908922088432819/7245390082";
	Random rand = new Random();
	int lucky;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RelativeLayout layout = new RelativeLayout(this);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(adUnitId);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                
            }
            
        });
        
        requestNewInterstitial();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

		screen = new GameScreen(this);
		screen.setOnTouchListener(this);
		
		layout.addView(screen);
		setContentView(layout);
		
		
	}
	
	void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                  .addTestDevice("76B23C2B01CA395D5FF30623EBB326DF")
                  .build();

        mInterstitialAd.loadAd(adRequest);
    }
		

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		screen.resume();
		
		
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		screen.pause();
		}
	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction())
		{
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_DOWN:
			
			screen.setSpeedAllow();

			break;

		}
		
		switch(event.getAction())
		{
		
		case MotionEvent.ACTION_DOWN:
			lucky = rand.nextInt(3);

			if (mInterstitialAd.isLoaded() && screen.lose==true && lucky==1) {
	            mInterstitialAd.show();
	            
			
		}else{
			screen.lose=false;
			screen.beginning=false;
			if(screen.and==true){
				if(screen.allow)
				{
				
				screen.setX(event.getX());
				screen.setHeight();
				screen.allow=false;
				
				}
				screen.beginning=false;
				screen.and1=true;
			}
			screen.and=true;
			
		}
		break;

			}
        
		
		return true;
		
	}
	
	
	
}


	
	

