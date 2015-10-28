package turkycat.taps;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import turkycat.taps.taps.Tap;

/**
 * Created by turkycat on 10/25/2015.
 */
public class ApplicationResources
{
    //singleton class
    private static ApplicationResources instance = new ApplicationResources();
    
    private List<Tap> taps;
    private HashMap<String, Drawable> drawables;
    
    public static ApplicationResources getInstance()
    {
        return instance;
    }

    public List<Tap> getTaps()
    {
        return taps;
    }

    public Tap getTap( int pos )
    {
        if( pos < 0 || pos >= taps.size() ) return null;
        return taps.get( pos );
    }

    public Drawable getDrawable( String id )
    {
        return drawables.get( id );
    }

    public void initialize( Context context )
    {
        initDrawables( context );
        taps.add( new Tap( "#TD4W", "Turn down for...?", "td4w", "td4w_s" ) );
    }

    private void initDrawables( Context context )
    {
        drawables.put( "td4w", ContextCompat.getDrawable( context, R.drawable.td4w ) );
        drawables.put( "td4w_s", ContextCompat.getDrawable( context, R.drawable.td4w_s ) );
    }

    /*private Drawable createThumbnail( Drawable drawable, Context context )
    {
        Bitmap b = ( (BitmapDrawable) drawable ).getBitmap();
        int h = b.getHeight();
        Bitmap bitmapResized = Bitmap.createScaledBitmap( b, 250, 250, false );
        return new BitmapDrawable( context.getResources(), bitmapResized );
    }*/

    //private singleton constructor
    private ApplicationResources()
    {
        taps = new LinkedList<>();
        drawables = new HashMap<>();
    }
}
