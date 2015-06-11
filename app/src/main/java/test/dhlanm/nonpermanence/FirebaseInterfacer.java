package test.dhlanm.nonpermanence;

import com.firebase.client.Firebase;

import java.util.List;

/**
 * Created by Ben on 6/11/2015.
 */
public class FirebaseInterfacer {

    final static String GRID_PATH = "grid";

    Firebase rootRef;

    public FirebaseInterfacer(String rootURL){
        rootRef = new Firebase(rootURL);
    }

    private String getGridRef(int row, int col){
        return GRID_PATH + "/" + row + "/" + col;
    }

    public void saveTile(Tile t){
        Firebase gridPosRef = rootRef.child(getGridRef(t.getPos().x, t.getPos().y));
        gridPosRef.push();
    }

}
