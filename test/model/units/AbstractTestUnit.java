package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import model.items.*;

import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Victor Durán
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected MagicBookLight magickbookL;
  protected MagicBookDarkness magickbookD;
  protected MagicBookAnima magickbookA;
  protected Fighter fighter;
  protected Archer archer;
  protected Cleric cleric;
  protected Hero hero;
  protected SwordMaster swordmaster;
  protected Sorcerer sorcerer;


  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
    setUnits();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
            new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
            new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.magickbookA = new MagicBookAnima("BookA", 20, 1, 3);
    this.magickbookD = new MagicBookDarkness("BookD", 20, 1, 3);
    this.magickbookL = new MagicBookLight("BookL", 20, 1, 3);
  }

  /**
   * Sets up the units  to be tested
   */

  @Override
  public void setUnits() {
    this.fighter = new Fighter(50, 2, field.getCell(1, 1));
    this.archer = new Archer(50, 2, field.getCell(2, 2));
    this.swordmaster = new SwordMaster(50, 2, field.getCell(1, 0));
    this.cleric = new Cleric(50, 2, field.getCell(2, 2));
    this.hero = new Hero(50, 2, field.getCell(2, 1));
    this.sorcerer = new Sorcerer(40, 1, field.getCell(2, 1));
  }


  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }
  /**
   * Checks if the magic book animais equipped correctly to the unit
   */
  @Override
  @Test
  public void equipMagicBookAnimaTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getMagicBookAnima());
  }
  /**
   * Checks if the magic book darkness is equipped correctly to the unit
   */

  @Override
  @Test
  public void equipMagicBookDarknessTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getMagicBookDarknees());
  }
  /**
   * Checks if the magic book light is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipMagicBookLightTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getMagicBookLight());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item to be equipped
   */
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * Tries to exchange a weapon to  new unit
   *
   * @param item to be equipped
   * @param unit new owner
   */

  public void checkExchangeItem(IEquipableItem item, IUnit unit) {
    assertTrue(unit.getItems().isEmpty());
    getTestUnit().giveItem(item);
    getTestUnit().exchangeItem(item, unit);
    assertFalse(unit.getItems().isEmpty());

  }
  /**
   * Tries to attack a  to  new unit with a weapon
   *
   * @param item to be equipped
   * @param unit new owner
   */

  public void attackTest(IUnit unit, IUnit other, IEquipableItem item) {
    item.setOwner(unit);
    unit.equipItem(item);
    unit.attackto(other);
  }
  /**
   * Attack a swordmaster with a sword
   */


  @Override
  @Test

  public void attackSwordmasterTest() {
    attackTest(getSwordMaster(), getTestUnit(), getSword());
  }
  /**
   * Attack a archer with a bow
   */

  @Override
  @Test
  public void attackArcherTest() {
    attackTest(getArcher(), getTestUnit(), getBow());
  }
  /**
   * Heal a cleric with a Staff
   */


  @Override
  @Test
  public void attackClericTest() {
    attackTest(getCleric(), getTestUnit(), getStaff());
  }

  /**
   * Attack a fighter with a axe
   */


  @Override
  @Test
  public void attackFighterTest() {
    attackTest(getFighter(), getTestUnit(), getAxe());
  }
  /**
   * Attack a hero with a spear
   */
  @Override
  @Test
  public void attackHeroTest() {
    attackTest(getHero(), getTestUnit(), getSpear());
  }

  /**
   * Attack a Sorcecer with a  MagicBookAnima
   */

  @Override
  @Test
  public void attackSorcecer1Test() {
    attackTest(getSorcecer(), getTestUnit(), getMagicBookAnima());
  }
  /**
   * Attack a Sorcecer with a  MagicBookDarkness
   */


  @Override
  @Test
  public void attackSorcecer2Test() {
    attackTest(getSorcecer(), getTestUnit(), getMagicBookDarknees());
  }
  /**
   * Attack a Sorcecer with a  MagicBookLight
   */


  @Override
  @Test
  public void attackSorcecer3Test() {
    attackTest(getSorcecer(), getTestUnit(), getMagicBookLight());
  }

