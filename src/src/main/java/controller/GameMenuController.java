package controller;

import model.Block;
import model.Buildings.Building;
import model.Map;
import model.People.Units.Unit;
import view.Messages.UnitMenuMessages;
import view.UnitMenu;

import java.util.ArrayList;

public class GameMenuController {
    public static ArrayList<Unit> selectedUnits;
    public static Map currentMap; // Not sure

    public static UnitMenuMessages selectUnit (int x, int y) {
        if (!UnitMenuController.checkIndex(x, y)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        Block block = currentMap.getBlock(x, y);
        if (block.getUnits().isEmpty()){
            return UnitMenuMessages.NO_UNIT;
        }
        GameMenuController.selectedUnits = Unit.getUnitsByBlock(x, y);
        return UnitMenuMessages.SUCCESS;
    }




}
