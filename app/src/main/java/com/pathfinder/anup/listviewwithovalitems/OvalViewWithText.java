package com.pathfinder.anup.listviewwithovalitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Anup on 7/27/2017.
 */

public class OvalViewWithText extends View /*implements View.OnClickListener*/{

    private OnClickListener onClickListenerPara;
    private String timeStamp;

    //need to shift below 4 line code to function init;
    float leftStartingPoint = (getWidth() - ((getWidth()/2) + getWidth()/4));
    float rightEndPoint = ((getWidth()/2) + (getWidth()/4));
    float topStartingPoint = 10;
    float bottomEndPoint = 100;

    // CONSTRUCTOR
    public OvalViewWithText(Context context, String timeStamp/*, OnClickListener onClickListener*/) {
        super(context);
        setFocusable(true);
        //this.onClickListenerPara = onClickListener;
        this.timeStamp = timeStamp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //Need to calculate the height and width properly
        int desiredWidth = (int) (getWidth() - (leftStartingPoint + rightEndPoint));
        int desiredHeight = (int)(bottomEndPoint = topStartingPoint);
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        int savedCount = canvas.save();
        canvas.drawColor(Color.WHITE);
        drawOval(canvas);
        drawText(canvas);
        canvas.restoreToCount(savedCount);

    }

    private void drawOval(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
        //RectF(LeftStartingPoint, TopStartingPoint, rightEndPoint, BottomEndPoint);

        RectF oval1 = new RectF(leftStartingPoint, topStartingPoint, rightEndPoint,bottomEndPoint);
        canvas.drawOval(oval1, paint);
    }

    private void drawText(Canvas canvas){
        Paint p1 = new Paint();
        p1.setColor(Color.BLACK);
        p1.setAntiAlias(true);
        p1.setFilterBitmap(true);
        p1.setDither(true);
        p1.setTextSize(35);
        p1.setTextAlign(Paint.Align.CENTER);
        p1.setTypeface(Typeface.MONOSPACE);

        float x = getWidth()/2;
        float y = ((bottomEndPoint + topStartingPoint)/2) + topStartingPoint;
        canvas.drawText(timeStamp, x, y, p1);

    }



}


/**
 * private final static String TEST_STRING = "ABC";
 private Paint mBackgroundPaint;
 private Paint mTextPaint;

 @TargetApi(Build.VERSION_CODES.LOLLIPOP)
 public Cube(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
 super(context, attrs, defStyleAttr, defStyleRes);
 init();
 }

 public Cube(Context context, AttributeSet attrs, int defStyleAttr) {
 super(context, attrs, defStyleAttr);
 init();
 }

 public Cube(Context context, AttributeSet attrs) {
 this(context, attrs, -1);
 }

 public Cube(Context context) {
 this(context, null, -1);
 }

 @Override
 protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
 // Just for demo purposes this should be calculated properly
 int desiredWidth = 100;
 int desiredHeight = 100;

 setMeasuredDimension(desiredWidth, desiredHeight);
 }

 @Override
 protected void onDraw(Canvas canvas) {
 super.onDraw(canvas);
 int savedCount = canvas.save();
 drawRectangle(canvas);
 drawText(canvas);
 canvas.restoreToCount(savedCount);
 }

 private void init() {
 mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
 mBackgroundPaint.setColor(Color.BLUE);
 mBackgroundPaint.setStyle(Paint.Style.FILL);

 mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
 mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
 // This need to be adjusted based on the requirements that you have
 mTextPaint.setTextSize(20.0f);

 }

 private void drawRectangle(Canvas canvas) {
 canvas.drawRect(0, 0, getWidth(), getHeight(), mBackgroundPaint);
 }

 private void drawText(Canvas canvas) {
 Rect rect = new Rect();
 // For simplicity I am using a hardcoded string
 mTextPaint.getTextBounds(TEST_STRING, 0, 1, rect);
 int w = getWidth(), h = getHeight();
 float x = (w - rect.width()) / 2, y = ((h - rect.height()) / 2) + rect.height();
 canvas.drawText(TEST_STRING, 0, 1, x, y, mTextPaint);


 }
 * */
