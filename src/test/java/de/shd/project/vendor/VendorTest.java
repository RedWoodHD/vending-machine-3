package de.shd.project.vendor;

import de.shd.project.automat.VendingMachine;
import de.shd.project.beverage.Beverage;
import de.shd.project.beverage.Alcoholic;
import de.shd.project.container.Bottle;
import de.shd.project.supplier.RealVendingMachineSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VendorTest {

    private Vendor vendor;

   @BeforeEach
    public void setup() {
        vendor = new Vendor();
        vendor.supplyVendingMachines(new RealVendingMachineSupplier());
        vendor.restock();

    }

    @Test
    public void shouldReturnAllBeveragesFromAllMachines() {
        Set<Beverage> beverages = vendor.getBeveragesOfAllVendingMachines();
        assertFalse(beverages.isEmpty());
    }

    @Test
    public void shouldCountAllBeveragesIncludingDuplicates() {
        long count = vendor.countNumberOfBeveragesOfAllVendingMachines();
        assertTrue(count > 0);
    }

    @Test
    public void shouldCountDistinctBeveragesByExactName() {
        long distinctCount = vendor.countNumberOfBeveragesDistinctOfAllVendingMachines();
        assertTrue(distinctCount > 0);
        Set<Beverage> beverages = vendor.getBeveragesOfAllVendingMachines();
        assertTrue(beverages.stream().anyMatch(b -> b.getName().equals("Monster")));
    }

    @Test
    public void shouldReturnVendingMachineWithMostBeverages() {
        VendingMachine maxVm = vendor.getVendingMachineWithTheMostBeverages();
        assertNotNull(maxVm);
        assertFalse(maxVm.getBeverages().isEmpty());
    }

    @Test
    public void shouldFindCheapestNonAlcoholicBeverage() {
        Beverage cheapest = vendor.findTheCheapestNonAlcoholicBeverage();
        assertNotNull(cheapest);
        assertFalse(cheapest instanceof Alcoholic);
        double price = Bottle.PRICE_FOR_BOTTLE + cheapest.getAmount() * cheapest.getPricePerLiter();
        assertTrue(price > 0);
    }
}
