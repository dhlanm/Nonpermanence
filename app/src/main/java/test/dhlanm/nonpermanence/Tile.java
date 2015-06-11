package test.dhlanm.nonpermanence;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 6/11/2015.
 */
public class Tile {
    private List<Stroke> strokes;
    private Point pos;

    public Tile(Point pos, List<Stroke> strokes){
        this.strokes = strokes;
        this.pos = pos;
    }

    public List<Stroke> getStrokes() {
        return strokes;
    }

    public void setStrokes(List<Stroke> strokes) {
        this.strokes = strokes;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public List<Object> getFBStrokesObject(){
        List<Object> lst = new ArrayList<>();
        for(int i = 0; i < strokes.size(); i++){
            lst.add(strokes.get(i).getFBStroke());
        }
        return lst;
    }

    public void testLogFBO(){
        System.out.println("LOGGING FBO LOLOLOLOLOL\n");
        System.out.println(this.getFBStrokesObject());
        System.out.println("DEBUGGING IS FUN JK");
    }
}
