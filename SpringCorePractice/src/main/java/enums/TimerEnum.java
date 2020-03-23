package enums;

public enum TimerEnum {
    SECONDS_30,
    MINUTES_1,
    MINUTES_2,
    MINUTES_3,
    MINUTES_4,
    MINUTES_5;

    public static TimerEnum chooseTime(String time){

        switch (time){
            case "SECONDS_30": return TimerEnum.SECONDS_30;
            case "MINUTES_1": return TimerEnum.MINUTES_1;
            case "MINUTES_2": return TimerEnum.MINUTES_2;
            case "MINUTES_3": return TimerEnum.MINUTES_3;
            case "MINUTES_4": return TimerEnum.MINUTES_4;
            case "MINUTES_5": return TimerEnum.MINUTES_5;
            default: return null;
        }
    }
}
