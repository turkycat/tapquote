package turkycat.taps.taps;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by turkycat on 10/25/2015.
 */
public class Tap
{
    private String id;
    private String title;
    private String desc;
    private String drawableId;
    private String thumbnailId;

    public Tap( String id, String title, String description, String drawableId, String thumbnailId )
    {
        this.id = id;
        this.title = title;
        this.desc = description;
        this.drawableId = drawableId;
        this.thumbnailId = thumbnailId;
    }

    public String getId()
    {
        return id;
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

    public String getTitle()
    {
        return title;
    }
}
