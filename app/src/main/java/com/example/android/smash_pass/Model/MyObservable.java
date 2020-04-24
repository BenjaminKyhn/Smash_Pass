package com.example.android.smash_pass.Model;

import java.util.ArrayList;

public class MyObservable {
    private ArrayList<MyObserver> myObservers;

    public MyObservable() {
        myObservers = new ArrayList<>();
    }

    public void addObserver(MyObserver myObserver) {
        if (!myObservers.contains(myObserver))
            myObservers.add(myObserver);
    }

    public void notifyObservers(Object o){
        for (MyObserver myObserver : myObservers)
            myObserver.update(o);
    }
}
