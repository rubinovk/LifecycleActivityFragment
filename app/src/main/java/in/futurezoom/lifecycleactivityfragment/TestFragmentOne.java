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
public class TestFragmentOne extends TestFragment {

    private static final String TAG = TestFragmentOne.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG, this.getTag() + " STATE onCreateView");
        View view = inflater.inflate(R.layout.fragment_text,
                container, false);
        return view;
    }
}

