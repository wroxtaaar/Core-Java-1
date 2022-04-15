package com.crio.session6.activity2;

public class WhatsappStatus implements Status {

    //The ConcreteCreator class which overrides the methods declared in the Creator class (Interfaces.Status).
    String viewGroup;
    View view;

    WhatsappStatus(){
        viewGroup = "public";
    }

    public void setViewGroup(String viewGroup){
        this.viewGroup = viewGroup;
    }

    public View save(){
        //to save the content of the Interfaces.Status, which is of type View.
        System.out.println("Your status has been saved in gallery!");
        return view;
    }

    public void publish(){
        //to share the status content with the world.
        System.out.println("Your status has been published!");
    }

    public void remove(){
        //to remove the status content.
        view = null;
        System.out.println("Your status has been removed!");
    }

    @Override
    public View createViewForStatus(String typeOfView, String content){


        //Factory method for instantiating an object which is of type View based on
        // the type of view to be created and its content.
        View view ;
        typeOfView = typeOfView.trim().toLowerCase();

        if(typeOfView.equals("image")){
            view = new ImageView(content);
        } else {
            if(typeOfView.equals("video")){
                view = new VideoView(content);
            }
            else if(typeOfView.equals("text")){
                view = new TextView(content);
            } else {
                view = null;
            }
        }

        return view;
    }
}
