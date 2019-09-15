package model.items;

import model.units.Hero;
import model.units.IUnit;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Spear extends AbstractItem {

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
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipSpearTo(Hero unit) {
    unit.setEquippedSpear(this);
  }
  @Override
  public void receiveBowAttack(Bow item){
    this.receiveNormalAttack(this);
  }
  @Override
  public void receiveAxeAttack(Axe item){
    this.receiveNormalAttack(this);
  }
  @Override
  public void receiveSpearAttack(Spear item){
    this.receiveNormalAttack(this);
  }
  @Override
  public void receiveStaffAttack(Staff item){
    this.receiveNormalAttack(this);
  }
  @Override
  public void receiveSwordAttack(Sword  item){
    this.receiveNormalAttack(this);
  }
}
