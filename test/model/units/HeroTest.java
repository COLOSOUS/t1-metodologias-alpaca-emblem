package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Victor Durán
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }
  /**
   * Checks if the spear is equipped correctly to the unit
   */

  @Override
  @Test
  public void equipSpearTest() {
    assertNull(hero.getEquippedItem());
    hero.equipItem(spear);
    assertEquals(spear, hero.getEquippedItem());
  }
  /**
   * Checks if the spear is exchange correctly to the unit
   */


  public void exchangeSpearTest() {
    setTestUnit();
    Hero unit1 =hero;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(spear);
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(spear,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }
}