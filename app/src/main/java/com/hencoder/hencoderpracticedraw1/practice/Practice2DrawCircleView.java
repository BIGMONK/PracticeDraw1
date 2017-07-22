package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        float viweWidth = getWidth();
        float viewHeigh = getHeight();
        float minLength = viewHeigh > viweWidth ? viweWidth : viewHeigh;

        float circleRadius = minLength / 5;

        float x1,y1,x2,y2,x3,y3,x4,y4;

        x1=x3=viweWidth/2-circleRadius*1.5f;
        x2=x4=viweWidth/2+circleRadius*1.5f;
        y1=y2=viewHeigh/2-circleRadius*1.2f;
        y3=y4=viewHeigh/2+circleRadius*1.2f;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x1,y1,circleRadius,paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(x1,y3,circleRadius,paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawCircle(x2,y2,circleRadius,paint);

        paint.setStrokeWidth(20);
        canvas.drawCircle(x4,y4,circleRadius,paint);





    }
}
