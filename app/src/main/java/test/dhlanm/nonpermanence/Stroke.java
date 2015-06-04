package test.dhlanm.nonpermanence;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by Ben on 6/2/2015.
 */
public class Stroke {

    private Path path;
    private Paint paint;

    public Stroke(Path pat, Paint pai){
        this.path = pat;
        this.paint = pai;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    

}
