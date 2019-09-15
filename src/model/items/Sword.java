package model.items;

import model.units.IUnit;
import model.units.SwordMaster;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractItem {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipSwordTo(SwordMaster unit) {
    unit.setEquippedSword(this);
  }

  @Override
  public void receiveBowAttack(Bow item){
    this.getOwner().receiveAttack(item);
  }
  @Override
  public void receiveAxeAttack(Axe item){
    this.getOwner().receiveResistantAttack(item);
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
