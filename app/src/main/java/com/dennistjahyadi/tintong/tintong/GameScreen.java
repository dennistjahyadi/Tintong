package com.dennistjahyadi.tintong.tintong;

import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;


public class GameScreen extends SurfaceView implements Runnable {
	boolean bool = true,a=true,and = false, and1=false,lose = false,allow = true,
			beginning = true,start=true,blue=true,green=true,red=true,resetScore=false,play=true,
			on=true,heart1,heart2,heart3,stuckScreen = false,
			lvl2=false,lvl3=false,lvl4=false,lvl5=false,showAds=false,
			speedAllow=true, drawBit=true, alive=true,
			a12=true,c1=true,c2=true,c3=true,c4=true,c5=true,c6=true,c7=true,c8=true,c9=true,c10=true,c11=true;
	Context context;
	SurfaceHolder holder;
	Canvas c;
	Thread t;
	float x,ox=100, ox1=200,ox2=400,ox3=320,ox4=450, 
		oxSpeed=0,oxSpeed1=0,oxSpeed2=0,oxSpeed3=0,oxSpeed4=0,
	oox,oox1,oox2,oox3,oox4;
	int y=-5, num,num1,num2,num3,num4,savestate,scores=0,checkpoint,hiScore,soundIds[] = new int[4],xball,yball, ySpeedball;
	int getWidth,getHeight;
	SoundPool sp; 
	Bitmap bitmap,bitmap1,bitmap2;
	Paint p = new Paint();
	Paint p1 = new Paint();
	Paint p2 = new Paint();
	Random rand = new Random();
	int[] inte	 = new int[] {55,60,65,70,75,80,85,90};
	Handler handler;
	Typeface typeface;
	int blue1,black,cyan,gray,green1,magenta,red1,yellow,darkgrey;
	Style fill,stroke,fillstroke;
	public GameScreen(Context context) {
		super(context);
		holder = getHolder();
		this.context=context;
		handler = new Handler();
		
	}
	
	
public void setX(float x){
		
		xball=(int)x;
	}
	
	public void setHeight(){
		if(holder.getSurface().isValid())
		{
			c = holder.lockCanvas();
			yball = getHeight;
			holder.unlockCanvasAndPost(c);
		}
		
	}

