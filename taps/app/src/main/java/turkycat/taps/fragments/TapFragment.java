package turkycat.taps.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import turkycat.taps.ApplicationResources;
import turkycat.taps.R;
import turkycat.taps.taps.Tap;


public class TapFragment extends Fragment
{
    public static final String TAG = "TagFragment";

    private static final String ARG_TAPID = "tap";

    private Tap tap;
    private Animation push;

    public static TapFragment newInstance( String id )
    {
        TapFragment fragment = new TapFragment();
        Bundle args = new Bundle();
        args.putString( ARG_TAPID, id );
        fragment.setArguments( args );
        return fragment;
    }

    public TapFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        if( getArguments() != null )
        {
            tap = ApplicationResources.getInstance().getTap( getArguments().getString( ARG_TAPID ) );
        }
        push = AnimationUtils.loadAnimation( getContext(), R.anim.push );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState )
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_tap, container, false );

        ImageView iv = (ImageView) view.findViewById( R.id.tap_imageview );
        iv.setImageDrawable( ApplicationResources.getInstance().getDrawable( tap.getDrawableId() ) );
        iv.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                v.startAnimation( push );
                ApplicationResources.getInstance().playAudio( tap.getId() );
            }
        } );

        return view;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}
