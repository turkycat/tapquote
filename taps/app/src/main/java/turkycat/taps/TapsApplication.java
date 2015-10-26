package turkycat.taps;

import android.app.Application;

/**
 * Created by turkycat on 10/25/2015.
 */
public class TapsApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        //init sets up anything that the application might need
        ApplicationResources.getInstance().initialize( getApplicationContext() );
    }
}