/*//////////////////////////*/

  /**
   * Sets up the units and weapons  to be tested  again in combat
   */

  @BeforeEach
  public void setUp2() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons2();
    setUnits2();

  }

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons2() {
    this.axe = new Axe("Axe2", 5, 1, 2);
    this.sword = new Sword("Sword2", 10, 1, 1);
    this.spear = new Spear("Spear2", 12, 1, 2);
    this.staff = new Staff("Staff2", 9, 1, 1);
    this.bow = new Bow("Bow2", 4, 2, 3);
    this.magickbookA = new MagicBookAnima("BookA", 20, 1, 3);
    this.magickbookD = new MagicBookDarkness("BookD", 20, 1, 3);
    this.magickbookL = new MagicBookLight("BookL", 20, 1, 3);
  }
  /**
   * Creates a set of testing units
   */

  @Override
  public void setUnits2() {
    this.fighter = new Fighter(50, 2, field.getCell(1, 2), axe);
    this.archer = new Archer(50, 2, field.getCell(1, 1), bow);
    this.swordmaster = new SwordMaster(50, 2, field.getCell(1, 2), sword);
    this.cleric = new Cleric(50, 2, field.getCell(2, 2), staff);
    this.hero = new Hero(50, 2, field.getCell(2, 1), spear);
    this.sorcerer = new Sorcerer(40, 1, field.getCell(2, 1));
  }
  /**
   * Tries to equip two weapon to two units
   * @param unit first unit
   * @param other second unit
   * @param item1 to be equipped
   * @param item1 to be equipped
   */

  public void attackTest2(IUnit unit, IUnit other, IEquipableItem item1, IEquipableItem item2) {

    unit.equipItem(item1);
    other.equipItem(item2);

    item1.setOwner(unit);
    item2.setOwner(other);


    unit.attackto(other);
  }
  /**
   * Combat between swordmaster and archer
   */

  @Override
  @Test

  public void attackSwordmasterTest2() {
    attackTest2(getSwordMaster(), getArcher(), getSword(), getBow());
  }
  /**
   * Combat between archer and cleric
   */
  @Override
  @Test
  public void attackArcherTest2() {
    attackTest2(getArcher(), getCleric(), getBow(), getStaff());
  }
  /**
   * Combat between cleric  and fighter
   */
  @Override
  @Test
  public void attackClericTest2() {
    attackTest2(getCleric(), getFighter(), getStaff(), getAxe());
  }
  /**
   * Combat between fighter and hero
   */
  @Override
  @Test
  public void attackFighterTest2() {
    attackTest2(getFighter(), getHero(), getAxe(), getSpear());
  }
  /**
   * Combat between hero and swordmaster
   */
  @Override
  @Test
  public void attackHeroTest2() {
    attackTest2(getHero(), getSwordMaster(), getSpear(), getSword());
  }
  /**
   * Combat between Sorcecer and swordmaster
   */
  @Override
  @Test
  public void attackSorcecer1Test2() {
    attackTest2(getSorcecer(), getSwordMaster(), getMagicBookAnima(), getSword());
  }
  /**
   * Combat between hero and Sorcecer
   */
  @Override
  @Test
  public void attackSorcecer2Test2() {
    attackTest2(getHero(), getSorcecer(), getSpear(), getMagicBookDarknees());
  }
  /**
   * Combat between Sorcecer and archer
   */
  @Override
  @Test
  public void attackSorcecer3Test2() {
    attackTest2(getSorcecer(), getArcher(), getMagicBookLight(), getBow());
  }


  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }


  /**
   * @return the test magickbookA
   */
  @Override
  public MagicBookAnima getMagicBookAnima() {
    return magickbookA;
  }

  /**
   * @return the test magickbookD
   */
  @Override
  public MagicBookDarkness getMagicBookDarknees() {
    return magickbookD;
  }


  @Override
  public MagicBookLight getMagicBookLight() {
    return magickbookL;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }


  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }
  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }



  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }


  @Override
  @Test
  public void exchangeBowTest() {
    checkExchangeItem(getBow(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeAxeTest() {
    checkExchangeItem(getAxe(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeSpearTest() {
    checkExchangeItem(getSpear(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeStaffTest() {
    checkExchangeItem(getStaff(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeSwordTest() {
    checkExchangeItem(getSword(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeMagicBookAnimaTest() {
    checkExchangeItem(getMagicBookAnima(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeMagicBookDarknessTest() {
    checkExchangeItem(getMagicBookDarknees(), getTestUnit());
  }

  @Override
  @Test
  public void exchangeMagicBookLightTest() {
    checkExchangeItem(getMagicBookLight(), getTestUnit());
  }



  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }



  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }
  /**
   * @return the archer
   */
  @Override
  public Archer getArcher() {
    return archer;
  }
  /**
   * @return the swordmaster
   */
  @Override
  public SwordMaster getSwordMaster() {
    return swordmaster;
  }
  /**
   * @return the hero
   */
  @Override
  public Hero getHero() {
    return hero;
  }
  /**
   * @return the sorcecer
   */
  @Override
  public Sorcerer getSorcecer() {
    return sorcerer;
  }
  /**
   * @return the cleric
   */
  @Override
  public Cleric getCleric() {
    return cleric;
  }
  /**
   * @return the fighter
   */
  @Override
  public Fighter getFighter() {
    return fighter;
  }
}



