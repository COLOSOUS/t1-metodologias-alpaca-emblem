package model.items;

import model.map.Location;

import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for a magic book light
 *
 * @author Victor Duran
 * @since 1.0
 */
public class MagicBookLightTest extends AbstractTestItem {

  private MagicBookLight magicBooklight;
  private MagicBookLight wrongMagicBooklight;
  private Sorcerer sorcerer;

  @Override
  public void setTestItem() {
    expectedName = "Common magic book light";
    expectedPower = 15;
    expectedMinRange = 1;
    expectedMaxRange = 3;
    magicBooklight = new MagicBookLight(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongMagicBooklight = new MagicBookLight("Wrong magic book light", 0, -1, -2);
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
    return wrongMagicBooklight;
  }

  @Override
  public IEquipableItem getTestItem() {
    return magicBooklight;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }
}