package design_pattern.docarator;

import design_pattern.duck.IDuck;
import util.Log;

public class BeautifulDuckDocarator extends DuckDocarator{

    public BeautifulDuckDocarator(IDuck duck) {
        super(duck);
    }

    @Override
    public void fly() {
        Log.d("beautiful swan fly!");
    }
}
