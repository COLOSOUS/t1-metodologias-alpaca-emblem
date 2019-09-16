package model.units;

import model.items.IEquipableItem;
import model.items.Staff;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Cleric(int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  @Override
  public void equipItem(final IEquipableItem item) {
    item.equipStaffTo(this);
  }
  @Override
  public void exchangeItem(IEquipableItem item, IUnit unit) {
    if(this.getLocation().isNeighbour(unit.getLocation())){
      item.giveTo(unit);
      item.delete(this);
    }

  }
  @Override

  public void attack(IUnit other){
    if (other.checkEquippedItem()) {


      IEquipableItem item = other.getEquippedItem();
      item.receiveStaffAttack((Staff) this.equippedItem);


    }
    else {
      IEquipableItem myitem=this.equippedItem;

      other.setEquippedItem(getbody());

      this.equippedItem=myitem;
      myitem.setOwner(this);
      IEquipableItem item2 = other.getEquippedItem();

      item2.setOwner(other);

      item2.receiveStaffAttack((Staff) this.equippedItem);

    }

  }



}
