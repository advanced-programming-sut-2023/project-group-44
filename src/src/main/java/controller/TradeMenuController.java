package controller;

import model.App;
import model.Buildings.CastleBuildings;
import model.Buildings.FoodProcessingBuildings;
import model.Buildings.Treasury;
import model.Governance;
import model.Requests;
import model.Things;

import java.util.regex.Matcher;

public class TradeMenuController {
    public static String donationRequest(Matcher matcher){
        String resourceType=SignUpMenuController.deleteQuotations(matcher.group("resourceType"));
        int resourceAmount=Integer.parseInt(matcher.group("resourceAmount"));
        int price=Integer.parseInt(matcher.group("price"));
        String message=SignUpMenuController.deleteQuotations(matcher.group("message"));
        if(Things.searchItemNames(resourceType)==null)
            return "Invalid resource type!";
        if(resourceAmount<=0)
            return "Invalid resource amount!";
        Requests requests=new Requests(App.getCurrentUser(),resourceType,resourceAmount,price,message);
        App.getTradeList().add(requests);
        App.getCurrentUser().getListOfRequests().add(requests);
        return "request has successfully submitted!";
    }

    public static String showTradeList(){
        String result="";
        int index=1;
        for(Requests requests: App.getTradeList()){
            if(index!=1) result+='\n';
            result+="id: "+index+"    requester: "+requests.getOwner().getUsername()+
                    "    resourceType: "+requests.getResourceType()+"    resourceAmount: "+requests.getAmount();
            index++;
        }
        return result;
    }

    public static String acceptTrade(Matcher matcher){
        int id=Integer.parseInt(matcher.group("id"));
        String message= matcher.group("message");
        if(id>App.getTradeList().size())
            return "this id is out of range!";
        Requests requests=App.getTradeList().get(id);
        Things things=Things.searchItemNames(requests.getResourceType());
        Governance governance=App.getCurrentUser().getGovernance();
        int amount=requests.getAmount();
        switch (things.getStorageName()){
            case "treasury":
                Treasury storage11= (Treasury) governance.getBuildingByName(things.getStorageName());
                Treasury storage21= (Treasury) requests.getOwner().getGovernance().getBuildingByName(things.getStorageName());
                switch (things.getName()){
                    case "wood":
                        if(storage11.getWoods()<amount)
                            return "You don't have enough wood!";
                        storage11.addWoods(-amount);
                        storage21.addWoods(amount);
                        break;
                    case "stone":
                        if(storage11.getStones()<amount)
                            return "You don't have enough stone!";
                        storage11.addStones(-amount);
                        storage21.addStones(amount);
                        break;
                    case "iron":
                        if(storage11.getIron()<amount)
                            return "You don't have enough iron!";
                        storage11.addIron(-amount);
                        storage21.addIron(amount);
                        break;
                    case "gold":
                        if(storage11.getGolds()<amount)
                            return "You don't have enough gold!";
                        storage11.addGolds(-amount);
                        storage21.addGolds(amount);
                        break;
                    case "pitch":
                        if(storage11.getPitch()<amount)
                            return "You don't have enough pitch!";
                        storage11.addPitch(-amount);
                        storage21.addPitch(amount);
                        break;
                }
                break;
            case "food stockpile":
                FoodProcessingBuildings storage12= (FoodProcessingBuildings) governance.getBuildingByName(things.getStorageName());
                FoodProcessingBuildings storage22= (FoodProcessingBuildings) requests.getOwner().getGovernance().getBuildingByName(things.getStorageName());
                if(!storage12.checkIfFoodIsEnoughForSell(things.getName(),amount))
                    return "You don't have enough "+things.getName()+"!";
                storage12.addFoodInStorage(things.getName(),-amount);
                storage22.addFoodInStorage(things.getName(),amount);
                break;
            case "armory":
                CastleBuildings storage13= (CastleBuildings) governance.getBuildingByName(things.getStorageName());
                CastleBuildings storage23= (CastleBuildings) requests.getOwner().getGovernance().getBuildingByName(things.getStorageName());
                if(!storage13.checkIfWeaponIsEnoughForSell(things.getName(),amount))
                    return "You don't have enough "+things.getName()+"!";
                storage13.addWeaponInStorage(things.getName(),-amount);
                storage23.addWeaponInStorage(things.getName(),amount);
                break;
        }
        requests.setThisRequestNew(true);
        requests.setAcceptMessage(message);
        requests.setDonator(App.getCurrentUser());
        App.getTradeList().remove(requests);
        App.getCurrentUser().getListOfRequests().add(requests);
        return "the trade successfully completed!";
    }

    public static String showTradeHistory(){
        String result="You as requester:";
        int index=1;
        for(Requests requests: App.getCurrentUser().getListOfRequests()){
            if(index!=1) result+='\n';
            if(App.getCurrentUser().equals(requests.getOwner())){
                result+="Donator: "+requests.getDonator().getUsername()+"    requestType: "+requests.getResourceType()+
                        "    requestAmount: "+requests.getAmount()+"    price: "+requests.getPrice()+
                        "    yourMessage: "+requests.getRequestMessage()+ "    donatorMessage: "+requests.getAcceptMessage();
                index++;
            }
        }
        result+="\nYou as Donator:";
        index=1;
        for(Requests requests: App.getCurrentUser().getListOfRequests()){
            if(index!=1) result+='\n';
            if(App.getCurrentUser().equals(requests.getDonator())){
                result+="Requester: "+requests.getOwner().getUsername()+"    requestType: "+requests.getResourceType()+
                        "    requestAmount: "+requests.getAmount()+"    price: "+requests.getPrice()+
                        "    requesterMessage: "+requests.getRequestMessage()+ "    yourMessage: "+requests.getAcceptMessage();
            }
            index++;
        }
        return result;
    }

    public static void showNewNotifications(){
        String result="you as requester:";
        int index=1;
        for(Requests requests: App.getCurrentUser().getListOfRequests()){
            if(index!=1) result+='\n';
            if(App.getCurrentUser().equals(requests.getOwner()) && requests.isThisRequestNew()){
                result+="Donator: "+requests.getDonator().getUsername()+"    requestType: "+requests.getResourceType()+
                        "    requestAmount: "+requests.getAmount()+"    price: "+requests.getPrice()+
                        "    yourMessage: "+requests.getRequestMessage()+ "    donatorMessage: "+requests.getAcceptMessage();
                index++;
            }
        }
        result+="\nYou as Donator:";
        index=1;
        for(Requests requests: App.getCurrentUser().getListOfRequests()){
            if(index!=1) result+='\n';
            if(App.getCurrentUser().equals(requests.getDonator()) && requests.isThisRequestNew()){
                result+="Requester: "+requests.getOwner().getUsername()+"    requestType: "+requests.getResourceType()+
                        "    requestAmount: "+requests.getAmount()+"    price: "+requests.getPrice()+
                        "    requesterMessage: "+requests.getRequestMessage()+ "    yourMessage: "+requests.getAcceptMessage();
            }
            index++;
        }
        for(Requests requests: App.getCurrentUser().getListOfRequests()){
            requests.setThisRequestNew(false);
        }
        System.out.print(result);
    }
}
