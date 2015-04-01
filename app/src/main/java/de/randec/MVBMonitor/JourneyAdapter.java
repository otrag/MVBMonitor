package de.randec.MVBMonitor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by olli on 09.02.15.
 */

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.ContactViewHolder> {

    private ArrayList<Journey> journeyList;

    public JourneyAdapter(ArrayList<Journey> journeyList) {
        this.journeyList = journeyList;
    }


    @Override
    public int getItemCount() {
        return journeyList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Journey j = journeyList.get(i);

        contactViewHolder.vTitle.setText(j.getLine()+"  "+j.getDirection());
        contactViewHolder.vDepartTime.setText(j.getDepartTime());

        switch (j.getLine().substring(0,3)){
            case "Bus":
                contactViewHolder.vIcon.setImageResource(R.drawable.ic_bus_grey600_48dp);
                break;
            default:
                contactViewHolder.vIcon.setImageResource(R.drawable.ic_tram_grey600_48dp);
                break;
        }

        switch (j.getLine()){
            case "Str    1":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str1));
                break;
            case "Str    2":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str2));
                break;
            case "Str    3":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str3));
                break;
            case "Str    4":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str4));
                break;
            case "Str    5":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str5));
                break;
            case "Str    6":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str6));
                break;
            case "Str    8":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str8));
                break;
            case "Str    9":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str9));
                break;
            case "Str   10":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str10));
                break;
            case "Str   93":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str93));
                break;
            case "Str   94":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str94));
                break;
            case "Str   95":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Str95));
                break;
            case "Bus   51":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus51));
                break;
            case "Bus   52":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus52));
                break;
            case "Bus   53":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus53));
                break;
            case "Bus   54":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus54));
                break;
            case "Bus   55":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus55));
                break;
            case "Bus   56":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus56));
                break;
            case "Bus   57":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus57));
                break;
            case "Bus   58":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus58));
                break;
            case "Bus   59":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus59));
                break;
            case "Bus   61":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus61));
                break;
            case "Bus   69":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus69));
                break;
            case "Bus   71":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus71));
                break;
            case "Bus   73":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus73));
                break;
            case "Bus   91":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus91));
                break;
            case "Bus   92":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus92));
                break;
            case "Bus   96":
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.Bus96));
                break;
            default:
                contactViewHolder.vTitle.setBackgroundColor(contactViewHolder.itemView.getResources().getColor(R.color.other));
                break;
        }

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_layout, viewGroup, false);

            return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vDepartTime;
        protected ImageView vIcon;

        public ContactViewHolder(View v) {
            super(v);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDepartTime =  (TextView) v.findViewById(R.id.txtDepartTime);
            vIcon =(ImageView) v.findViewById(R.id.icon);
        }
    }
}
