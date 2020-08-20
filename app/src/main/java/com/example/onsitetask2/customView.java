package com.example.onsitetask2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class customView extends View {
    Fragment1  fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();
    private onCanvasTouch mCallBack;
    public interface onCanvasTouch{
        void onTouch(Path path);
    }
    public void setmCallBack(onCanvasTouch callBack){
        mCallBack = callBack;
    }

    public  Path path;
    public Paint paint;
    boolean isInit;
    public customView(Context context) {
        super(context);
    }

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        path = new Path();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(!isInit){
            init();
        }
        canvas.drawColor(Color.YELLOW);

        canvas.drawPath(path,paint);
        invalidate();

    }

    public void setPath(Path path){
        this.path = path;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
         super.onTouchEvent(event);

         float x = event.getX();
         float y = event.getY();
         switch (event.getAction()){
             case MotionEvent.ACTION_DOWN:
                 path.moveTo(x,y);
                 mCallBack.onTouch(path);

                 return true;
             case MotionEvent.ACTION_MOVE:
                 mCallBack.onTouch(path);
                 path.lineTo(x,y);

                 break;
             case MotionEvent.ACTION_UP:


                 return false;
         }
         postInvalidate();
         return true;
    }
}
