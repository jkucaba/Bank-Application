package com.jakubku.mazebank.mazebank.models;

import com.jakubku.mazebank.mazebank.views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private Model(){
        this.viewFactory = new ViewFactory();
    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}
