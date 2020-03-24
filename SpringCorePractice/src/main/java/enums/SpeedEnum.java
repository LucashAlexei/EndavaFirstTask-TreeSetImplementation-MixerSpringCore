package enums;

public enum SpeedEnum {
    LOW,
    MEDIUM,
    HIGHT,
    EXTRA,
    ERROR;

    public static SpeedEnum chooseSpeed(String speed){
        switch (speed){
            case "low": return SpeedEnum.LOW;
            case "medium": return SpeedEnum.MEDIUM;
            case "hight": return SpeedEnum.HIGHT;
            case "extra": return SpeedEnum.EXTRA;
            default: return ERROR;
        }
    }
}
