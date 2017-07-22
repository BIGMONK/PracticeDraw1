package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

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

        float vvh = minLength * 0.8f;
        float vvw = vvh;

        float vvxl = viweWidth / 2 - vvw / 2;
        float vvxr = viweWidth / 2 + vvw / 2;
        float vvyt = viewHeigh / 2 - vvh / 2;
        float vvyb = viewHeigh / 2 + vvh / 2;
        float vvybb = viewHeigh / 2 + vvh / 2 - 50;

        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(vvxl, vvyt);
        path.lineTo(vvxl, vvybb);
        path.rLineTo(vvw, 0);
        canvas.drawPath(path, paint);

        ArrayList<DataBean> list = new ArrayList<>();
        list.add(new DataBean("Jack", 50));
        list.add(new DataBean("Kar", 70));
        list.add(new DataBean("Lion", 10));

        float yuanzhugao = vvybb - vvyt;

        float yuanzhukuan = (vvw - 2 * 10 - (list.size() - 1) * 10) / list.size();



        for (int i = 0; i < list.size(); i++) {
            float x = vvxl + 10 + yuanzhukuan / 2 + i * (10 + yuanzhukuan);
            paint.setStyle(Paint.Style.STROKE);
            Path pa = new Path();
            pa.moveTo(x, vvybb);
            pa.rLineTo(0, -list.get(i).getPercent() * yuanzhugao / 100);
            paint.setStrokeWidth(yuanzhukuan);
            paint.setColor(Color.GREEN);
            canvas.drawPath(pa, paint);


            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(2);
            paint.setTextSize(30);
            paint.setStyle(Paint.Style.FILL);
            Rect rec = getTextRect(paint, list.get(i).getName());
            canvas.drawText(list.get(i).getName(), x - rec.width() / 2, vvybb + rec.height(), paint);

            Rect rec2 = getTextRect(paint, list.get(i).getPercent() + "");
            canvas.drawText(list.get(i).getPercent() + "", x - rec2.width() / 2, vvybb-list.get(i).getPercent() * yuanzhugao / 100, paint);


        }
    }

    public Rect getTextRect(Paint mPaint, String text) {
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    private class DataBean {
        String name;
        float percent;

        public DataBean(String name, float percent) {
            this.name = name;
            this.percent = percent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }
    }
}
