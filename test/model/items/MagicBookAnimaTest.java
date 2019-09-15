package model.items;

import model.map.Location;
import model.units.Sorcerer;
import model.units.IUnit;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class MagicBookAnimaTest extends AbstractTestItem {

  private MagicBookAnima magicBookAnima;
  private MagicBookAnima wrongMagicBookAnima;
  private Sorcerer sorcerer;

  @Override
  public void setTestItem() {
    expectedName = "Common magic book anima";
    expectedPower = 15;
    expectedMinRange = 1;
    expectedMaxRange = 3;
    magicBookAnima = new MagicBookAnima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongMagicBookAnima = new MagicBookAnima("Wrong magic book anima", 0, -1, -2);
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
    return wrongMagicBookAnima;
  }

  @Override
  public IEquipableItem getTestItem() {
    return magicBookAnima;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }
}