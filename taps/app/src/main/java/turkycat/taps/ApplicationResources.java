package turkycat.taps;

import android.content.Context;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;

import java.io.IOException;
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

    private MediaPlayer player;
    private HashMap<String, Tap> taps;
    private HashMap<String, Drawable> drawables;
    private HashMap<String, AssetFileDescriptor> audioDescriptors;
    
    public static ApplicationResources getInstance()
    {
        return instance;
    }

    public List<Tap> getTaps()
    {
        return new LinkedList<Tap>( taps.values() );
    }

    public Tap getTap( String id )
    {
        return taps.get( id );
    }

    public Drawable getDrawable( String id )
    {
        return drawables.get( id );
    }

    public void initialize( Context context )
    {
        initDrawables( context );
        taps.put( "td4w", new Tap( "td4w", "#TD4W", "Turn down for...?", "td4w", "td4w_s" ) );
        try
        {
            audioDescriptors.put( "td4w", context.getAssets().openFd( "td4w.mp3" ) );
        }
        catch( IOException e )
        {
            // do nothing
        }
    }

    public void playAudio( String id )
    {
        //we release the current player
        if( player != null )
        {
            player.stop();
            player.release();
        }

        //creating a new player seems to guarantee that each event creates a new play.
        try
        {
            player = new MediaPlayer();
            player.setDataSource( audioDescriptors.get( id ).getFileDescriptor() );
            player.prepare();
        }
        catch( IllegalStateException e )
        {
            // nothing to do
            e.printStackTrace();
        }
        catch( IOException e )
        {
            //nothing to do
            e.printStackTrace();
        }

        player.start();
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
        taps = new HashMap<>();
        drawables = new HashMap<>();
        audioDescriptors = new HashMap<>();
    }
}
