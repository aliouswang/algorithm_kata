package design_pattern.docarator;

import design_pattern.duck.IDuck;
import design_pattern.duck.UglyDuck;

public class DocaratorTest {

    public static void main(String[] args) {
        IDuck iDuck = new UglyDuck();

        iDuck = new DuckDocarator(iDuck);
        iDuck = new BeautifulDuckDocarator(iDuck);

        iDuck.cry();
        iDuck.fly();
        iDuck.swim();
    }

}
