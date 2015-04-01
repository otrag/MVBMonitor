package de.randec.MVBMonitor;

/**
 * Created by olli on 30.01.15.
 */

public class Journey {

    String departTime;
    String direction;
    String line;

    public Journey(String departTime, String direction,String line) {
        setDepartTime(departTime);
        setDirection(direction);
        setLine(line);
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

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String toString(){
        return  "Linie: "+getLine()+"\n"+
                "Zeit: "+getDepartTime()+"\n"+
                "Richtung: "+getDirection();
    }
}
