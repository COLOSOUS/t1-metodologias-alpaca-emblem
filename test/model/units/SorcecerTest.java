package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Sorcecer unit.
 *
 * @author Victor Durán
 * @since 1.0
 */
public class SorcecerTest extends AbstractTestUnit {

  private Sorcerer sorcerer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }

  /**
   * Checks if the magic book is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipMagicBookAnimaTest() {
    assertNull(sorcerer.getEquippedItem());
    sorcerer.equipItem(magickbookA);
    assertEquals(magickbookA, sorcerer.getEquippedItem());


  }
  /**
   * Checks if the magic book is exchange correctly to the unit
   */
  @Test

  @Override

  public void exchangeMagicBookAnimaTest() {
    setTestUnit();
    Sorcerer unit1 =sorcerer;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(getMagicBookAnima());
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(magickbookA,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }
  /**
   * Checks if the magic book is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipMagicBookDarknessTest() {
    assertNull(sorcerer.getEquippedItem());
    sorcerer.equipItem(magickbookD);
    assertEquals(magickbookD, sorcerer.getEquippedItem());


  }
  /**
   * Checks if the magic book is exchange correctly to the unit
   */
  @Test

  @Override

  public void exchangeMagicBookDarknessTest() {
    setTestUnit();
    Sorcerer unit1 =sorcerer;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(getMagicBookDarknees());
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(magickbookD,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }
  /**
   * Checks if the magic book is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipMagicBookLightTest() {
    assertNull(sorcerer.getEquippedItem());
    sorcerer.equipItem(magickbookL);
    assertEquals(magickbookL, sorcerer.getEquippedItem());


  }
  /**
   * Checks if the magick book is exchange correctly to the unit
   */
  @Test

  @Override

  public void exchangeMagicBookLightTest() {
    setTestUnit();
    Sorcerer unit1 =sorcerer;
    assertTrue(unit1.getItems().isEmpty());
    unit1.items.add(getMagicBookLight());
    setTargetAlpaca();
    IUnit unit2 =getTargetAlpaca();
    assertTrue(unit2.getItems().isEmpty());
    unit1.exchangeItem(magickbookL,unit2);
    assertTrue(unit1.getItems().isEmpty());
    assertFalse(unit2.getItems().isEmpty());

  }
  





}