package controller;

import model.Block;
import model.Map;
import model.People.Engineer;
import model.People.Units.Unit;
import view.Messages.UnitMenuMessages;

import java.util.ArrayList;

public class GameMenuController {
    private static ArrayList<Unit> selectedUnits;
    private static ArrayList<Engineer> selectedEngineers;
    public static Map currentMap; // Not sure

    public static ArrayList<Unit> getSelectedUnits() {
        return selectedUnits;
    }

    public static ArrayList<Engineer> getSelectedEngineers() {
        return selectedEngineers;
    }

    public static UnitMenuMessages selectUnit(int x, int y) {
        if (!UnitMenuController.checkIndex(x, y)) {
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        Block block = currentMap.getBlock(x, y);
        if (block.getUnits().isEmpty()) {
            return UnitMenuMessages.NO_UNIT;
        }
        for (Unit unit : block.getUnits()) {
            if (unit.getOwner() != LoginMenuController.loggedInUser.getGovernance()) {
                return UnitMenuMessages.FORBIDDEN;
            }
        }
        GameMenuController.selectedUnits.addAll(Unit.getUnitsByBlock(x, y));
        GameMenuController.selectedEngineers.addAll(Engineer.getEngineersByBlock(x, y));
        return UnitMenuMessages.SUCCESS;
    }
}
