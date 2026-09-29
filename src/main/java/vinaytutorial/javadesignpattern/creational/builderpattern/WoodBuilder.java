package vinaytutorial.javadesignpattern.creational.builderpattern;

public class WoodBuilder extends HouseBuilder {
    @Override
    public House createHouse() {

        house = new WoodHouse();
        return house;
    }
}
