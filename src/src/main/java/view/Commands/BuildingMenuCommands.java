package view.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BuildingMenuCommands {

    REPAIR ("^repair$"),
    CHANGE_TAX_RATE ("^change\\s+tax\\s+rate\\s+(?<rateNumber>[0-8]|\\-[1-3])$"),
    CHANGE_BRIDGE_POSITION ("^change\\s+the\\s+position\\s+of\\s+the\\s+bridge\\s+(?<position>up|down)$"),
    BUY_SOLDIERS ("^buy\\s+number:\\s+(?<numberOfSoldiers>\\d+)\\s+type:\\s+(?<typeOfSoldier>\\w+)$"),
    HIRE_SOLDIERS ("hire\\s+number:\\s+(?<numberOfPeople>\\d+)\\s+type:\\s+(?<typeOfPeople>\\w+)"),
    CREATE_UNIT ("^create unit(?=.*\\s+-t\\s+(?<type>\\S+))(?=.*\\s+-c\\s+(?<count>[0-9]+)).*$");










    public String RegEx;
    BuildingMenuCommands (String RegEx){
        this.RegEx = RegEx;
    }

    public static Matcher getMatcher(String command, BuildingMenuCommands Enum) {
        Matcher matcher = Pattern.compile(Enum.RegEx).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}
