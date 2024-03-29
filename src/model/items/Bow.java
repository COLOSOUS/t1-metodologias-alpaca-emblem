package model.items;

import model.units.Archer;
import model.units.IUnit;

/**
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractItem {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }
  @Override

  public void equipBowTo(Archer unit) {
    unit.setEquippedBow(this);
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
    this.getOwner().receiveWeaknessAttack(item);
  }

  public void receiveMagicBookAttack(MagicBookLight item){
    this.getOwner().receiveWeaknessAttack(item);
  }

  public void receiveMagicBookAttack(MagicBookAnima item){
    this.getOwner().receiveWeaknessAttack(item);
  }
}
