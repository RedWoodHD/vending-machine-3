package de.shd.project.automat;

import de.shd.project.beverage.Alcoholic;
import de.shd.project.beverage.Beverage;
import de.shd.project.beverage.Caffeinated;
import de.shd.project.supplier.RealBeverageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {
        vendingMachine = new VendingMachine();
        vendingMachine.setBeverageSupplier(new RealBeverageSupplier());
        vendingMachine.restock();
    }

    @Test
    public void shouldCheckIfBeverageIsListed() {
        assertTrue(vendingMachine.isBeverageListed("Monster"));
        assertFalse(vendingMachine.isBeverageListed("NichtExistierend"));
    }

    @Test
    public void shouldFindBeverageByNameOrPrefix() {
        Optional<Beverage> found = vendingMachine.findBeverage("Monster");
        assertTrue(found.isPresent());
        assertEquals("Monster", found.get().getName());

        Optional<Beverage> notFound = vendingMachine.findBeverage("Unbekannt");
        assertTrue(notFound.isEmpty());
    }

    @Test
    public void shouldReturnAllAlcoholicBeverages() {
        Set<Beverage> alcoholic = vendingMachine.getAllAlcoholicBeverages();
        assertFalse(alcoholic.isEmpty());
        assertTrue(alcoholic.stream().allMatch(b -> b instanceof Alcoholic));
    }

    @Test
    public void shouldReturnAllCaffeinatedBeverages() {
        Set<Beverage> caffeinated = vendingMachine.getAllCaffeinatedBeverages();
        assertFalse(caffeinated.isEmpty());
        assertTrue(caffeinated.stream().allMatch(b -> b instanceof Caffeinated));
    }

    @Test
    public void shouldReturnOnlyColdBeverages() {
        List<Beverage> coldBeverages = vendingMachine.getOnlyColdBeverages();
        assertFalse(coldBeverages.isEmpty());
        assertTrue(coldBeverages.stream().allMatch(b -> b.getTemperature() < 10));
    }

    @Test
    public void shouldReturnOnlyHotBeverages() {
        List<Beverage> hotBeverages = vendingMachine.getOnlyHotBeverages();
        assertFalse(hotBeverages.isEmpty());
        assertTrue(hotBeverages.stream().allMatch(b -> b.getTemperature() > 49));
    }
}