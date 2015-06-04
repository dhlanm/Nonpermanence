package test.dhlanm.nonpermanence;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by dhlanm on 6/3/2015.
 */
public class DrawView extends View{
    private Paint currentPaint = new Paint();
    private Path currentPath = new Path();

    private ArrayList<Stroke> strokes = new ArrayList<Stroke>();

    private float brushSize;//, lastBrushSize;

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        currentPaint.setAntiAlias(true);
        //currentPaint.setStrokeWidth(5f);
        currentPaint.setColor(Color.BLACK);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);

        setBrushSize(20);
    }

    public ArrayList<Stroke> getStrokes(){
        return strokes;
    }

    public void setBrushSize(float newSize){
        // this function's adjustment makes the brush smaller than if setStrokeWidth were called with the same param
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        brushSize = pixelAmount;
        currentPaint.setStrokeWidth(brushSize);
    }
    /*
    public void setLastBrushSize(float lastSize){
        lastBrushSize=lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }
    */
    @Override
    protected void onDraw(Canvas canvas) {
        //System.out.println("drawn");
        //System.out.println("brushSize is " + brushSize);
        for(int i = 0; i < strokes.size(); i++){
            canvas.drawPath(strokes.get(i).getPath(), strokes.get(i).getPaint());
        }
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Set a new starting point
                currentPath.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                // Connect the points
                currentPath.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // End stroke
                strokes.add(new Stroke(currentPath, new Paint(currentPaint))); // store stroke
                currentPath = new Path();
            default:

                return false;
        }

        invalidate();
        return true;
    }


}
