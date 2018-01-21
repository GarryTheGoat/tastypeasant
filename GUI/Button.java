package com.tastypeasant.root.tanks.GUI;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;

import com.tastypeasant.root.tanks.GUI.GUIElement;

import java.util.concurrent.Callable;

/**
 * Created by root on 1/21/18.
 */

public class Button extends GUIElement {

    private Bitmap normal,hover,pressed;
    public MediaPlayer mp;

    public Button(int x, int y, Bitmap normal,Bitmap hover,Bitmap pressed){
        super(x-normal.getWidth()/2,y-normal.getHeight()/2,normal.getWidth(),normal.getHeight());
        this.normal=normal;
        this.hover=hover;
        this.pressed=pressed;

        this.setAction(new Callable() {
            @Override
            public Object call() throws Exception {
                setState(BUTTON_STATE.pressed);
                mp.start();
                return null;
            }
        });
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setTranslate(position().x,position().y);

        if(getState() == BUTTON_STATE.normal){
            canvas.drawBitmap(this.normal,matrix,paint);
        }else if(getState() == BUTTON_STATE.hover){
            canvas.drawBitmap(this.hover,matrix,paint);
        }else if(getState() == BUTTON_STATE.pressed){
            canvas.drawBitmap(this.pressed,matrix,paint);
        }
    }

    @Override
    public void onTouch(Point touch){
        super.onTouch(touch);
    }
    @Override
    public void onRelease(){
        super.onRelease();
        if(getState()==BUTTON_STATE.pressed) {
            setState(BUTTON_STATE.normal);
        }
    }
}
