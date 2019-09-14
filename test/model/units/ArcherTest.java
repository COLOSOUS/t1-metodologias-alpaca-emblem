package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(archer.getEquippedItem());
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());


  }
  @Test

  @Override

  public void exchangeBowTest() {
    setTestUnit();
    Archer unit1 =archer;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(bow);
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(bow,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }



}