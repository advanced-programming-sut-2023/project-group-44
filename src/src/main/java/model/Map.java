package model;

import java.util.ArrayList;

public class Map {
    private int lengthOfMap;
    public Block [][] arrayOfBlocks;
    public Map(int lengthOfMap){
        this.lengthOfMap=lengthOfMap;
        this.arrayOfBlocks=new Block[lengthOfMap][lengthOfMap];
        for(int i=0;i<lengthOfMap;i++){
            for(int j=0;j<lengthOfMap;j++){
                Block newblock=new Block(i,j);
                newblock.setTexture("ground");
                arrayOfBlocks[i][j]=newblock;
            }
        }
    }
    public Block getBlock(int x,int y){
        return arrayOfBlocks[x][y];
    }

    public int getLengthOfMap() {
        return lengthOfMap;
    }
}
