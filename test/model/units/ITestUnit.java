package model.units;


import model.items.*;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface ITestUnit {

  /**
   * Set up the game field
   */
  void setField();

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

  void setTargetAlpaca();

  /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  @Test
  void attackSorcecer1Test();

  @Test
  void attackSorcecer2Test();

  @Test
  void attackSorcecer3Test();

  /**
   * Creates a new set of testing weapons
   */
  void setWeapons2();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipAxeTest();

  @Test
  void equipMagicBookAnimaTest();

  @Test
  void equipMagicBookDarknessTest();

  @Test
  void equipMagicBookLightTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  void checkEquippedItem(IEquipableItem item);

  @Test
  void attackSorcecer1Test2();

  @Test
  void attackSorcecer2Test2();

  /**
   * Tries to equip a weapon to new unit
   *
   * @param item
   *     to be equipped
   * @param unit
   * new owner
   */
  void checkExchangeItem(IEquipableItem item,IUnit unit);

  @Test
  void attackSorcecer3Test2();

  /**
   * @return the test axe
   */
  Axe getAxe();



  MagicBookAnima getMagicBookAnima();

  MagicBookDarkness getMagicBookDarknees();

  MagicBookLight getMagicBookLight();

  @Test
  void equipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  @Test
  void equipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();


  @Test
  void equipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  Fighter getFighter();

    Sorcerer getSorcecer();

    Cleric getCleric();
  Hero getHero();
  SwordMaster getSwordMaster();
  Archer getArcher();
  @Test
  void equipBowTest();
  /**
   * Try exchange between units
   */


  @Test
  void exchangeAxeTest();
  @Test
  void exchangeSpearTest();
  @Test
  void exchangeStaffTest();
  @Test
  void exchangeSwordTest();
  @Test
  void exchangeBowTest();
  @Test

  void attackFighterTest();
  @Test
  void attackHeroTest();
  @Test
  void attackClericTest();
  @Test
  void attackArcherTest();
  @Test
  void attackSwordmasterTest();

  @Test

  void attackFighterTest2();


  @Test
  void attackClericTest2();
  @Test
  void attackArcherTest2();
  @Test
  void attackSwordmasterTest2();

  @Test
  void setUnits();
  @Test
  void setUnits2();

  @Test
  void exchangeMagicBookAnimaTest();

  @Test
  void exchangeMagicBookDarknessTest();

  @Test
  void exchangeMagicBookLightTest();

  /**
   * @return the test bow
   */
  Bow getBow();

  /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();
}
