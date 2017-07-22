package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        float viweWidth = getWidth();
        float viewHeigh = getHeight();
        float minLength = viewHeigh > viweWidth ? viweWidth : viewHeigh;
        float xl, xr, yt, yb, vh, vw;
        vh = viewHeigh / 5;
        vw = viweWidth / 5;
        xl = viweWidth / 2 - vw / 2;
        xr = viweWidth / 2 + vw / 2;
        yt = viewHeigh / 2 - vh / 2;
        yb = viewHeigh / 2 + vh / 2;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawRoundRect(xl, yt-vh/2, xr, yb-vh/2,10,10, paint);
    }
}
