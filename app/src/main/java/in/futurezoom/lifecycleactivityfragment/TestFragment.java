package in.futurezoom.lifecycleactivityfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by rubinovk on 11/2/16.
 *
 * For state debugging.
 *
 * Children must override onCreateView()
 */
abstract public class TestFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    /* For debugging purposes */

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, this.getTag() + " STATE onCreate");
    }


    @Override
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Log.d(TAG, this.getTag() + " STATE onViewStateRestored");
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs,
            Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(TAG, this.getTag() + " STATE onInflate");
    }


    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d(TAG, this.getTag() + " STATE onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, this.getTag() + " STATE onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, this.getTag() + " STATE onPause; isRemoving == "+ this.isRemoving());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, this.getTag() + " STATE onStop; isRemoving == "+ this.isRemoving());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this.getTag() + " STATE onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, this.getTag() + " STATE onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, this.getTag() + " STATE onDetach");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, this.getTag() + " STATE onAttach(Context)");
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        Log.d(TAG, this.getTag() + " STATE onAttach(Activity) pre API23");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, this.getTag() + " STATE onResume");
    }

}

