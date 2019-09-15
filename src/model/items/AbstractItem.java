package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name     the name of the item
   * @param power    the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange the minimum range of the item
   * @param maxRange the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }




  @Override
  public void setOwner(IUnit unit){
    this.owner=unit;
  }
  @Override
  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }

  public void giveTo(final IUnit unit) {


    if (unit.giveItem(this)) {


      owner = unit;
    }

  }

  public void delete(final IUnit unit) {
    unit.deleteItem(this);
  }

  @Override
  public void equipBowTo(final Archer unit) {
  }

  ;

  @Override
  public void equipSpearTo(final Hero unit) {
  }

  ;

  @Override
  public void equipStaffTo(final Cleric unit) {
  }

  ;

  @Override
  public void equipAxeTo(final Fighter unit) {
  }

  ;

  @Override
  public void equipSwordTo(final SwordMaster unit) {
  }

  ;


  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }


  @Override

  public void receiveBowAttack(Bow item) {
    this.getOwner().receiveAttack(item);

  }
  @Override

  public void receiveSpearAttack(Spear item) {
    this.getOwner().receiveAttack(item);

  }
  @Override

  public void receiveStaffAttack(Staff item) {
    this.getOwner().receiveHeal(item);

  }
  @Override
  public void receiveSwordAttack(Sword item) {
    this.getOwner().receiveAttack(item);

  }
  @Override

  public void receiveAxeAttack(Axe item) {
    this.getOwner().receiveAttack(item);

  }
  @Override
  public void receiveNormalAttack(IEquipableItem item) {

    this.getOwner().receiveAttack(item);

  }




}
