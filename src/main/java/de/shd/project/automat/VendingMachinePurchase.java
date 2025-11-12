package de.shd.project.automat;


import de.shd.project.beverage.Beverage;
import de.shd.project.container.Bottle;

/**
 * Wrapper für den Kauf einer Flasche bei einem Getränkeautomaten.
 *
 * @param bottle Flasche, die gekauft wurde
 * @param change Restgeld
 * @author Christoph Gragert (cgr@shd.de)
 */
public record VendingMachinePurchase(Bottle<Beverage> bottle, double change)
{
}
