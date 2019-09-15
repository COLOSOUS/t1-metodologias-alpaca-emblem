package model.items;

import model.units.Sorcerer;

public class MagicBookLight extends MagicBook {
    /**
     * Creates a new bow.
     * <p>
     * Magic Books are weapons that can attack  units with light magic that have a large range
     *
     * @param name
     *     the name of the Magic Book
     * @param power
     *     the damage power of the Magic Book
     * @param minRange
     *     the minimum range of the Magic Book
     * @param maxRange
     *     the maximum range of the Magic Book
     */

    public MagicBookLight(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipMagicBookTo(Sorcerer unit) {unit.setEquippedMagicBook(this);
    }
    @Override
    public void receiveBowAttack(Bow item){
        this.getOwner().receiveWeaknessAttack(item);

    }
    @Override
    public void receiveAxeAttack(Axe item){
        this.getOwner().receiveWeaknessAttack(item);
    }
    @Override
    public void receiveSpearAttack(Spear item){
        this.getOwner().receiveWeaknessAttack(item);
    }

    @Override
    public void receiveStaffAttack(Staff item){
        this.getOwner().receiveHeal(item);
    }
    @Override
    public void receiveSwordAttack(Sword  item){
        this.getOwner().receiveWeaknessAttack(item);
    }
    @Override
    public void receiveMagicBookAttack(MagicBookDarkness item){
        this.getOwner().receiveResistantAttack(item);
    }
    @Override
    public void receiveMagicBookAttack(MagicBookLight item){
        this.getOwner().receiveAttack(item);
    }
    @Override
    public void receiveMagicBookAttack(MagicBookAnima item){
        this.getOwner().receiveWeaknessAttack(item);
    }

}
