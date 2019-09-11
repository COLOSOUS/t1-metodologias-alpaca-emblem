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
 * @author Ignacio Slater Muñoz
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
  void setEquippedBow(final Bow item);
  void setEquippedStaff(final Staff item);
  void setEquippedAxe(final Axe item);
  void setEquippedSpear(final Spear item);
  void setEquippedSword(final Sword item);

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
}
