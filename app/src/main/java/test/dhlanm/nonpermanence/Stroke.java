package test.dhlanm.nonpermanence;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    // TODO: test
    public Map<String, String> getFBStroke(){
        Gson gson = new Gson();
        Map<String, String> mp = new HashMap<>();
        mp.put("path", gson.toJson(this.path));
        mp.put("paint", gson.toJson(this.paint));
        return mp;
    }

    // TODO: test
    public static Stroke fromFBStroke(Map<String, String> fbstroke){
        Gson gson = new Gson();
        Path    tpa = gson.fromJson(fbstroke.get("path"),   Path.class);
        Paint   tpt = gson.fromJson(fbstroke.get("paint"),  Paint.class);
        return new Stroke(tpa, tpt);
    }

}
