package com.crio.session6.activity2;

abstract public class View implements Media{

    //The Product class which defines the type of objects that the factory method creates.

    //constants
    private static final float MATCH_PARENT_WIDTH = 300.5f;
    private static final float MATCH_PARENT_HEIGHT = 600.10f;

    //attributes
    float width, height;

    View() {

        //default settings
        this.width = MATCH_PARENT_WIDTH;
        this.height = MATCH_PARENT_HEIGHT;

    }

    public void setSize(float height, float width) {

        //to set the width and height.
        this.width = width;
        this.height = height;

    }
}
