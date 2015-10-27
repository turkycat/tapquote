package turkycat.taps.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import turkycat.taps.R;
import turkycat.taps.taps.Tap;

/**
 * Created by turkycat on 10/25/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private static final String TAG = "RecyclerViewAdapter";
    private List<Tap> taps;

    public RecyclerViewAdapter( List<Tap> taps )
    {
        super();
        this.taps = taps;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType )
    {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.recycler_card, parent, false );
        view.setLayoutParams( new RecyclerView.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ) );
        return new TapViewHolder( view );
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position )
    {
        if( position < 0 || position >= taps.size() )
        {
            Log.d( TAG, "onBindViewHolder attempted to bind a positon out of range" );
            return;
        }
        TapViewHolder tvh = (TapViewHolder) holder;

        Tap tap = taps.get( position );
        tvh.getImageView().setImageResource( R.drawable.td4w );
        tvh.getTitleView().setText( tap.getName() );
        tvh.getDescView().setText( tap.getDescription() );
    }

    @Override
    public int getItemCount()
    {
        return taps.size();
    }



    public static class TapViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView imageView;
        private final TextView titleTextView;
        private final TextView descTextView;

        public TapViewHolder( View view )
        {
            super( view );
            imageView = (ImageView) view.findViewById( R.id.tap_imageview );
            titleTextView = (TextView) view.findViewById( R.id.tap_name );
            descTextView = (TextView) view.findViewById( R.id.tap_desc );
        }


        public ImageView getImageView()
        {
            return imageView;
        }

        public TextView getTitleView()
        {
            return titleTextView;
        }

        public TextView getDescView()
        {
            return descTextView;
        }
    }
}