package store;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BusinessHours {

    private HashMap<String, ArrayList<LocalTime>> dailyHours;

    protected BusinessHours() {
        this.dailyHours = new HashMap<>();
    }

    protected boolean setBusinessHours(String dayOfTheWeek, LocalTime open, LocalTime close) {
        if (this.dailyHours.containsKey(dayOfTheWeek)) {
            ArrayList<LocalTime> temp = this.dailyHours.get(dayOfTheWeek);
            temp.clear();
            temp.add(open);
            temp.add(close);
            return true;
        } else {
            ArrayList<LocalTime> temp = new ArrayList<>();
            temp.add(open);
            temp.add(close);
            this.dailyHours.put(dayOfTheWeek,temp);
            return false;
        }
    }

    protected boolean setHolidayHours(String holiday, LocalTime open, LocalTime close) {
       return setBusinessHours(holiday,open,close);
    }

    protected String getBusinessHours() {
        String returnString = "";
        for (Map.Entry<String,ArrayList<LocalTime>> entry: this.dailyHours.entrySet()) {
            ArrayList<LocalTime> times = entry.getValue();
            returnString += entry.getKey() + ": " + times.get(0).toString() + "AM - " +
                            times.get(1).toString() + "PM\n";
        }
        return returnString;
    }

    protected boolean isOpen(String holiday) {
        LocalTime currentTime = LocalTime.now();
        if (Objects.isNull(holiday)) {
            DayOfWeek today = LocalDate.now().getDayOfWeek();
            String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
            String dayOfWeek = days[today.getValue() - 1];
            ArrayList<LocalTime> hoursOfOperation = this.dailyHours.get(dayOfWeek);
            if (currentTime.compareTo(hoursOfOperation.get(0)) < 0 || currentTime.compareTo(hoursOfOperation.get(1)) > 0) {
                return false;
            } else {
                return true;
            }
        } else {
            ArrayList<LocalTime> hoursOfOperation = this.dailyHours.get(holiday);
            if (currentTime.compareTo(hoursOfOperation.get(0)) < 0 || currentTime.compareTo(hoursOfOperation.get(1)) > 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}