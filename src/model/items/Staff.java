package model.items;

import model.units.Cleric;
import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractItem {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipStaffTo(Cleric unit) {    unit.setEquippedStaff(this);
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
