package enums;

public enum TimerEnum {
    SECONDS_30,
    MINUTES_1,
    MINUTES_2,
    MINUTES_3,
    MINUTES_4,
    MINUTES_5,
    ERROR;

    public static TimerEnum chooseTime(String time){

        switch (time){
            case "seconds_30": return TimerEnum.SECONDS_30;
            case "minutes_1": return TimerEnum.MINUTES_1;
            case "minutes_2": return TimerEnum.MINUTES_2;
            case "minutes_3": return TimerEnum.MINUTES_3;
            case "minutes_4": return TimerEnum.MINUTES_4;
            case "minutes_5": return TimerEnum.MINUTES_5;
            default: return ERROR;
        }
    }
}
