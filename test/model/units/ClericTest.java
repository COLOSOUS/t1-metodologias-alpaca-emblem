package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Victor Durán
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }
  /**
   * Checks if the staff is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  /**
   * Checks if the staff is exchange correctly to the unit
   */
  @Test

  @Override

  public void exchangeStaffTest() {
    setTestUnit();
    Cleric unit1 =cleric;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(staff);
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());

    unit1.exchangeItem(staff,unit2);

    assertTrue(unit1.getItems().isEmpty());

    assertFalse(unit2.getItems().isEmpty());

  }
}