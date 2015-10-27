package turkycat.taps.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import turkycat.taps.ApplicationResources;
import turkycat.taps.R;
import turkycat.taps.adapters.RecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecyclerViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RecyclerViewFragment extends Fragment implements RecyclerView.OnItemTouchListener
{
    public final static String TAG = "RecyclerViewFragment";

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter viewAdapter;
    private final int numberOfCols = 2;

    public RecyclerViewFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState )
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_recycler_view, container, false );
        recyclerView = (RecyclerView) view.findViewById( R.id.recyclerView );

        //set the layout manager to a grid manager
        //layoutManager = new GridLayoutManager( getContext(), numberOfCols );
        layoutManager = new LinearLayoutManager( getContext() );
        recyclerView.setLayoutManager( layoutManager );

        viewAdapter = new RecyclerViewAdapter( ApplicationResources.getInstance().getTaps() );
        recyclerView.setAdapter( viewAdapter );

        recyclerView.addOnItemTouchListener( this );

        return view;
    }

    @Override
    public void onAttach( Activity activity )
    {
        super.onAttach( activity );
        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        } catch( ClassCastException e )
        {
            throw new ClassCastException( activity.toString()
                    + " must implement OnFragmentInteractionListener" );
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
        recyclerView = null;
        layoutManager = null;
        viewAdapter = null;
    }

    @Override
    public boolean onInterceptTouchEvent( RecyclerView rv, MotionEvent e )
    {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());

        if(childView != null && mListener != null)
        {
            mListener.onFragmentInteraction( childView, rv.getChildAdapterPosition( childView ) );
        }

        return false;
    }

    @Override
    public void onTouchEvent( RecyclerView rv, MotionEvent e )
    {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent( boolean disallowIntercept )
    {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction( View view, int pos );
    }

}
