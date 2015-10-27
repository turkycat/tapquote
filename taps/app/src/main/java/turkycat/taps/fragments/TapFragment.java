package turkycat.taps.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import turkycat.taps.ApplicationResources;
import turkycat.taps.R;
import turkycat.taps.taps.Tap;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TapFragment extends Fragment
{
    public static final String TAG = "TagFragment";

    private static final String ARG_TAPNO = "tapno";

    private Tap tap;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TapFragment newInstance( int tapno )
    {
        TapFragment fragment = new TapFragment();
        Bundle args = new Bundle();
        args.putInt( ARG_TAPNO, tapno );
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
            tap = ApplicationResources.getInstance().getTap( getArguments().getInt( ARG_TAPNO ) );
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState )
    {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_tap, container, false );
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
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
