package controller;

import model.App;
import model.Block;
import model.Buildings.Building;
import model.Governance;
import model.Map;
import model.People.Engineer;
import model.People.Type;
import model.People.Units.Enums.RoleUnit;
import model.People.Units.Unit;
import view.Commands.GameMenuCommands;
import view.Messages.BuildingMenuMessages;
import view.Messages.UnitMenuMessages;

import java.util.ArrayList;

public class GameMenuController {
    private static ArrayList<Unit> selectedUnits;
    private static ArrayList<Engineer> selectedEngineers;
    private static Building selectedBuilding;

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
        Block block = App.gameMap.getBlock(x, y);
        if (block.getUnits().isEmpty()) {
            return UnitMenuMessages.NO_UNIT;
        }
        for (Unit unit : block.getUnits()) {
            if (unit.getOwner() != LoginMenuController.loggedInUser.getGovernance()) {
                return UnitMenuMessages.FORBIDDEN;
            }
        }
        selectedUnits.addAll(Unit.getUnitsByBlock(x, y));
        selectedEngineers.addAll(Engineer.getEngineersByBlock(x, y));
        return UnitMenuMessages.SUCCESS;
    }

    public static BuildingMenuMessages selectBuilding(int x, int y) {
        Block block = App.gameMap.getBlock(x, y);
        if (!UnitMenuController.checkIndex(x, y)) {
            return BuildingMenuMessages.INVALID_COORDINATION;
        }
        if (block.getBuilding() == null) {
            return BuildingMenuMessages.NO_BUILDING;
        }
        if (block.getBuilding().getGovernment() != App.getCurrentUser().getGovernance()) {
            return BuildingMenuMessages.FORBIDDEN;
        }
        selectedBuilding = block.getBuilding();
        return BuildingMenuMessages.SUCCESS;
    }

    public static BuildingMenuMessages dropUnit(int x, int y, String type, int count) {
        if (RoleUnit.convertEnumRoleUnit(type) == null && !type.equalsIgnoreCase("engineer")) {
            return BuildingMenuMessages.INVALID_ROLE;
        }
        if (!UnitMenuController.checkIndex(x, y)) {
            return BuildingMenuMessages.INVALID_COORDINATION;
        }
        if (count <= 0) {
            return BuildingMenuMessages.INVALID_COUNT;
        }
        String texture = App.gameMap.getBlock(x, y).getTexture();
        if (texture.equals("sea") || texture.equals("stone")) {
            return BuildingMenuMessages.IMPROPER_GROUND;
        }
        Block block = App.gameMap.getBlock(x, y);
        Governance governance = App.getCurrentUser().getGovernance();
        if (type.equalsIgnoreCase("engineer")) {
            Engineer engineer = new Engineer(governance, 100, 10, 10, false, true);
            block.addEngineer(engineer);
            engineer.setBlock(block);
        } else {
            RoleUnit role = RoleUnit.convertEnumRoleUnit(type);
            Unit unit = new Unit(Type.UNIT, governance, 100, role);
            block.addUnit(unit);
            unit.setBlock(block);
        }
        return BuildingMenuMessages.SUCCESS;
    }
}
