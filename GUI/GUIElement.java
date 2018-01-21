package com.tastypeasant.root.tanks.GUI;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

import java.util.concurrent.Callable;

/**
 * Created by root on 1/20/18.
 */

public class GUIElement {
    public void draw(Canvas canvas){};

    private Rect rect;
    private Callable action;

    public enum BUTTON_STATE {
        normal,hover,pressed
    }
    private BUTTON_STATE state = BUTTON_STATE.normal;

    public GUIElement(int x, int y, int width, int height){
        this.rect = new Rect(x,y,x+width,y+height);
        this.action = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Hey, look at that! This GUIElement has a function!");
                return null;
            }
        };
    }

    public BUTTON_STATE getState(){
        return this.state;
    }
    public void setState(BUTTON_STATE state){
        this.state=state;
    }

    public Point position(){
        return new Point(this.rect.left,this.rect.top);
    }

    public void setAction(Callable action){
        this.action = action;
    }

    public void onTouch(Point touch){
        System.out.println(rect.left+" : "+rect.right+" | "+touch.x+" : "+touch.y);
        if (this.rect.contains(touch.x,touch.y)){
            if(this.action!=null){
                try {
                    this.action.call();
                } catch (Exception e) {e.printStackTrace();}
            }else{
                System.out.println("This GUIElement has no function O_o!");
            }
        }

    }

    public void onRelease(){

    }



}
