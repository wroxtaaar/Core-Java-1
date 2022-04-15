package com.crio.session6.activity2;

public interface Status {

    //The Creator which declares the factory method returning an object of type View.

    int duration = 30;

    public View save();
    public void publish();
    public void remove();

    //factory method
    public View createViewForStatus(String typeOfView, String content);

}
