package com.tastypeasant.root.tanks;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

/**
 * Created by root on 1/20/18.
 */

public class Player extends GameObject{

    private int x,y,width,height;
    private Bitmap image;
    public Player(int x, int y, int width, int height, Bitmap image){
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.image=image;
    }

    @Override
    public void update(){

    }

    @Override
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        Matrix matrix = new Matrix();
        matrix.setTranslate(this.x-this.image.getWidth()/2,this.y-this.image.getHeight()/2);
        canvas.drawBitmap(this.image,matrix,paint);
    }

}
