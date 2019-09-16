package model.items;

import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Victor Durán
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);
  /**
   * Give this item to a unit.
   *
   * @param unit
   *     the unit that has the item
   */
  void giveTo(IUnit unit);
  /**
   * delete this item to a unit.
   *
   * @param unit
   *     the unit that has the item
   */
  void delete(IUnit unit);





  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();
  /**
   * equip a item to a unit.
   *
   * @param archer
   *     the unit that has the item
   */

  void equipBowTo(Archer archer);
  /**
   * equip a item to a unit.
   *
   * @param hero
   *     the unit that has the item
   */

  void equipSpearTo(Hero hero);
  /**
   * equip a item to a unit.
   *
   * @param swordMaster
   *     the unit that has the item
   */

  void equipSwordTo(SwordMaster swordMaster);
  /**
   * equip a item to a unit.
   *
   * @param fighter
   *     the unit that has the item
   */

  void equipAxeTo(Fighter fighter);
  /**
   * equip a item to a unit.
   *
   * @param cleric
   *     the unit that has the item
   */

  void equipStaffTo(Cleric cleric);
  /**
   * equip a item to a unit.
   *
   * @param unit
   *     the unit that has the item
   */
  void equipMagicBookTo(Sorcerer unit);


  /**
   * Receives damage from a axe.
   *
   * @param item
   *     Received attack.
   */

  void receiveAxeAttack(Axe item);
  /**
   * Receives heal from a staff.
   *
   * @param item
   *     Received attack.
   */

  void receiveStaffAttack(Staff item);
  /**
   * Receives damage from a sword.
   *
   * @param item
   *     Received attack.
   */

  void receiveSwordAttack(Sword item);
  /**
   * Receives damage from a magick book.
   *
   * @param item
   *     Received attack.
   */
  void receiveMagicBookAttack(MagicBook item);
  /**
   * Receives damage from a bow.
   *
   * @param item
   *     Received attack.
   */

  void receiveBowAttack(Bow item);
  /**
   * Receives damage from a spear.
   *
   * @param item
   *     Received attack.
   */
  void receiveSpearAttack(Spear item);
  /**
   * Give property to a unit.
   * @param unit

   */

  void setOwner(IUnit unit);










}
