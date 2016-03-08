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

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class Journey {

    String departTime;
    String departDate;
    String direction;
    String line;
    String delayMinutes;
    String delayTime;

    public Journey(String departTime, String direction,String line, String departDate, String delayMinutes, String delayTime) {
        setDepartTime(departTime);
        setDirection(direction);
        setLine(line);
        setDepartDate(departDate);
        setDelayMinutes(delayMinutes);
        setDelayTime(delayTime);
    }

    public String getDirection() {
        return direction;
    }

    public String getDepartTime() {return departTime;}

    public String getLine() {return line;}

    public String getDepartDate() {return departDate; }


    public String getDelayMinutes() {return delayMinutes; }

    public String getDelayTime() {return delayTime; }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLine(String line) { this.line = line;}

    public void setDepartDate(String departDate) {this.departDate = departDate;}

    public void setDelayMinutes(String delayMinutes) {this.delayMinutes = delayMinutes;}

    public void setDelayTime(String delayTime) {this.delayTime = delayTime;}

    public Spannable departString(){
        String s;
        //return a spannable to enable different colors in an single text
        Spannable result;
        s = getDepartTime();
        if(!getDelayMinutes().equals("0")){
            s+=(" +"+getDelayMinutes()+ "min");
            result = new SpannableString(s);
            result.setSpan(new ForegroundColorSpan(Color.RED),s.indexOf(" ")+1,s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
        else result = new SpannableString(s);
        return result;
    }
}
