package model.units;

import model.items.Axe;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */

public class Fighter extends AbstractUnit {

  public Fighter(int hitPoints, final int movement, final Location location,
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
    item.equipAxeTo(this);
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
      item.receiveAxeAttack((Axe) this.equippedItem);

    }
    else {
      IEquipableItem myitem=this.equippedItem;

      other.setEquippedItem(getbody());

      this.equippedItem=myitem;
      myitem.setOwner(this);
      IEquipableItem item2 = other.getEquippedItem();

      item2.setOwner(other);

      item2.receiveAxeAttack((Axe) this.equippedItem);

    }

  }

}
