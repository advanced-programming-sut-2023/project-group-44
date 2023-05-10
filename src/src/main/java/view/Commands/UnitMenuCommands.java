package view.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum UnitMenuCommands {

    MOVE_UNIT ("^move\\s+unit\\s+to(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    PATROL_UNIT ("^patrol unit -x1 (\\d+) -y1 (\\d+) -x2 (\\d+) -y2 (\\d+)$"), // Fix it please!
    SET_UNIT_STATE ("^set(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*\\s+(?<state>standing|defensive|offensive)$"),
    ATTACK_ENEMY ("^attack -e (?<x>[0-9]+) (?<y>[0-9]+)$"), // Position of x and y is fixed.
    ATTACK_AIR ("^attack(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$");





    public String RegEx;
    UnitMenuCommands (String RegEx){
        this.RegEx = RegEx;
    }

    public static Matcher getMatcher(String command, UnitMenuCommands Enum) {
        Matcher matcher = Pattern.compile(Enum.RegEx).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}
