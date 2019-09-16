package model.units;

import model.items.IEquipableItem;
import model.items.Spear;
import model.map.Location;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {
  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Hero(int hitPoints, final int movement, final Location location,
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
    item.equipSpearTo(this);
  }
  @Override
  public void exchangeItem(IEquipableItem item, IUnit unit) {
    if(this.getLocation().isNeighbour(unit.getLocation())){
      if(this.getLocation().isNeighbour(unit.getLocation())){
        item.giveTo(unit);
        item.delete(this);
      }
    }
  }

  @Override
  public void attack(IUnit other){
    if (other.checkEquippedItem()) {
      IEquipableItem item = other.getEquippedItem();
      item.receiveSpearAttack((Spear) this.equippedItem);
    }
    else {
      IEquipableItem myitem=this.equippedItem;
      other.setEquippedItem(getbody());
      this.equippedItem=myitem;
      myitem.setOwner(this);
      IEquipableItem item2 = other.getEquippedItem();
      item2.setOwner(other);
      item2.receiveSpearAttack((Spear) this.equippedItem);
    }
  }
}