	public void resume(){
		bool =true;
		t = new Thread(this);
		
		t.start();
	}
	
	
	public void pause(){
		bool = false;
		while(true)
		{try{
			t.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		break;
			
		}
		
	}

	public void setSpeedAllow(){
		if(speedAllow==true)
		{
			speedAllow=false;
		}else
		if(speedAllow==false)
		{
			speedAllow=true;
			
		}
		

	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stu
		sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		soundIds[0] = sp.load(getContext(), R.raw.bounce, 1);
		soundIds[1] = sp.load(getContext(), R.raw.pew, 1);
		soundIds[2] = sp.load(getContext(), R.raw.point, 1);
		soundIds[3] = sp.load(getContext(), R.raw.collusion, 1);
		typeface = Typeface.createFromAsset(context.getAssets(), "fonts/boom.ttf");
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mus1);
		bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.mus2);
		bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.luck1);
		fill = Style.FILL;
		stroke = Style.STROKE;
		fillstroke = Style.FILL_AND_STROKE;
		blue1 = Color.BLUE;
		 black = Color.BLACK;
		 cyan = Color.CYAN;
		 gray = Color.GRAY;
		 green1 = Color.GREEN;
		 magenta = Color.MAGENTA;
		 red1 = Color.RED;
		 yellow = Color.YELLOW;
		 darkgrey = Color.DKGRAY;
		displayScore();
		scores=checkpoint;
		
		if(savestate>=5)
		{savestate=0;}
		scores += savestate;
	
		while(bool)
		{
			
			if(holder.getSurface().isValid())
			{
				c = holder.lockCanvas();
				getWidth  = c.getWidth();
				getHeight = c.getHeight();
				drawing(c);
				
				holder.unlockCanvasAndPost(c);
			}

		}	
		
	}
	

	public void drawing(Canvas c){
		c.drawARGB(255, 255, 255, 255);
	
		if(and)
		{
		heart(c);
		
		if(scores==0)
		{
			num = 80;
		}
		if(scores>0)
		{
			num=50;
			num1=60;
			num2=60;
			num3=50;
			num4=40;
					
		}
		
		int a = rand.nextInt(7);
		int a1= rand.nextInt(7);
		int a2 = rand.nextInt(7);
		int a3 = rand.nextInt(7);
		int a4 = rand.nextInt(7);
		
		
		p.setColor(black);
		if(scores>51){
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 45;num1 -= 45;num2-= 45;num3-= 45;num4-= 45;
			p.setStyle(fillstroke);
			p.setColor(black);
			
		}else
		if(scores==51){
			if(c11)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "Congrats you've finished this game, thank you for download and play until finish.. you can still play this game for get the highest level", Toast.LENGTH_LONG).show();
				  }
			});c11=false;
			}num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 45;num1 -= 45;num2-= 45;num3-= 45;num4-= 45;
			p.setStyle(fillstroke);
			p.setColor(black);
			
		}else
		
		if(scores==50){
			if(c10)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "Final Round!!! come on you can!! hihi.", Toast.LENGTH_LONG).show();
				  }
			});c10=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 45;num1 -= 45;num2-= 45;num3-= 45;num4-= 45;
			p.setStyle(stroke);
			p.setColor(black);
		}else
		if(scores>=45){
			if(c9)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "IMPOSIBLEE!!", Toast.LENGTH_LONG).show();
				  }
			});c9=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 40;num1 -= 40;num2-= 40;num3-=40;num4-= 40;
			p.setStyle(fill);
			p.setColor(darkgrey);
		}else
		if(scores>=40){
			if(c8)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "WAAAAAWWWWWW....", Toast.LENGTH_LONG).show();
				  }
			});c8=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 35;num1 -= 35;num2-= 35;num3-= 35;num4-= 35;
			p.setStyle(fill);
			p.setColor(yellow);
		}else
		if(scores>=35){
			if(c7)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "haha cool.. keep going..", Toast.LENGTH_LONG).show();
				  }
			});	c7=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 30;num1 -= 30;num2-=30;num3-= 30;num4-=30;
			p.setStyle(fill);
			p.setColor(red1);
		}else
		if(scores>=30){
			if(c6)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "lvl 30 its easy dude..", Toast.LENGTH_LONG).show();
				  }
			});c6=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 25;num1 -= 25;num2-= 25;num3-= 25;num4-= 25;
			p.setStyle(fill);
			p.setColor(magenta);
		}else
		if(scores>=25){
			if(c5)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "good game!!!", Toast.LENGTH_LONG).show();
				  }
			});	c5=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 20;num1 -= 20;num2-= 20;num3-= 20;num4-= 20;
			p.setStyle(fill);
			p.setColor(green1);
		}else	
		if(scores>=20){
			if(c4)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "Wow 20 its amazing!!!...", Toast.LENGTH_LONG).show();
				  }
			});c4=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 15;num1 -= 15;num2-= 15;num3-= 15;num4-= 15;
			p.setStyle(fill);
			p.setColor(gray);
		}else
		if(scores>=15){
			if(c3)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "CheckPoint :)", Toast.LENGTH_LONG).show();
				  }
			});c3=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 10;num1 -= 10;num2-= 10;num3-= 10;num4-= 10;
			p.setStyle(fill);
			p.setColor(cyan);
		}else
		if(scores>=10){
			if(c2)
			{handler.post(new Runnable(){
			    public void run(){
			Toast.makeText(getContext(), "CheckPoint :)", Toast.LENGTH_LONG).show();
				  }
			});c2=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
			num -= 5;num1 -= 5;num2-= 5;num3-= 5;num4-= 5;
			p.setStyle(fill);
			p.setColor(blue1);
		}else if(scores>=5){
			if(c1)
			{
				handler.post(new Runnable(){
				    public void run(){
			Toast.makeText(getContext(), "CheckPoint :)", Toast.LENGTH_LONG).show();
			  }
		});
			c1=false;
			}
			num = inte[a];num1 = inte[a1];num2 = inte[a2];num3 = inte[a3];num4 = inte[a4];
		}

		
		
		
			if (ox > getWidth)
			{		
				
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed = getWidth/-num;	
		
			}
			else if(ox < 0 )
			{
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
			
					oxSpeed = getWidth/num;
					
			}
			if (ox1 > getWidth)
			{
				if(scores>1){
					sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed1 = getWidth/-num1;
				}
			}
			else if(ox1 < 0 )
			{if(scores>1){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed1 = getWidth/num1;}
			}
			if (ox2 > getWidth)
			{if(scores>2){
				
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed2 = getWidth/-num2;	
					}		
			}
			else if(ox2 < 0 )
			{if(scores>2){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed2 = getWidth/num2;
					}
			}
			if (ox3 > getWidth)
			{if(scores>3){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed3 = getWidth/-num3;	}		
			}
			else if(ox3 < 0 )
			{if(scores>3){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed3 = getWidth/num3;}
			}
			if (ox4 > getWidth)
			{if(scores>4){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed4 = getWidth/-num4;	}		
			}
			else if(ox4 < 0 )
			{if(scores>4){
				sp.play(soundIds[0], 1, 1, 1, 0, 1);
					oxSpeed4 = getWidth/num4;}
			}
			
			ox += oxSpeed;

			setoo(ox);

			c.drawCircle(ox, getHeight*10/100, getWidth/25, p);
			
			if(scores>1 && lose==true ||scores>1)
			{	
				ox1 += oxSpeed1;
				setoo1(ox1);
				c.drawCircle(ox1, getHeight*25/100, getWidth/25, p);
				if(lvl2==false)
				{
				lvl2=true;
				}
				
			}
			if(scores>2 && lose==true|| scores>2)
			{
				ox2 += oxSpeed2;
				setoo2(ox2);								/*3*/
				c.drawCircle(ox2, getHeight*40/100, getWidth/25, p);
				if(lvl3==false)
				{
				lvl3=true;
				}
				
			}
			if(scores>3 && lose==true||scores>3)
			{	ox3 += oxSpeed3;
				setoo3(ox3);
				c.drawCircle(ox3, getHeight*55/100, getWidth/25, p);
				if(lvl4==false)
				{
				lvl4=true;
				}
				
			}
			if(scores>4 && lose==true||scores>4)
			{
				
				ox4 += oxSpeed4;
				setoo4(ox4);
				c.drawCircle(ox4, getHeight*70/100, getWidth/25, p);
				if(lvl5==false)
				{
				lvl5=true;
				}
			}
			
			

		drawRectangle(c);
		
	
		if(yball<-2)
		{
				xball=getWidth+50;
				and1=false;
				allow=true;
				yball=-1;
				play=true;
			
		}
		//draw circle//
		

			if(and1==true)
			{
			
				if(speedAllow==true)
				{
					ySpeedball = getHeight/-60;
				}else
				if (speedAllow==false){
					ySpeedball = getHeight/-220;
				}
				
				
				
				if(xball<10&&xball>-10){
					xball=10;
				}else if(xball>getWidth-10){
					xball=getWidth-10;
				}
				
				
			
			if(oox-getWidth/15 <xball && xball<oox+getWidth/15 &&  getHeight*10/100-30 <yball && yball<getHeight*10/100+30)
			{	
				if(heart1==true)
				{	
					drawBit=false;
					xball = -200;
					heart1=false;
					sp.play(soundIds[3], 1, 1, 1, 0, 1);
					
					
				}else if(heart2 ==true)
				{
					drawBit=false;
					xball = -200;
					heart2=false;
					sp.play(soundIds[3], 1, 1, 1, 0, 1);
				}else if(heart3==true)
				{	sp.play(soundIds[3], 1, 1, 1, 0, 1);
					
					heart3=false;
				}
				
				if(heart1==false && heart2==false &&heart3==false)
				{
					ySpeedball=0;
					stuckScreen=true;	
					c.drawBitmap(bitmap1, xball-24, yball-23, null);
					alive=false;
				}
						/*lvl 0 and 1*/
				if(!alive){
				
				}
			}
		
			if(lvl2==true)
			{	
				
				
				if(oox1-getWidth/15 <xball && xball<oox1+getWidth/15 &&  getHeight*25/100-30 <yball && yball<getHeight*25/100+30)
				{
					if(heart1==true)
					{	sp.play(soundIds[3], 1, 1, 1, 0, 1);
					drawBit=false;
					xball = -200;
						heart1=false;
						
					}else if(heart2 ==true)
					{drawBit=false;
					xball = -200;
						heart2=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}else if(heart3==true)
					{	sp.play(soundIds[3], 1, 1, 1, 0, 1);
						heart3=false;
					}
					if(heart1==false && heart2==false &&heart3==false)
					{
						ySpeedball=0;
						stuckScreen=true;	
						c.drawBitmap(bitmap1, xball-24, yball-23, null);
						alive=false;
					}
				}
			}
			if(lvl3==true)
			{	
				
				if(oox2-getWidth/15 <xball && xball<oox2+getWidth/15 &&  getHeight*40/100-30 <yball && yball<getHeight*40/100+30)
				{
					if(heart1==true)
					{drawBit=false;
					xball = -200;
						heart1=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}else if(heart2 ==true)
					{drawBit=false;
					xball = -200;
						heart2=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}else if(heart3==true)
					{sp.play(soundIds[3], 1, 1, 1, 0, 1);
						heart3=false;
						
					}
					if(heart1==false && heart2==false &&heart3==false)
					{
						ySpeedball=0;
						stuckScreen=true;	
						c.drawBitmap(bitmap1, xball-24, yball-23, null);
						alive=false;
					}
				}
			
			}
			if(lvl4==true)
			{	
			
				if(oox3-getWidth/15 <xball && xball<oox3+getWidth/15 &&  getHeight*55/100-30 <yball && yball<getHeight*55/100+30)
				{
					if(heart1==true)
					{drawBit=false;
					xball = -200;
						heart1=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}else if(heart2 ==true)
					{drawBit=false;
					xball = -200;
						heart2=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}else if(heart3==true)
					{sp.play(soundIds[3], 1, 1, 1, 0, 1);
						heart3=false;
						
					}
					
					if(heart1==false && heart2==false &&heart3==false)
					{
						ySpeedball=0;
						stuckScreen=true;	
						c.drawBitmap(bitmap1, xball-24, yball-23, null);
						alive=false;
					}
				}
			
			}
			if(lvl5==true)
			{
				if(oox4-getWidth/15 <xball && xball<oox4+getWidth/15 &&  getHeight*70/100-30 <yball && yball<getHeight*70/100+30)
				{
					if(heart1==true)
					{drawBit=false;
					sp.play(soundIds[3], 1, 1, 1, 0, 1);
					xball = -200;
						heart1=false;
					}else if(heart2 ==true)
					{drawBit=false;
					xball = -200;
					sp.play(soundIds[3], 1, 1, 1, 0, 1);
						heart2=false;
					}else if(heart3==true)
					{
						heart3=false;
						sp.play(soundIds[3], 1, 1, 1, 0, 1);
					}
					if(heart1==false && heart2==false &&heart3==false)
					{
						ySpeedball=0;
						stuckScreen=true;	
						c.drawBitmap(bitmap1, xball-24, yball-23, null);
						alive=false;
					}
				}
				
			}
			
			
			yball += ySpeedball;
			if(drawBit){
				showAds=false;
				if(alive)
				{	
					c.drawBitmap(bitmap, xball-24, yball-23, null);
				}
			alive=true;
			}
			
			if(play){
				drawBit=true;
			sp.play(soundIds[1], 1, 1, 1,0,1);
			play=false;
			
			}
			}
		
		}
		
		
		if(stuckScreen==true)
		{
			
			this.oxSpeed = 0;
			this.oxSpeed1 = 0;
			this.oxSpeed2 = 0;
			this.oxSpeed3 = 0;
			this.oxSpeed4 = 0;
			lose=true;
			
			lose(c);
			stuckScreen=false;
		} else
		if(beginning)
		{
			beginning(c);
			
		}
		else
		if(oxSpeed==0)
		{
			play=true;
			scores=checkpoint;
			lvl2=false;
			lvl3=false;
			lvl4=false;
			lvl5=false;
			heart1=true;
			heart2=true;
			heart3=true;
			allow=true;
			and1=false;
			blue=true;green=true;red=true;
			this.oxSpeed = getWidth/80;
			this.oxSpeed1 = getWidth/30;
			this.oxSpeed2 = getWidth/40;
			this.oxSpeed3 = getWidth/80;
			this.oxSpeed4 = getWidth/70;
		}
		
	}
	
	
