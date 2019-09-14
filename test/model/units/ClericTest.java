package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
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

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }
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
    //System.out.print(unit1.items);
    unit1.exchangeItem(staff,unit2);
    //System.out.print(unit1.items);
    assertTrue(unit1.getItems().isEmpty());

    assertFalse(unit2.getItems().isEmpty());

  }
}