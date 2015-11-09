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

public class Journey {

    String departTime;
    String departDate;
    String direction;
    String line;
    String status;
    String delayMinutes;
    String delayTime;

    public Journey(String departTime, String direction,String line, String departDate, String status, String delayMinutes, String delayTime) {
        setDepartTime(departTime);
        setDirection(direction);
        setLine(line);
        setDepartDate(departDate);
        setStatus(status);
        setDelayMinutes(delayMinutes);
        setDelayTime(delayTime);
    }

    public String getDirection() {
        return direction;
    }

    public String getDepartTime() {
        return departTime;
    }

    public String getLine() {
        return line;
    }

    public String getDepartDate() {return departDate; }

    public String getStatus() {return status; }

    public String getDelayMinutes() {return delayMinutes; }

    public String getDelayTime() {return delayTime; }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setDepartDate(String departDate) {this.departDate = departDate;}

    public void setStatus(String status) {this.status = status;}

    public void setDelayMinutes(String delayMinutes) {this.delayMinutes = delayMinutes;}

    public void setDelayTime(String delayTime) {this.delayTime = delayTime;}

    public String toString(){
        return  "Linie: "+getLine()+"\n"+
                "Zeit: "+getDepartTime()+"\n"+
                "Richtung: "+getDirection();
    }
}
