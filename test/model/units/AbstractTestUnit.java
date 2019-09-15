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
 * @author Ignacio Slater Muñoz
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
  protected Fighter fighter;
  protected Archer archer;
  protected Cleric cleric;
  protected Hero hero;
  protected SwordMaster swordmaster;


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
  }
  @Override
  public void setUnits() {
    this.fighter = new Fighter(50, 2, field.getCell(1, 0));
    this.archer = new Archer(50, 2, field.getCell(1, 0));
    this.swordmaster = new SwordMaster(50, 2, field.getCell(1, 0));
    this.cleric = new Cleric(50, 2, field.getCell(1, 0));
    this.hero= new Hero(50, 2, field.getCell(1, 0));
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
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());

    getTestUnit().equipItem(item);

    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * Tries to equip a weapon to  new unit
   *
   * @param item
   *     to be equipped
   * @param unit
   * new owner
   */

  public void checkExchangeItem(IEquipableItem item,IUnit unit) {
    assertTrue(unit.getItems().isEmpty());
    getTestUnit().giveItem(item);
    getTestUnit().exchangeItem(item,unit);
    assertFalse(unit.getItems().isEmpty());

  }

  public void attackTest(IUnit unit,IUnit other,IEquipableItem item){
    unit.equipItem(item);
    unit.attackto(other);
  }
  @Override
  @Test

  public void attackSwordmasterTest(){
    attackTest(getSwordMaster(),getTestUnit(),getSword());
  }
  @Override
  @Test
  public void attackArcherTest(){
    attackTest(getArcher(),getTestUnit(),getBow());
  }
  @Override
  @Test
  public void attackClericTest(){
    attackTest(getCleric(),getTestUnit(),getStaff());
  }
  @Override
  @Test
  public void attackFighterTest(){
    attackTest(getFighter(),getTestUnit(),getAxe());
  }
  @Override
  @Test
  public void attackHeroTest(){
    attackTest(getHero(),getTestUnit(),getSpear());
  }





  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
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

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  @Override
  @Test
  public void exchangeBowTest() {
    checkExchangeItem(getBow(),getTestUnit());
  }

  @Override
  @Test
  public void exchangeAxeTest() {
    checkExchangeItem(getAxe(),getTestUnit());
  }
  @Override
  @Test
  public void exchangeSpearTest() {
    checkExchangeItem(getSpear(),getTestUnit());
  }

  @Override
  @Test
  public void exchangeStaffTest() {
    checkExchangeItem(getStaff(),getTestUnit());
  }

  @Override
  @Test
  public void exchangeSwordTest() {
    checkExchangeItem(getSword(),getTestUnit());
  }

  /*@Override
  @Test
  public void exchangeMagicbookTest() {
    checkExchangeItem(getBow(),getTestUnit());
  }*/



  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
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
   * @return the item being tested
   */


  public void checkWrong1ExchangeItem(IEquipableItem item,IUnit unit) {
    assertTrue(getTestUnit().getItems().isEmpty());
    getTestUnit().moveTo(getField().getCell(2, 2));
    getTestUnit().exchangeItem(item,unit);
    assertTrue(getTestUnit().getItems().isEmpty());

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

  @Override
  public Archer getArcher() {
    return archer;
  }
  @Override
  public SwordMaster getSwordMaster() {
    return swordmaster;
  }
  @Override
  public Hero getHero() {
    return hero;
  }

  @Override
  public Cleric getCleric() {
    return cleric;
  }
  @Override
  public Fighter getFighter() {
    return fighter;
  }


}
