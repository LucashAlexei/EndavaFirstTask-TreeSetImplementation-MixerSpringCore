package enums;

public enum SpeedEnum {
    LOW,
    MEDIUM,
    HIGHT,
    EXTRA;

    public static SpeedEnum chooseSpeed(String speed){
        switch (speed){
            case "LOW": return SpeedEnum.LOW;
            case "MEDIUM": return SpeedEnum.MEDIUM;
            case "HIGHT": return SpeedEnum.HIGHT;
            case "EXTRA": return SpeedEnum.EXTRA;
            default: return null;
        }
    }
}
