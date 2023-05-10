package view;

import controller.UnitMenuController;
import model.People.Units.Enums.State;
import view.Commands.UnitMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class UnitMenu {

    public void run(Scanner scanner) {
        String command;
        Matcher matcher;

        while (true) {
            command = scanner.nextLine();

            // .:: Move Unit ::.
            if ((matcher = UnitMenuCommands.getMatcher(command, UnitMenuCommands.MOVE_UNIT)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (UnitMenuController.moveUnit(x, y)) {
                    case SUCCESS -> System.out.println("Unit moved successfully.");
                    case NO_UNIT -> System.out.println("Move unit failed. There is no unit in this block.");
                    case INVALID_COORDINATION -> System.out.println("Move unit failed. This block is not in the map.");
                }
            }

            // .:: Patrol Unit ::.
            else if ((matcher = UnitMenuCommands.getMatcher(command, UnitMenuCommands.PATROL_UNIT)) != null) {
                int x1 = Integer.parseInt(matcher.group("x1"));
                int y1 = Integer.parseInt(matcher.group("y1"));
                int x2 = Integer.parseInt(matcher.group("x2"));
                int y2 = Integer.parseInt(matcher.group("y2"));
                switch (UnitMenuController.patrolUnit(x1, y1, x2, y2)) {
                    case SUCCESS -> System.out.println("Unit state set successfully.");
                    case NO_UNIT -> System.out.println("Set unit state failed. There is no unit in this block.");
                    case INVALID_COORDINATION ->
                            System.out.println("Set unit state failed. This block is not in the map.");
                }
            }

            // .:: Set State ::.
            else if ((matcher = UnitMenuCommands.getMatcher(command, UnitMenuCommands.SET_UNIT_STATE)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                State state = State.getEnumState(matcher.group("state"));
                switch (UnitMenuController.setUnitState(x, y, state)) {
                    case SUCCESS -> System.out.println("Unit state set successfully.");
                    case NO_UNIT -> System.out.println("Set unit state failed. There is no unit in this block.");
                    case INVALID_COORDINATION ->
                            System.out.println("Set unit state failed. This block is not in the map.");
                }
            }

            // .:: Attack Enemy ::.
            else if ((matcher = UnitMenuCommands.getMatcher(command, UnitMenuCommands.ATTACK_ENEMY)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (UnitMenuController.attackEnemy(x, y)) {
                    case SUCCESS -> System.out.println("Attack enemy done successfully.");
                    case NO_UNIT -> System.out.println("Attack Enemy failed. There is no unit in this block.");
                    case INVALID_COORDINATION -> System.out.println("Attack failed. This block is not in the map.");
                }
            }

            // .:: Attack Air ::.
            else if ((matcher = UnitMenuCommands.getMatcher(command, UnitMenuCommands.ATTACK_AIR)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (UnitMenuController.attackAir(x, y)) {
                    case SUCCESS -> System.out.println("Attack (air) done successfully.");
                    case NO_UNIT -> System.out.println("Attack (air)) failed. There is no unit in this block.");
                    case INVALID_COORDINATION -> System.out.println("Attack (air) failed. This block is not in the map.");
                }
            }

            // To be continued ... ^_^
        }
    }
}
