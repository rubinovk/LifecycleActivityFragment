package in.futurezoom.lifecycleactivityfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


/**
 * Created by rubinovk on 11/2/16.
 */
public class FragmentActivity extends Activity {

    private static final String TAG = FragmentActivity.class.getSimpleName();

    private String tag1, tag2, tag3;
    private Fragment f1, f2, f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "STATE onCreate");

        setContentView(R.layout.activity_test_fragment);

        if (true) {
            // check if fragments exist already
        }


        f1 = new TestFragmentOne();
        tag1 = String.valueOf(System.currentTimeMillis());

        getFragmentManager().beginTransaction().add(R.id.listcontainer, f1, tag1)
                .addToBackStack("add one").commit();
        Log.d(TAG, "STATE  add fragment + pushOnBackStack");


        f2 = new TestFragmentTwo();
        tag2 = String.valueOf(System.currentTimeMillis());
        Log.d(TAG, "STATE  add fragment");

        getFragmentManager().beginTransaction().add(R.id.listcontainer, f2, tag2).commit();

    }


    /* For debugging purposes */

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "STATE onStop");
    }

    // only in support library
    //    @Override
    //    protected void onResumeFragments() {
    //        super.onResumeFragments();
    //        Log.d(TAG, "STATE onResumeFragments");
    //

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "STATE onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "STATE onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "STATE onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "STATE onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Log.d(TAG, "STATE onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.d(TAG, "STATE onSaveInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "STATE onResume");
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "STATE onPostResume");
        findViewById(R.id.bn_replace).
                setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFragmentManager().beginTransaction()
                                .replace(R.id.listcontainer, new TestFragmentOne(),
                                        String.valueOf(System.currentTimeMillis()))
                                .addToBackStack("replace three").commit();
                        Log.d(TAG, "STATE replace + pushOnBackStack");
                    }
                });

        ToggleButton hide = (ToggleButton) findViewById(R.id.bn_hide);
        hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getFragmentManager().beginTransaction().hide(f2).addToBackStack("hide" + " " +
                            "two").commit();
                    Log.d(TAG, "STATE hide + pushOnBackStack");
                } else {
                    getFragmentManager().beginTransaction().show(f2).addToBackStack("show" + " two")
                            .commit();
                    Log.d(TAG, "STATE show + pushOnBackStack");
                }
            }
        });


        ToggleButton detach = (ToggleButton) findViewById(R.id.bn_detach);
        detach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getFragmentManager().beginTransaction().detach(f2)
                            .addToBackStack("detach" + " two").commit();
                    Log.d(TAG, "STATE detached + pushOnBackStack");
                } else {
                    getFragmentManager().beginTransaction().attach(f2).addToBackStack("attach" +
                            " " +
                            "two").commit();
                    Log.d(TAG, "STATE attached + pushOnBackStack");
                }
            }
        });


        ToggleButton remove = (ToggleButton) findViewById(R.id.bn_remove);
        remove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getFragmentManager().beginTransaction().remove(f2)
                            .addToBackStack("remove" + " two").commit();
                    Log.d(TAG, "STATE remove + pushOnBackStack");
                } else {
                    getFragmentManager().beginTransaction().add(R.id.listcontainer, f2)
                            .addToBackStack("add three").commit();
                    Log.d(TAG, "STATE  add + pushOnBackStack");
                }
            }
        });


    }
}

