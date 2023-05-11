package controller;

import model.Block;
import model.People.Units.Enums.State;
import model.People.Units.Unit;
import view.Messages.UnitMenuMessages;

public class UnitMenuController {


    // .:: Move Unit Controller ::.
    public static UnitMenuMessages moveUnit(int x, int y) {
        if (!checkIndex(x, y)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        if (!checkUnitExistence(x, y)) { 
            return UnitMenuMessages.NO_UNIT;
        }
        for (Unit unit : GameMenuController.selectedUnits) {
            Block destination = GameMenuController.currentMap.getBlock(x, y);
            unit.setBlock(destination);
        }
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Set State Controller ::.
    public static UnitMenuMessages setUnitState(int x, int y, State state) {
        if (!checkIndex(x, y)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        if (!checkUnitExistence(x, y)) { 
            return UnitMenuMessages.NO_UNIT;
        }
        for (Unit unit : GameMenuController.selectedUnits) {
            unit.setState(state);
        }
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Patrol Unit Controller ::.
    public static UnitMenuMessages patrolUnit(int x1, int y1, int x2, int y2) {
        if (!checkIndex(x1, y1) || !checkIndex(x2, y2)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        if (!checkUnitExistence(x1, y1)) { 
            return UnitMenuMessages.NO_UNIT;
        }
        // ....
        // ....
        // After they patrolled ^_^
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Attack Enemy Controller ::.
    public static UnitMenuMessages attackEnemy(int x, int y) {
        if (!checkIndex(x, y)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        if (!checkUnitExistence(x, y)) { 
            return UnitMenuMessages.NO_UNIT;
        }
        // ....
        // ....
        // After they attacked ^_^
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Attack Air Controller ::.
    public static UnitMenuMessages attackAir(int x, int y) {
        if (!checkIndex(x, y)) { 
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        if (!checkUnitExistence(x, y)) { 
            return UnitMenuMessages.NO_UNIT;
        }
        // ....
        // ....
        // After they attacked ^_^
        return UnitMenuMessages.SUCCESS;
    }



    /* ___________________________________ AUXILIARY METHODS ___________________________________ */

    /* This method checks whether the given indices are inside the map.*/
    public static boolean checkIndex(int x, int y) {
        if (GameMenuController.currentMap.getLengthOfMap() < x || GameMenuController.currentMap.getLengthOfMap() < y || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    /* This method checks if there is any unit in the given block.*/
    public static boolean checkUnitExistence(int x, int y) {
        Block block = GameMenuController.currentMap.getBlock(x, y);
        if (block.getUnits().isEmpty()) {
            return false;
        }
        return true;
    }
}

