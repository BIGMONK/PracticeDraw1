package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import static android.R.attr.path;
import static android.R.attr.x;

public class Practice11PieChartView extends View {
    private static final String TAG = "Practice11PieChartView";

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float viweWidth = getWidth();
        float viewHeigh = getHeight();
        float minLength = viewHeigh > viweWidth ? viweWidth : viewHeigh;
        float xl, xr, yt, yb, vh, vw;

        xl = viweWidth / 2 - minLength / 3;
        xr = viweWidth / 2 + minLength / 3;
        yt = viewHeigh / 2 - minLength / 3;
        yb = viewHeigh / 2 + minLength / 3;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


        ArrayList<DataBean> list = new ArrayList<>();
        list.add(new DataBean("Jack", 45));
        list.add(new DataBean("Kar", 45));
        list.add(new DataBean("Lion", 270));

        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getPercent();
        }
        int[] colors = new int[]{Color.RED, Color.GREEN, Color.BLUE};

        Path pa = new Path();

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.WHITE);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(2);

        float startAngle = 0;
        for (int i = 0; i < list.size(); i++) {
            paint.setColor(colors[i % list.size()]);
            int off = 0;
            if (i == 0) {
                off = 10;
            }

            float s = startAngle + 1;

            float sw = list.get(i).getPercent() / total * 360 - 1;

            float angle =(sw / 2 + s ) ;

            float an = (float) (angle / 180 * Math.PI);



            float xf = (float) ((minLength / 3  ) * Math.sin(an));
            float yf = (float) ((minLength / 3 ) * Math.cos(an));

            Log.d(TAG, "onDraw: xf=" + xf + " yf=" + yf
                    + " i=" + i
                    + " s=" + s
                    + " sw=" + sw
                    + " angle=" + angle
            );

            pa.moveTo(viweWidth / 2+off * (float) Math.cos(an)+xf,
                    viewHeigh / 2+off * (float) Math.sin(an)+yf);

            pa.rLineTo(xf*0.2f,yf*0.2f);

            if (xf > 0) {
                pa.rLineTo(50, 0);
            } else {
                pa.rLineTo(-50, 0);
            }

            canvas.drawPath(pa, linePaint);


            RectF rexf = new RectF(xl + off * (float) Math.cos(an), yt + off * (float) Math.sin(an),
                    xr + off * (float) Math.cos(an), yb + off * (float) Math.sin(an));

            canvas.drawArc(rexf, s, sw, true, paint);

            startAngle += list.get(i).getPercent() / total * 360;


        }


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












