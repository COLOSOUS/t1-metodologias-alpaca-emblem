package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Victor Durán
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   */
  void equipItem(IEquipableItem item);
    /**
     * Sets the currently equipped item of this unit by other unit.
     *
     * @param item
     *     the item to equip
     * @param unit
     *  new owner
     */

    void exchangeItem(IEquipableItem item, IUnit unit);

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);
  /**
   * @param item
   *     the item to be save
   */
  boolean giveItem(IEquipableItem item);
  /**
   * @param item
   *     the item to be delete
   */
  void deleteItem(IEquipableItem item);
  /**
   * @param item
   *     the bow to be equipped
   */
  void setEquippedBow(final Bow item);
  /**
   * @param item
   *     the Staff to be equipped
   */
  void setEquippedStaff(final Staff item);
  /**
   * @param item
   *     the Axe to be equipped
   */
  void setEquippedAxe(final Axe item);
  /**
   * @param item
   *     the Spear to be equipped
   */
  void setEquippedSpear(final Spear item);
  /**
   * @param item
   *     the Sword to be equipped
   */
  void setEquippedSword(final Sword item);
  /**
   * @param item
   *     the MagicBook to be equipped
   */
  void setEquippedMagicBook(final MagicBook item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);
  /**
   * Attacks another unit.
   *
   * @param other
   *     Target of the attack.
   */


  void attack(IUnit other);
  /**
   * Combat between units with counter attack
   *
   * @param other
   *     Target of the attack.
   */
  void attackto(IUnit other);

  /**
   * heal with a item.
   *
   * @param item
   *
   */
  void receiveHeal(IEquipableItem item);
  /**
   * make damage with a item.
   *
   * @param item
   *
   */

  void receiveAttack(IEquipableItem item);
  /**
   * make damage with a item strong to the target
   *
   * @param item
   *
   */
  void receiveWeaknessAttack(IEquipableItem item);
  /**
   * make damage with a item weak to the target
   *
   * @param item
   *
   */
  void receiveResistantAttack(IEquipableItem item);
  /**
   * check if have a item
   *
   */
  boolean checkEquippedItem();



}
