package controller;

import model.App;
import model.Buildings.CastleBuildings;
import model.Governance;
import model.People.Units.Enums.RoleUnit;
import model.People.Units.Unit;
import model.People.Type;
import model.People.Workers.RoleWorker;
import model.People.Workers.Worker;

public class BuildingMenuController {

    public static boolean selectErrors(int x, int y){
        if(App.gameMap.getBlock(x,y).getBuilding() == null){
            System.out.println("there is not any building in this block");
            return false;
        }else if(!App.gameMap.getBlock(x,y).getBuilding().getGovernment().equals(App.getCurrentUser().getGovernance())){
            System.out.println("this building does not belong to you");
            return false;
        }
        return true;
    }

    public static void repair(int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding() instanceof CastleBuildings){
            if(App.getCurrentUser().getGovernance().getTreasury().getStones() < 5) System.out.println("you don't have enough stones");
            else{
                App.gameMap.getBlock(x,y).getBuilding().setHp(App.gameMap.getBlock(x,y).getBuilding().getMaximumHp());
                App.getCurrentUser().getGovernance().getTreasury().addStones(-5);
                System.out.println("repair was successful");
            }
        }else System.out.println("only castle buildings are repairable");
    }

    public static void stoneGateHouse(int taxRate,int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding().getType().equals("small stone gatehouse") ||
             App.gameMap.getBlock(x,y).getBuilding().getType().equals("big stone gatehouse")){
            App.getCurrentUser().getGovernance().setTaxRate(taxRate);
        }else System.out.println("this command is not for this building");
    }


    public static void drawBridge(String position,int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding().getType().equals("drawbridge")){
            CastleBuildings drawbridge= (CastleBuildings) App.gameMap.getBlock(x, y).getBuilding();
            drawbridge.setPositionOfTheDrawBridge(position);
        }
        else
            System.out.println("invalid command!");
    }

    public static void mercenaryBarrack(String typeOfSoldier,int numberOfArabSoldier,int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding().getType().equals("mercenary barrack")){
            Governance governance=App.getCurrentUser().getGovernance();
            if(governance.getTreasury().getGolds()<numberOfArabSoldier*30){
                System.out.println("You don't have enough gold!");
            }
            else{
                governance.getTreasury().addGolds(-30*numberOfArabSoldier);
                for(int i=0;i<numberOfArabSoldier;i++){
                    Unit Unit=new Unit(Type.UNIT, App.getCurrentUser().getGovernance(),20, RoleUnit.convertEnumRoleUnit(typeOfSoldier));
                    governance.getUnits().add(Unit);
                }
            }
        }
        else System.out.println("invalid command!");
    }

    public static void engineerGuild(String typeOfWorker,int numberOfPeople,int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding().getType().equals("engineer guild")){
            Governance governance=App.getCurrentUser().getGovernance();
            if(numberOfPeople>governance.getOrdinaryPeople().size())
                System.out.println("the governance don't have enough people!");
            else {
                for(int i=0;i<numberOfPeople;i++){
                    Worker person= (Worker) governance.getOrdinaryPeople().remove(governance.getOrdinaryPeople().size()-1);
                    person.setType(Type.WORKER);
                    person.setWorkPlace(App.gameMap.getBlock(x,y).getBuilding());
                    person.setRoleWorker(Worker.convertEnumRoleWorker(typeOfWorker));
                    if(Worker.convertEnumRoleWorker(typeOfWorker).equals(RoleWorker.ENGINEER))
                        governance.getEngineers().add(person);
                    else
                        governance.getWorkers().add(person);
                }
            }
        }
        
            public static BuildingMenuMessages createUnit(String type, int count, int x, int y) {
        Governance governance = App.getCurrentUser().getGovernance();
        Block block = App.gameMap.getBlock(x, y);
        if (count <= 0) {
            return BuildingMenuMessages.INVALID_COUNT;
        } else if (governance.getFreePopulation() < count) {
            return BuildingMenuMessages.INSUFFICIENT_HUMAN_RESOURCE;
        }
//        else if ()
        else if (type.equalsIgnoreCase("engineer")) {
            Engineer engineer = new Engineer(governance, 100, 10, 10, false, true);
            block.addEngineer(engineer);
            engineer.setBlock(block);
            return BuildingMenuMessages.SUCCESS;
        } else if (RoleUnit.convertEnumRoleUnit(type) == null) {
            return BuildingMenuMessages.INVALID_ROLE;
        } else {
            RoleUnit role = RoleUnit.convertEnumRoleUnit(type);
            Unit unit = new Unit(Type.UNIT, governance, 100, role);
            block.addUnit(unit);
            unit.setBlock(block);
            return BuildingMenuMessages.SUCCESS;
        }
    }
        
        else System.out.println("invalid command!");
    }
}
