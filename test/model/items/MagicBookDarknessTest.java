package model.items;

import model.map.Location;

import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for a magic book dark
 *
 * @author Victor Durán
 * @since 1.0
 */
public class MagicBookDarknessTest extends AbstractTestItem {

  private MagicBookDarkness magicBookdark;
  private MagicBookDarkness wrongMagicBookdark;
  private Sorcerer sorcerer;

  @Override
  public void setTestItem() {
    expectedName = "Common magic book dark";
    expectedPower = 15;
    expectedMinRange = 1;
    expectedMaxRange = 3;
    magicBookdark = new MagicBookDarkness(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongMagicBookdark = new MagicBookDarkness("Wrong magic book dark", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    sorcerer = new Sorcerer(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongMagicBookdark;
  }

  @Override
  public IEquipableItem getTestItem() {
    return magicBookdark;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }
}
