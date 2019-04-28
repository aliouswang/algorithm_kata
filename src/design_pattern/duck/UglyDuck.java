package design_pattern.duck;

import util.Log;

public class UglyDuck implements IDuck{
    @Override
    public void cry() {
        Log.d("ugly duck cry!");
    }

    @Override
    public void fly() {
        Log.d("ugly duck can't fly!");
    }

    @Override
    public void swim() {
        Log.d("ugly duck swim!");
    }
}
