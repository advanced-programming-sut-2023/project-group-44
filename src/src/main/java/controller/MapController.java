package controller;

import model.App;
import model.Block;

import java.util.regex.Matcher;

public class MapController {
    public static void showMap(int x, int y) {
        String map = "";
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 11; i++) {
                if (x - 6 + i >= 0 && y - 3 + j >= 0) {
                    map += "|" + mapObj(x - 6 + i - 1, y - 3 + j - 1);
                    if (i == 10) map += "|\n";
                }
            }
            for (int i = 0; i < 11; i++) {
                if (x - 6 + i >= 0 && y - 3 + j >= 0) {
                    map += "|######";
                    if (i == 10) map += "|\n";
                }
            }
            for (int i = 0; i < 11; i++) {
                if (x - 6 + i >= 0 && y - 3 + j >= 0) {
                    map += "|######";
                    if (i == 10) map += "|\n";
                }
            }
            for (int i = 0; i < 11; i++) {
                if (x - 6 + i >= 0 && y - 3 + j >= 0) {
                    map += "-------";
                }
            }
            map += "\n";
        }
        System.out.print(map);
    }

    public static String mapObj(int x, int y) {
        String map = "";
        if (App.gameMap.arrayOfBlocks[x][y].getBuilding() != null) map += "B";
        else if (App.gameMap.arrayOfBlocks[x][y].getTree() != null) map += "T";
        else map += "#";
        map += "#";
        if (!App.gameMap.arrayOfBlocks[x][y].getUnits().isEmpty()) map += "S";
        else map += "#";
        map += "#";
        if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("ground")) map += "GN";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("gravelGround")) map += "GG";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("rock")) map += "RO";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("stone")) map += "ST";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("iron")) map += "IR";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("grass")) map += "GR";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("grassland")) map += "GL";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("denseGrassland")) map += "DG";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("oil")) map += "OL";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("plain")) map += "PL";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("shallowWater")) map += "SW";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("river")) map += "RV";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("smallPond")) map += "SP";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("bigPond")) map += "BP";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("beach")) map += "BC";
        else if (App.gameMap.arrayOfBlocks[x][y].getTexture().equals("sea")) map += "SE";
        return map;
    }

    public static int moveMapX(Matcher matcher, String command, int x) {
        if (matcher.group("left") != null) {
            if (x - Integer.parseInt(matcher.group("left")) <= 0) x = 1;
            else x = x - Integer.parseInt(matcher.group("left"));
        }
        if (matcher.group("left") == null && command.contains("left")) {
            if (x - 1 <= 0) x = 1;
            else x = x - 1;
        }
        if (matcher.group("right") != null) {
            if (x + Integer.parseInt(matcher.group("right")) >= 400) x = 400;
            else x = x + Integer.parseInt(matcher.group("right"));
        }
        if (matcher.group("right") == null && command.contains("right")) {
            if (x + 1 >= 400) x = 400;
            else x = x + 1;
        }
        return x;
    }

    public static int moveMapY(Matcher matcher, String command, int y) {
        if (matcher.group("down") != null) {
            if (y - Integer.parseInt(matcher.group("down")) <= 0) y = 1;
            else y = y - Integer.parseInt(matcher.group("down"));
        }
        if (matcher.group("down") == null && command.contains("down")) {
            if (y - 1 <= 0) y = 1;
            else y = y - 1;
        }
        if (matcher.group("up") != null) {
            if (y + Integer.parseInt(matcher.group("up")) >= 400) y = 400;
            else y = y + Integer.parseInt(matcher.group("up"));
        }
        if (matcher.group("up") == null && command.contains("up")) {
            if (y + 1 >= 400) y = 400;
            else y = y + 1;
        }
        return y;
    }
}
