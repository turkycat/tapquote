package turkycat.taps.taps;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by turkycat on 10/25/2015.
 */
public class Tap
{
    private String name;
    private String desc;
    private Drawable drawable;
    private Drawable thumbnail;

    public Tap( String name, String description, Drawable drawable, Drawable thumbnail )
    {
        this.name = name;
        this.desc = description;
        this.drawable = drawable;
        this.thumbnail = thumbnail;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return desc;
    }

    public Drawable getDrawable()
    {
        return drawable;
    }

    public Drawable getThumbnail()
    {
        return thumbnail;
    }
}
