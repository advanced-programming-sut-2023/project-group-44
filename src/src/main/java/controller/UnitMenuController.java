package controller;

import model.App;
import model.Block;
import model.People.Engineer;
import model.People.Units.Enums.State;
import model.People.Units.Unit;
import view.GameMenu;
import view.Messages.UnitMenuMessages;

public class UnitMenuController {


    // .:: Move Unit Controller ::.
    public static UnitMenuMessages moveUnitTo(int x, int y) {
        if (!checkIndex(x, y)) {
            return UnitMenuMessages.INVALID_COORDINATION;
        }
        for (Unit unit : GameMenuController.getSelectedUnits()) {
            Block destination = App.gameMap.getBlock(x, y);
            unit.setBlock(destination);
        }
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Set State Controller ::.
    public static UnitMenuMessages setUnitState(State state) {
        for (Unit unit : GameMenuController.getSelectedUnits()) {
            unit.setState(state);
        }
        return UnitMenuMessages.SUCCESS;
    }

    // .:: Patrol Unit Controller ::.
    public static UnitMenuMessages patrolUnit(int x, int y) {
        if (!checkIndex(x, y)) {
            return UnitMenuMessages.INVALID_COORDINATION;
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
        if (App.gameMap.getLengthOfMap() < x || App.gameMap.getLengthOfMap() < y || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    /* This method checks if there is any unit in the given block.*/
    public static boolean checkUnitExistence(int x, int y) {
        Block block = App.gameMap.getBlock(x, y);
        if (block.getUnits().isEmpty()) {
            return false;
        }
        return true;
    }
}

