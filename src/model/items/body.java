package model.items;

public class body extends AbstractItem{

    public body(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }


    public IEquipableItem getbody() {
        AbstractItem body = new body("body", 0, 1, 1);
        return body;
    }
}
