package model.items;

import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
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

  void equipBowTo(Archer archer);

  void equipSpearTo(Hero hero);

  void equipSwordTo(SwordMaster swordMaster);

  void equipAxeTo(Fighter fighter);

  void equipStaffTo(Cleric cleric);


  /**

   * Receives damage from a item.

   *

   * @param item

   *     Received attack.

   */

  void receiveAxeAttack(Axe item);

  void receiveStaffAttack(Staff item);

  void receiveSwordAttack(Sword item);
















  /**

   * Receives damage from a item.

   *

   * @param item

   *     Received attack.

   */

  void receiveBowAttack(Bow item);



  /**

   * Receives damage from a item.

   *

   * @param item

   *     Received attack.

   */

  void receiveSpearAttack(Spear item);



  /**

   * Receives damage from a item.

   *

   * @param item

   *     Received attack.

   */



  void receiveNormalAttack(IEquipableItem item);
  // getbody();

  void setOwner(IUnit unit);

}
