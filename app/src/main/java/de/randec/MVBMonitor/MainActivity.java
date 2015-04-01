/*
  Copyright 2015 Oliver Traeger
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  */


package de.randec.MVBMonitor;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<Fragment> fList;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the stations. I use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the station contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fList = new ArrayList<>();
        GPSService mGPSService = new GPSService(this);
        mGPSService.getLocation();

        //get Location

        if (!mGPSService.isLocationAvailable) {

            // Here you can ask the user to try again, using return; for that
            Toast.makeText(this, "Your location is not available, please try again.", Toast.LENGTH_SHORT).show();
            return;

            // Or you can continue without getting the location, remove the return; above and uncomment the line given below
            // address = "Location not available";
        } else {

            String latitude = formatCoordinate(mGPSService.getLatitude());
            String longitude = formatCoordinate(mGPSService.getLongitude());

               //build query for nearby stations
            String query = String.format(getString(R.string.queryStation),longitude,latitude);
            Log.d("query",query);

            new DownloadStations().execute(query);

        }

        // make sure you close the gps after using it. Save user's battery power
        mGPSService.closeGPS();
    }

        private String formatCoordinate(Double d){
        //Coordinates need to be in format dddddddd
        String result = Double.toString(d).replace(".", "");
        if(result.length()>8){
            result=result.substring(0,8);
        }else{
            while(result.length()<8){
                result+="0";
            }
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_settings:
                return true;


            case R.id.action_refresh:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of stations.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    private class DownloadStations extends AsyncTask<String, Void, String> {

        private String jsonData;
        private JSONObject json;

        @Override
        protected String doInBackground(String... urls) {

            try{

                jsonData = Downloader.downloadJson(urls[0]);
                //jsonArray needs string to start with [
                jsonData = jsonData.substring(jsonData.indexOf('['));

                JSONArray jArray = new JSONArray(jsonData);
                //parse Array and add Fragments with stopId and stopName to list
                for(int i=0;i<jArray.length();i++) {
                    json = jArray.getJSONObject(i);
                    String stopName = json.getString("name");
                    if(stopName.contains("Magdeburg,")) stopName = stopName.replace("Magdeburg,","");
                    int stopId = Integer.parseInt(json.getString("extId"));
                    fList.add(JourneyFragment.newInstance(stopId, stopName));
                }
            }catch ( JSONException e) {
                return "JSON conversion failed";
            }catch(IOException e){
                return "Unable to download data";
            }catch (StringIndexOutOfBoundsException e){
                return "Data not in right format";
            }

            return null;
        }

        protected void onPostExecute(String result){

            // Create the adapter that will return a fragment for each station
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fList);

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mSectionsPagerAdapter);



        }
    }
}
