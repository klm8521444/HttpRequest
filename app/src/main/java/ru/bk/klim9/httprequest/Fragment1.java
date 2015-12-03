package ru.bk.klim9.httprequest;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;


public class Fragment1 extends Fragment implements View.OnClickListener{

    static final String LOG_TAG = "myLog";
    private static final String QUERY_URL = "https://mgmt.rivs.com/service/live/meeting/use_code/?sKey=oqmNkdKiTSPSz84F&sCode=596748069";

    // JSONObject mJsonObject;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,
                container, false);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                meetingDetailsCall();
                break;
        }

    }



    public void meetingDetailsCall() {

        String urlString = "";

        AsyncHttpClient client = new AsyncHttpClient();
        // client.addHeader("Authorization", "1x7lxjloehyii00v4bxal7pcf31ymyzov79sqvh4cg");
        //setProgressBarIndeterminateVisibility(true);
        Log.d(LOG_TAG, QUERY_URL + urlString);

        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler() {


                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        //setProgressBarIndeterminateVisibility(false);

                        //Toast.makeText(getActivity().getApplicationContext(), "Success!",
                        //        Toast.LENGTH_LONG).show();
                        Log.d(LOG_TAG, "meetingDetailsCall onSuccess start");

                        // mJsonObject = jsonObject;

                        StartFragment2Listener listener = (StartFragment2Listener) getActivity();
                        listener.startFragment2(jsonObject);


                        Log.d(LOG_TAG, "meetingDetailsCall onSuccess end ");



                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                        //setProgressBarIndeterminateVisibility(false);

                        //Toast.makeText(getActivity().getApplicationContext(), "Error: " + statusCode + " " +
                        //        throwable.getMessage(), Toast.LENGTH_LONG).show();

                        Log.e("omg android", statusCode + " " + throwable.getMessage());
                    }
                }
        );

    }

    public interface StartFragment2Listener {
        void startFragment2(JSONObject jsonObject);
    }
}