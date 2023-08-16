public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void nextSecond() {
        if (second == 59) {
            nextMinute();
            setSecond(0);
        } else {
            setSecond(second + 1);
        }
    }

    public void nextMinute() {
        if (minute == 59) {
            nextHour();
            setMinute(0);
        } else {
            setMinute(minute + 1);
        }
    }

    private void nextHour() {
        if (hour == 23) {
            setHour(0);
        } else {
            setHour(hour + 1);
        }
    }

    public void previousSecond() {
        if (second == 0) {
            previousMinute();
            setSecond(59);
        } else {
            setSecond(second - 1);
        }
    }

    private void previousMinute() {
        if (minute == 0) {
            previousHour();
            setMinute(59);
        } else {
            setMinute(minute - 1);
        }
    }

    private void previousHour() {
        if (hour == 0) {
            setHour(23);
        } else {
            setHour(hour - 1);
        }
    }

    public void display() {
        String hour = this.hour + "";
        String minute = this.minute + "";
        String second = this.second + "";
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        if (second.length() == 1) {
            second = "0" + second;
        }
        System.out.println(hour + ":" + minute + ":" + second);
    }
}
