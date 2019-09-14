package model.combat;

import model.units.IUnit;

public interface ICombat {
    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other
     *     Pokémon that receives the attack.
     */
    void attack(IUnit other);

    /**
     * Getter for the base damage.
     *
     * @return Base damage of the attack.
     */
    int getBaseDamage();

    /**
     * Getter for the attack's name.
     *
     * @return Name of the attack.
     */
    String getName();



}
