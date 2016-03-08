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

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.JourneyViewHolder> {

    private ArrayList<Journey> journeyList;
    private Context mcontext;
    //private StationFragment homeFragment;

    public JourneyAdapter(ArrayList<Journey> journeyList, Context mcontext) {
        this.mcontext = mcontext;
        this.journeyList = journeyList;
        //this.homeFragment = homeFragment;
    }



    @Override
    public int getItemCount() {
        return journeyList.size();
    }

    @Override
    public void onBindViewHolder(JourneyViewHolder journeyViewHolder, int i) {
        final Journey j = journeyList.get(i);

        journeyViewHolder.vTitle.setText(j.getLine() + "  " + j.getDirection());
        journeyViewHolder.vDepartTime.setText(j.departString());


        try {
            switch (j.getLine().substring(0, 3)) {
                case "Bus":
                    journeyViewHolder.vIcon.setImageResource(R.drawable.ic_bus_grey600_48dp);
                    break;
                default:
                    journeyViewHolder.vIcon.setImageResource(R.drawable.ic_tram_grey600_48dp);
                    break;
            }
        }catch (Exception e){
            Log.d("error","switch icon broken"+j.getLine()+"Linie");
        }

        switch (j.getLine()){
            case "Str    1":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str1));
                break;
            case "Str    2":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str2));
                break;
            case "Str    3":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str3));
                break;
            case "Str    4":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str4));
                break;
            case "Str    5":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str5));
                break;
            case "Str    6":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str6));
                break;
            case "Str    8":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str8));
                break;
            case "Str    9":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str9));
                break;
            case "Str   10":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str10));
                break;
            case "Str   93":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str93));
                break;
            case "Str   94":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str94));
                break;
            case "Str   95":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Str95));
                break;
            case "Bus   51":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus51));
                break;
            case "Bus   52":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus52));
                break;
            case "Bus   53":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus53));
                break;
            case "Bus   54":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus54));
                break;
            case "Bus   55":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus55));
                break;
            case "Bus   56":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus56));
                break;
            case "Bus   57":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus57));
                break;
            case "Bus   58":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus58));
                break;
            case "Bus   59":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus59));
                break;
            case "Bus   61":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus61));
                break;
            case "Bus   69":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus69));
                break;
            case "Bus   71":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus71));
                break;
            case "Bus   73":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus73));
                break;
            case "Bus   91":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus91));
                break;
            case "Bus   92":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus92));
                break;
            case "Bus   96":
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.Bus96));
                break;
            default:
                journeyViewHolder.vTitle.setBackgroundColor(journeyViewHolder.itemView.getResources().getColor(R.color.other));
                break;
        }

       journeyViewHolder.vbtnAlarm.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                //adding Alarm
              SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy/hh:mm");
               try {
                    //departure Date
                   Date parsedDate = formatter.parse(j.getDepartDate()+"/"+j.getDelayTime());
                   Calendar cal = new GregorianCalendar();
                   //now
                   Calendar calNow = Calendar.getInstance();
                   cal.setTime(parsedDate);
                   //departure date -5 minutes for alarm !make this a setting
                   cal.add(Calendar.MINUTE, -5);
                   //only try to set alarm if departure date -5 minutes is in the future
                   if(cal.getTime().after(calNow.getTime())) {
                       Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);

                       i.putExtra(AlarmClock.EXTRA_HOUR, cal.get(Calendar.HOUR_OF_DAY));
                       i.putExtra(AlarmClock.EXTRA_MINUTES, cal.get(Calendar.MINUTE));
                       i.putExtra(AlarmClock.EXTRA_MESSAGE, j.getLine() + " Richtung " + j.getDirection());

                       mcontext.startActivity(i);
                   }else{
                       Toast.makeText(mcontext,"Die Bahn fährt gleich, jetzt loslaufen",Toast.LENGTH_LONG).show();
                   }
               }catch (ParseException e){
                   Log.d("exception","error parsing date");
               }



           }
       });

    }

    @Override
    public JourneyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_layout, viewGroup, false);

            return new JourneyViewHolder(itemView);
    }

    public static class JourneyViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vDepartTime;
        protected ImageView vIcon;
        protected ImageButton vbtnAlarm;

        public JourneyViewHolder(View v) {
            super(v);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDepartTime =  (TextView) v.findViewById(R.id.txtDepartTime);
            vIcon =(ImageView) v.findViewById(R.id.icon);
            vbtnAlarm =(ImageButton) v.findViewById(R.id.btnAlarm);
        }
    }
}
