package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        float viweWidth = getWidth();
        float viewHeigh = getHeight();
        float minLength = viewHeigh > viweWidth ? viweWidth : viewHeigh;
        float xl, xr, yt, yb, vh, vw;
        vh = viewHeigh / 5;
        vw = viweWidth / 5;
        xl = viweWidth / 2 - minLength / 5;
        xr = viweWidth / 2 + minLength / 5;
        yt = viewHeigh / 2 - minLength / 5;
        yb = viewHeigh / 2 + minLength / 5;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        RectF rectF=new RectF(xl-minLength/4,yt-minLength/4,xr-minLength/4,yb-minLength/4);
        canvas.drawArc(rectF,-90,90,false,paint);

        RectF rectF1=new RectF(xl+minLength/4,yt-minLength/4,xr+minLength/4,yb-minLength/4);
        canvas.drawArc(rectF1,-90,90,true,paint);

        paint.setStyle(Paint.Style.STROKE);
        RectF rectF2=new RectF(xl-minLength/4,yt+minLength/4,xr-minLength/4,yb+minLength/4);
        canvas.drawArc(rectF2,-90,90,false,paint);

        RectF rectF3=new RectF(xl+minLength/4,yt+minLength/4,xr+minLength/4,yb+minLength/4);
        canvas.drawArc(rectF3,-90,90,true,paint);

    }
}














