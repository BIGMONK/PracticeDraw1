package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

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

        Path path = new Path();
        paint.setColor(Color.RED);
        path.addArc(xl - minLength / 5, yt, xr - minLength / 5, yb,-225,225);
        path.arcTo(xl + minLength / 5, yt, xr + minLength / 5, yb,-180,225,false);
        path.lineTo(viweWidth/2,viewHeigh/2+minLength/2.5f);

        canvas.drawPath(path,paint);
    }
}
