package ru.bk.klim9.httprequest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONObject;

/**
 * Created by Иван on 30.11.2015.
 */
public class Fragment2 extends Fragment implements View.OnClickListener{

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,
                container, false);
        button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                StartFragment3Listener listener = (StartFragment3Listener) getActivity();
                listener.startFragment3();
                break;
        }
    }

    public interface StartFragment3Listener {
        void startFragment3();
    }
}