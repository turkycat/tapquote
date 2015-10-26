package turkycat.taps;

import android.content.Context;
import android.content.res.AssetManager;

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
        AssetManager assets = context.getAssets();

        tapList.add( new Tap( "#TD4W", ContextCompat.getDrawable( context, R.drawable.td4w ) ) );
    }

    //private singleton constructor
    private ApplicationResources()
    {
        tapList = new LinkedList<>();
    }
}
