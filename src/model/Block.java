package model;

import model.Buildings.Building;

public class Block {
    int x, y;
    private String texture;
    private Object object;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
