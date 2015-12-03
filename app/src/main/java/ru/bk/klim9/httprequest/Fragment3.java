package ru.bk.klim9.httprequest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by Иван on 02.12.2015.
 */
public class Fragment3 extends Fragment {

    static final String LOG_TAG = "myLog";
    private static final String QUERY_URL = "https://mgmt.rivs.com/service/live/meeting/use_code/?sKey=oqmNkdKiTSPSz84F&sCode=596748069";

    JSONObject mJsonObject;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,
                container, false);

        textView =(TextView) view.findViewById(R.id.textView6);
        textView.setText(mJsonObject.toString());

        return view;
    }

    public void setmJsonObject(JSONObject mJsonObject) {
        this.mJsonObject = mJsonObject;
    }
}