package de.shd.project.supplier;

import java.util.List;

import de.shd.project.automat.VendingMachine;


/**
 * Allgemeine Definition für einen Automatenzulieferer.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@FunctionalInterface
public interface VendingMachineSupplier
{
   List<VendingMachine> supplyVendingMachines();
}
