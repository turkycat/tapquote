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
    private String drawableId;
    private String thumbnailId;

    public Tap( String name, String description, String drawableId, String thumbnailId )
    {
        this.name = name;
        this.desc = description;
        this.drawableId = drawableId;
        this.thumbnailId = thumbnailId;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return desc;
    }

    public String getDrawableId()
    {
        return drawableId;
    }

    public String getThumbnailId()
    {
        return thumbnailId;
    }
}
