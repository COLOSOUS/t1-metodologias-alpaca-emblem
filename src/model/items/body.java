package model.items;

import model.units.IUnit;

public class body extends AbstractItem{

    public body(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }


    public IEquipableItem getsdsbody() {
        IEquipableItem body = new body("body", 0, 1, 1);
        body.equipTo((IUnit) this);
        return body;
    }

    @Override
    public void receiveBowAttack(Bow item){

        this.getOwner().receiveAttack(item);


    }
    @Override
    public void receiveAxeAttack(Axe item){
        this.getOwner().receiveAttack(item);
    }
    @Override
    public void receiveSpearAttack(Spear item){
        this.getOwner().receiveAttack(item);
    }






    @Override
    public void receiveStaffAttack(Staff item){
        this.getOwner().receiveHeal(item);
    }
    @Override
    public void receiveSwordAttack(Sword  item){
        this.getOwner().receiveAttack(item);
    }

    public void receiveMagicBookAttack(MagicBookDarkness item){
        this.getOwner().receiveAttack(item);
    }

    public void receiveMagicBookAttack(MagicBookLight item){
        this.getOwner().receiveAttack(item);
    }

    public void receiveMagicBookAttack(MagicBookAnima item){
        this.getOwner().receiveAttack(item);
    }


}