public void beginning(Canvas c){
		
		p1.setTextSize(getWidth/18);
		p1.setColor(darkgrey);
		p1.setTypeface(typeface);
		c.drawText("TOUCH THE SCREEN TO START", getWidth/8, getHeight/2, p1);
		c.drawText("Tips: Touch and hold to slow down", getWidth/8, getHeight/2+60, p1);
		c.drawText("Highest Level: "+Integer.toString(hiScore), getWidth/5, getHeight/4, p1);
		allow=true;

	}




public void lose(Canvas c){
	showAds=true;
	p2.setARGB(150, 64, 64, 64);
	c.drawRect(0, 0, getWidth, getHeight, p2);
	p1.setTextSize(getWidth/18);
	p1.setColor(Color.YELLOW);
	p1.setTypeface(typeface);
	c.drawText("Touch to try again...", getWidth/8, getHeight/3, p1);
	c.drawText("Highest Level: "+Integer.toString(hiScore), getWidth/8, getHeight/3+50, p1);
	if(lose)
	{
		c.drawText("Level: "+Integer.toString(scores), getWidth/8, getHeight/3+100, p1);

			
	}
	allow=true;
	savestate=0;
	
}

	
	
	public void heart(Canvas c){
	
		if(heart3==true){
			c.drawBitmap(bitmap, getWidth-getWidth*15/100, getHeight-getHeight*10/100, null);

		}
		if(heart2==true){
			c.drawBitmap(bitmap, getWidth-getWidth*30/100, getHeight-getHeight*10/100, null);

			}
		if(heart1==true){
			c.drawBitmap(bitmap, getWidth-getWidth*45/100, getHeight-getHeight*10/100, null);

			}
	}
	
	
	
	
	public void drawRectangle(Canvas c){
		p.setStyle(fill);
		p.setColor(blue1);
		p1.setStyle(fill);
		p1.setColor(green1);
		p2.setStyle(fill);
		p2.setColor(red1);
		if(yball<-2 && xball>0&& xball<getWidth/3){
			blue=false;
		}else if(yball<-2 && xball>getWidth/3 && xball<getWidth/3*2){
			green=false;
		}
		else if(yball<-2 && xball>getWidth/3*2 && xball<getWidth){
			red=false;
		}
		if(blue)
		{
			c.drawRect(0, 0, getWidth/3, getHeight*2/100, p);
		}
		if(green)
		{
			c.drawRect(getWidth/3, 0, getWidth/3*2, getHeight*2/100, p1);
		}
		if(red)
		{
			c.drawRect(getWidth/3*2, 0, getWidth, getHeight*2/100, p2);
		}
		if(!blue && !green && !red){
			
			scores += 1;
			savestate = scores-checkpoint;
			sp.play(soundIds[2], 1, 1, 1, 0, 1);
			blue=true;green=true;red=true;
			heart1=true;heart2=true;heart3=true;
			a12=true;
		}
		displayScore();
		drawScores();
	}
	
	
	public void setoo(float o){
		this.oox=o;
	}
	public void setoo1(float o){
		this.oox1=o;
		
	}
	public void setoo2(float o){
		this.oox2=o;
	}
	public void setoo3(float o){
		this.oox3=o;
	}
	public void setoo4(float o){
	this.oox4=o;
	}
	
	
	public void drawScores(){
	
	p1.setTextSize(getWidth/8);
	p1.setColor(black);
	c.drawText(Integer.toString(scores), 5, getHeight-5, p1);
	if(scores>=hiScore){
		saveScore(scores,scores);
	}
	
	}

	public void saveScore(int a, int b){
	SharedPreferences sp = getContext().getSharedPreferences("hiscoreInfo", Context.MODE_PRIVATE);
	SharedPreferences.Editor editor = sp.edit();
	editor.putInt("hScore", a);
	if(b>=50){b=scores;editor.putInt("cpoint", b);}else
	if(b>=45){b=45;editor.putInt("cpoint", b);}else
	if(b>=40){b=40;editor.putInt("cpoint", b);}else
	if(b>=35){b=35;editor.putInt("cpoint", b);}else
	if(b>=30){b=30;editor.putInt("cpoint", b);}else
	if(b>=25){b=25;editor.putInt("cpoint", b);}else
	if(b>=20){b=20;editor.putInt("cpoint", b);}else
	if(b>=15){b=15;editor.putInt("cpoint", b);}else
	if(b>=10){b=10;editor.putInt("cpoint", b);}else
	if(b>=5)
	{
		b=5;
	
		editor.putInt("cpoint", b);
	}
	
	editor.apply();
	
	}

	public void displayScore(){
	SharedPreferences sp = getContext().getSharedPreferences("hiscoreInfo", Context.MODE_PRIVATE);
	
	int score = sp.getInt("hScore", 0);
	int cpoint = sp.getInt("cpoint", 0);
	this.hiScore=score;
	this.checkpoint=cpoint;
	
	}

}
