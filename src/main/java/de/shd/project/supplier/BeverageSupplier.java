package de.shd.project.supplier;

import java.util.Set;

import de.shd.project.beverage.Beverage;


/**
 * Allgemeine Definition für einen Getränkezulieferer.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@FunctionalInterface
public interface BeverageSupplier
{
   Set<Beverage> supplyBeverages();
}
