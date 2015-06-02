package test.dhlanm.nonpermanence;

import android.graphics.Color;
import android.graphics.Point;

/**
 * Created by Ben on 6/2/2015.
 */
public class Stroke {
    boolean black; // true = black, false = white
    float size; // this could be an int probably?

    public Stroke(boolean black, float s){
        this.black = black;
        this.size = s;
    }

}
