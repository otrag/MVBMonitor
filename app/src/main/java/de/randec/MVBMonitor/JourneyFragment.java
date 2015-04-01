package de.randec.MVBMonitor;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
     * A placeholder fragment containing the recycler view.
     */
    public class JourneyFragment extends Fragment {
        /**
         * The fragment argument representing the station
         */
        private static final String ARG_STATION_ID = "station_id";
        private static final String ARG_STATION_NAME ="station_name";

        protected TextView stationName;
        protected RecyclerView recList;

        /**
         * Returns a new instance of this fragment for the given station
         */
        public static JourneyFragment newInstance(int stationId,String stationName) {
            JourneyFragment fragment = new JourneyFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_STATION_ID, stationId);
            args.putString(ARG_STATION_NAME, stationName);
            fragment.setArguments(args);
            return fragment;
        }

        public JourneyFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment, container, false);
            stationName = (TextView) rootView.findViewById(R.id.txtStationName);


            recList = (RecyclerView) rootView.findViewById(R.id.cardList);
            recList.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recList.setLayoutManager(llm);

            //build the query for journeys from station
            Calendar cal = Calendar.getInstance();
            int hours=cal.get(Calendar.HOUR_OF_DAY);
            int minutes=cal.get(Calendar.MINUTE);

            String query = String.format(getString(R.string.queryJourneys),getArguments().getInt(ARG_STATION_ID),hours,minutes);
            new DownloadJourneys().execute(query);

            return rootView;
        }

    private class DownloadJourneys extends AsyncTask<String, Void, String> {

        private String jsonData;
        private JSONObject json;
        private ArrayList<Journey> myJourneys;

        @Override
        protected String doInBackground(String... urls) {

            String myUrl = urls[0];

            try{

                jsonData = Downloader.downloadJson(myUrl);
                //jsonArray needs string to start with [
                jsonData = jsonData.substring(jsonData.indexOf("[", jsonData.indexOf("[") + 1));
                myJourneys = new ArrayList<>();
                Log.d("onPostExecute", jsonData);

                JSONArray jArray = new JSONArray(jsonData);
                for(int i=0;i<jArray.length();i++) {
                    json = jArray.getJSONObject(i);

                    String departTime = json.getString("ti");
                    String direction = json.getString("st");
                    if(direction.contains("Magdeburg,")) direction = direction.replace("Magdeburg,","");
                    String line = json.getString("pr");
                    Journey myJourney = new Journey(departTime, direction, line);
                    myJourneys.add(myJourney);

                }
            }catch ( JSONException e) {
                return "JSON conversion failed";
            } catch(IOException e){
                return "Unable to download data";
            }catch (StringIndexOutOfBoundsException e){
                return "Data not in right format";
            }

            return null;
        }

        protected void onPostExecute(String result){
            //getActivity returns the Context maybe check if not null
           // ArrayAdapter<Journey> adapter = new ArrayAdapter<>(getActivity(),R.layout.list_item,myJourneys);

            stationName.setText(getArguments().getString(ARG_STATION_NAME));
            //lvResult.setAdapter(adapter);

            JourneyAdapter ja = new JourneyAdapter(myJourneys);
            recList.setAdapter(ja);

        }



    }

    }