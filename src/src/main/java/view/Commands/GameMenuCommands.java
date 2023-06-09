package view.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands {

    SHOW_MAP ("^show\\s+map(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    SHOW_POPULARITY_FACTORS ("^show\\s+popularity\\s+factors$"),
    SHOW_POPULARITY ("^show\\s+popularity$"),
    SHOW_FOOD_LIST ("^show\\s+food\\s+list$"),
    FOOD_RATE_DETERMINATION ("^food\\s+rate\\s+-r\\s+(?<rateNumber>[0-2]|\\-[1-2])$"),
    FOOD_RATE_SHOW ("^food\\s+rate\\s+show$"),
    TAX_RATE_DETERMINATION ("^tax\\s+rate\\s+-r\\s+(?<rateNumber>[0-8]|\\-[1-3])$"),
    TAX_RATE_SHOW ("^tax\\s+rate\\s+show$"),
    FEAR_RATE_DETERMINATION ("^fear\\s+rate\\s+-r\\s+(?<rateNumber>[0-5]|\\-[1-5])$"),
    DROP_BUILDING ("^drop building(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+))(?=.*\\s+-type\\s+(?<type>\"[^\"]+\"|\\S+)).*$"),
    DROP_UNIT("^drop unit \\-x (?<x>\\d+) \\-y (?<y>\\d+) \\-t (?<type>\\S+) \\-c (?<count>\\d+)$"),
    SELECT_BUILDING ("^select\\s+building(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    SELECT_UNIT ("^select\\s+unit(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    SET_TEXTURE_MONO ("^set texture(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+))(?=.*\\s+-type\\s+(?<type>\"[\"]+\"|\\S+)).*$"),
    SET_TEXTURE_POLY ("^set texture(?=.*\\s+-x1\\s+(?<x1>[0-9]+))(?=.*\\s+-y1\\s+(?<y1>[0-9]+))(?=.*\\s+-x2\\s+(?<x2>[0-9]+))(?=.*\\s+-y2\\s+(?<y2>[0-9]+))(?=.*\\s+-type\\s+(?<type>\"[\"]+\"|\\S+)).*$"),
    CLEAR ("^clear(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$"),
    DROP_ROCK("^drop\\s+rock(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+))(?=.*\\s+-d\\s+(?<direction>[wens]|random)).*$"),
    DROP_TREE("^drop\\s+tree(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+))(?=.*\\s+-type\\s+(?<type>shrub|cherry|olive|coconut|date)).*$"),
    OPEN_TRADE_MENU("^open\\s+trade\\s+menu$"),
    NEXT_TURN("^nextturn$"),
    BACK ("^back$");
    public String RegEx;
    GameMenuCommands (String RegEx){
        this.RegEx = RegEx;
    }

    public static Matcher getMatcher(String command, GameMenuCommands Enum) {
        Matcher matcher = Pattern.compile(Enum.RegEx).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}
