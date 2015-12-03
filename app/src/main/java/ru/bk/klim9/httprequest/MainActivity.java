package ru.bk.klim9.httprequest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Fragment1.StartFragment2Listener,
        Fragment2.StartFragment3Listener{

    final String LOG_TAG = "myLog";

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentTransaction fragmentTransaction;

    JSONObject mJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.conteiner, fragment1);
        fragmentTransaction.commit();
    }

    // Передаю значение jsonObject в MainActivity, что бы его можно было дальше использовать.
    // И показываю фрагмент2
    @Override
    public void startFragment2(JSONObject jsonObject) {
        mJsonObject = jsonObject;
        Log.d(LOG_TAG, "MainActivity mJsonObject = " + mJsonObject.toString());
        fragment2 = new Fragment2();
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, fragment2);
        fragmentTransaction.commit();
    }

    @Override
    public void startFragment3() {
        fragment3 = new Fragment3();
        // передаю чкерез Сетер как наиболее общий случай
        // И ещё момент, что я передаваемый mJsonObject хочу использовать уже в onCreateView
        fragment3.setmJsonObject(mJsonObject);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, fragment3);
        fragmentTransaction.commit();
    }
}
