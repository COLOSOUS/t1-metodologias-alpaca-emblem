package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(axe);
    assertEquals(axe, fighter.getEquippedItem());
  }

  /**
   * Checks if the axe is exchange correctly  to the unit
   */

  @Test

  @Override

  public void exchangeAxeTest() {
    setTestUnit();
    Fighter unit1 =fighter;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(axe);
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(axe,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }
}