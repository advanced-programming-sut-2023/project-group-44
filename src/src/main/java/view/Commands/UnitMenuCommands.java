package view.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum UnitMenuCommands {

    MOVE_UNIT ("^move\\s+unit\\s+to(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    PATROL_UNIT ("^patrol unit(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    STOP_PATROL ("^stop patrol$"),
    SET_UNIT_STATE ("^set (?<state>standing|defensive|offensive)$"),
    ATTACK_ENEMY ("^attack -e (?<x>[0-9]+) (?<y>[0-9]+)$"),
    ATTACK_AIR ("^attack(?=.*\\s+-x\\s+(?<enemyX>[0-9]+))(?=.*\\s+-y\\s+(?<enemyY>[0-9]+)).*$"),
    POUR_OIL ("^pour oil -d (?<direction>[n|s|w|e])"),
    DIG_TUNNEL ("^dig tunnel(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    BUILD_EQUIPMENT ("^build \\-q (?<equipment>\\S+)$"),
    DISBAND ("^disband$");


    public String RegEx;
    UnitMenuCommands (String RegEx){
        this.RegEx = RegEx;
    }

    public static Matcher getMatcher(String command, UnitMenuCommands Enum) {
        Matcher matcher = Pattern.compile(Enum.RegEx).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}
