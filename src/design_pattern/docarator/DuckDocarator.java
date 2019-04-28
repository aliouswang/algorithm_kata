package design_pattern.docarator;

import design_pattern.duck.IDuck;
import util.Log;

public class DuckDocarator implements IDuck {

    private IDuck duck;

    public DuckDocarator(IDuck duck) {
        this.duck = duck;
    }

    @Override
    public void cry() {
        Log.d("swan cry");
    }

    @Override
    public void fly() {
        Log.d("swan fly");
    }

    @Override
    public void swim() {
        Log.d("swan swim");
    }
}
