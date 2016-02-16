package in.futurezoom.lifecycleactivityfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rubinovk on 11/2/16.
 */
public class TestFragmentTwo extends TestFragment {

    private static final String TAG = TestFragmentTwo.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG, this.getTag() + " STATE onCreateView");
        View view = inflater.inflate(R.layout.fragment_another,
                container, false);
        return view;
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Log.d(TAG, this.getTag() + " STATE setRetainInstance(true)");
    }

}
