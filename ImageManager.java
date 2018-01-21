package com.tastypeasant.root.tanks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by root on 1/21/18.
 */

public class ImageManager {

    //Button images
    public Bitmap play_normal,play_hover,play_pressed;

    //Background images
    public Bitmap hills_1,hills1_green;

    public ImageManager(Context context){
        //Button images
        play_normal = BitmapFactory.decodeResource(context.getResources(), R.drawable.play_normal);
        play_hover = BitmapFactory.decodeResource(context.getResources(), R.drawable.play_hover);
        play_pressed = BitmapFactory.decodeResource(context.getResources(), R.drawable.play_pressed);

        //Background images
        hills_1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hills1);
        hills1_green = BitmapFactory.decodeResource(context.getResources(), R.drawable.hills1_green);
    }

}
