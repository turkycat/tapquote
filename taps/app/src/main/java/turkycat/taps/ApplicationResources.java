package turkycat.taps;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

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
    private List<Tap> tapList;

    public static ApplicationResources getInstance()
    {
        return instance;
    }

    public List<Tap> getTaps()
    {
        return tapList;
    }

    public void initialize( Context context )
    {
        Drawable drawable = ContextCompat.getDrawable( context, R.drawable.td4w );
        tapList.add( new Tap( "#TD4W", "Turn down for...?", drawable, createThumbnail( drawable, context ) ) );
    }

    private Drawable createThumbnail( Drawable drawable, Context context )
    {
        Bitmap b = ( (BitmapDrawable) drawable ).getBitmap();
        int h = b.getHeight();
        Bitmap bitmapResized = Bitmap.createScaledBitmap( b, 250, 250, false );
        return new BitmapDrawable( context.getResources(), bitmapResized );
    }

    //private singleton constructor
    private ApplicationResources()
    {
        tapList = new LinkedList<>();
    }
}
