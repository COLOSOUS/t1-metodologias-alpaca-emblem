package model.items;

import model.units.Fighter;
import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipAxeTo(Fighter unit) {
    unit.setEquippedAxe(this);
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
    this.getOwner().receiveResistantAttack(item);
  }



  @Override
  public void receiveStaffAttack(Staff item){
    this.getOwner().receiveHeal(item);
  }
  @Override
  public void receiveSwordAttack(Sword  item){
    this.getOwner().receiveWeaknessAttack(item);
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
