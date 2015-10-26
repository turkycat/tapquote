package turkycat.taps.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import turkycat.taps.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecyclerViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RecyclerViewFragment extends Fragment
{
    public final static String TAG = "RecyclerViewFragment";

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
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
        layoutManager = new GridLayoutManager( getContext(), numberOfCols );

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed( Uri uri )
    {
        if( mListener != null )
        {
            mListener.onFragmentInteraction( uri );
        }
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
        public void onFragmentInteraction( Uri uri );
    }

}
