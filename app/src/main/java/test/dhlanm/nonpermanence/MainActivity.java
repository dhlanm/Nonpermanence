package test.dhlanm.nonpermanence;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity{

    private ImageButton currPaint, brush;
    private DrawView drawView;
    private float smallBrush, mediumBrush, largeBrush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        brush = (ImageButton)findViewById(R.id.brush);
        brush.setOnClickListener(new BrushSizeDialogListener());
        drawView = (DrawView) findViewById(R.id.drawing);

        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
    }

    public View.OnClickListener getBrushSizeListener(final float size, final Dialog brushDialog){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawView.setBrushSize(size);
                //drawView.setLastBrushSize(size);
                brushDialog.dismiss();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // lol for some reason doing a listener differently from the listeners for selecting a brush size
    private class BrushSizeDialogListener implements View.OnClickListener{
        public void onClick(View view){
            if(view.getId()==R.id.brush){
                final Dialog brushDialog = new Dialog(getParent());
                brushDialog.setTitle("Brush size:");
                brushDialog.setContentView(R.layout.brush_chooser);

                ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
                smallBtn.setOnClickListener(getBrushSizeListener(smallBrush, brushDialog));

                ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
                mediumBtn.setOnClickListener(getBrushSizeListener(mediumBrush, brushDialog));

                ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
                largeBtn.setOnClickListener(getBrushSizeListener(largeBrush, brushDialog));

                brushDialog.show();
            }
        }
    }

}
