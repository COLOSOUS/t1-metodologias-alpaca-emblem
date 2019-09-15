package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private  int currentHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;


  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  public IEquipableItem getbody() {
    IEquipableItem body = new body("body", 0, 1, 1);
    body.equipTo(this);
    return body;
  }



  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public boolean checkEquippedItem() {
    if (this.equippedItem!=null){
      System.out.println("si tiene");
      return true;
    }
    System.out.println("no tiene");
    return false;
  }



  @Override
  public void setEquippedItem(IEquipableItem item) { this.equippedItem = item;    }


  @Override
  public boolean giveItem(final IEquipableItem item) {

      if (this.items.add(item)){

          //System.out.print(this.items);
          return true;
      }
      return false;
  }
  @Override
  public void deleteItem(final IEquipableItem item) {
    this.items.remove(item);
  }


  @Override
  public void setEquippedBow(final Bow item) {
    this.equippedItem = item;
  }
  @Override
  public void setEquippedStaff(final Staff item) {
    this.equippedItem = item;
  }
  @Override
  public void setEquippedAxe(final Axe item) {
    this.equippedItem = item;
  }
  @Override
  public void setEquippedSpear(final Spear item) {
    this.equippedItem = item;
  }
  @Override
  public void setEquippedSword(final Sword item) { this.equippedItem = item; }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }





  @Override
  public void receiveWeaknessAttack(IEquipableItem item) {

    this.currentHitPoints -= item.getPower()*1.5;

  }
  @Override
  public void receiveResistantAttack(IEquipableItem item) {

    this.currentHitPoints -= item.getPower()-20;

  }

  @Override
  public void receiveAttack(IEquipableItem item) {


    this.currentHitPoints -= item.getPower();

  }
  @Override
  public void receiveHeal(IEquipableItem item) {

    this.currentHitPoints += item.getPower();

  }

  @Override
  public void attackto(IUnit other) {
    this.attack(other);
    if (other.getEquippedItem()!=null && !(other.getEquippedItem() instanceof Staff) && !(other.getEquippedItem() instanceof body)){
      other.attack(this);
    }
  }



}
