package com.tastypeasant.root.tanks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tastypeasant.root.tanks.GUI.Button;
import com.tastypeasant.root.tanks.GUI.GUIElement;

/**
 * Created by root on 1/20/18.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    public Player player;
    public Button button;
    public ImageManager images;
    public int width,height;
    public MediaPlayer mp;

    public enum GAMESTATE {
            MENU, GAME
    }
    private GAMESTATE state = GAMESTATE.MENU;

    public GamePanel(Context context){
        super(context);
        width=context.getResources().getDisplayMetrics().widthPixels;
        height=context.getResources().getDisplayMetrics().heightPixels;
        mp = MediaPlayer.create(context, R.raw.button);
        images = new ImageManager(context);
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        button = new Button(context.getResources().getDisplayMetrics().widthPixels/2,context.getResources().getDisplayMetrics().heightPixels/2, images.play_normal, images.play_hover, images.play_pressed);
        button.mp = mp;
        setFocusable(true);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
    }

    public void surfaceCreated(SurfaceHolder holder){
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(true){
            try {
                thread.setRunning(false);
                thread.join();
            }catch (Exception e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.println("DOWN");
                button.onTouch(new Point((int)e.getX(),(int)e.getY()));
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("UP");
                button.onRelease();
                break;
        }
        return true;
    }

    public void update(){

    }

    public void draw(Canvas canvas){
        super.draw(canvas);

        if(this.state==GAMESTATE.MENU){
            button.draw(canvas);
        }else if(this.state==GAMESTATE.GAME){
            canvas.drawColor(Color.BLUE);
            Matrix matrix = new Matrix();
            matrix.setTranslate(0,height-images.hills1_green.getHeight());
            canvas.drawBitmap(images.hills1_green,matrix, new Paint());
        }

    }

}
