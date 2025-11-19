package de.shd.project.automat;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.shd.project.beverage.Alcoholic;
import de.shd.project.beverage.Beverage;
import de.shd.project.beverage.Caffeinated;
import de.shd.project.beverage.InsufficientBeverageException;
import de.shd.project.container.Bottle;
import de.shd.project.supplier.BeverageSupplier;


/**
 * <h3>Repräsentation eines Getränkeautomats</h3>
 * Dieser soll wie folgt funktionieren:
 * <p>
 * Über den {@link BeverageSupplier} (Getränkezulieferer) kann der Automat mit ein Sortiment von Getränken bestückt werden. Hierbei wird eine
 * Menge des Getränks {@link Beverage#getAmount()} in den Automaten abgefüllt. Dieser lagert das Getränk in einem Behälter analog zu:<br>
 * <br><img src="vendingmachine.png" width="242" height="271"></img>
 * </p>
 * <p>
 * Die Getränke werden über {@link #beverages} verwaltet. Die "Behälter" des Getränkeautomats werden nur befüllt, wenn die {@link #restock()}
 * Methode aufgerufen wird.
 * </p>
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
public class VendingMachine implements VendingMachineDisplayFunctionality, VendingMachineFilterOneFunctionality, VendingMachineSalesFunctionality, VendingMachineFilterTwoFunctionality, VendingMachineStatisticsFunctionality
{
    /**
     * Getränke, mit denen der Automat befüllt wurde.
     */
    private Set<Beverage> beverages = new HashSet<>();
    /**
     * Getränkezulieferer
     */
    private BeverageSupplier beverageSupplier;

    public void setBeverageSupplier(BeverageSupplier beverageSupplier)
    {
        this.beverageSupplier = beverageSupplier;
    }

    public void restock()
    {
        beverages = beverageSupplier.supplyBeverages();
    }

    public Set<Beverage> getBeverages()
    {
        return beverages;
    }

    /**
     * <h2>Aufgabe 1</h2>
     * Liefert eine Liste der Namen aller Getränke als Liste zurück, die im Getränkeautomat vorhanden sind. Es spielt hier keine Rolle, welche Menge
     * von dem Getränk im Automat vorhanden ist.
     */
    @Override
    public List<String> displayNamesOfAllBeverages()
    {
        return getBeverages().stream().map(Beverage::getName).toList();
    }

    /**
     * <h2>Aufgabe 2</h2>
     * Liefert ein Set von Namen aller alkoholischen Getränke zurück. Es spielt keine Rolle welche Menge oder welchen Alkoholgehalt das Getränk hat.
     * Ein Getränk, welches das Interface {@link Alcoholic} implementiert, aber einen Alkoholgehalt von {@code <=0} hat, ist als alkoholisch zu betrachten.
     * <h3>Tipp</h3>
     * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
     */
    @Override
    public Set<String> displayNamesOfAllAlcoholicBeverages()
    {
        return getBeverages().stream().filter(e -> e instanceof Alcoholic).map(Beverage::getName).collect(Collectors.toSet());
    }

    /**
     * <h2>Aufgabe 3</h2>
     * Liefert eine Liste von Namen aller nicht-alkoholischen Getränke zurück. Hier gilt: Ein Getränk ist nicht-alkoholisch, wenn es
     * {@link Alcoholic} nicht implementiert. Der Rückgabewert von {@link Alcoholic#getAlcoholStrength()} spielt hier keine Rolle.
     * <h3>Tipp</h3>
     * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
     */
    @Override
    public List<String> displayNamesOfAllNonAlcoholicBeverages()
    {
        return getBeverages().stream().filter(e -> !(e instanceof Alcoholic)).map(Beverage::getName).toList();
    }

    /**
     * <h2>Aufgabe 4</h2>
     * Liefert einen String zurück der alle Namen von Getränken kommasepariert ausgibt.
     * Ist das Getränk alkoholisch, so soll zusätzlich zum Namen noch "alkoholisch" in
     * Klammern ausgegeben werden. Vor dem ersten und nach dem letzten Element der Auflistung steht KEIN Komma! Nach jedem Komma soll zur besseren
     * Lesbarkeit ein Leerzeichen sein.
     * <pre>
     *    Beispiel: Coca Cola, Königsbacher (alkoholisch), Espresso (koffeinhaltig), ...
     * </pre>
     * <h3>Tipp</h3>
     * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
     */
    @Override
    public String displayAllBeverageNamesSeparatedByComma()
    {
        return beverages.stream()
                .map(this::mapToString)
                .collect(Collectors.joining(", "));
    }

    private String mapToString(Beverage beverage)
    {
        if (beverage instanceof Alcoholic)
        {
            return beverage.getName() + "(alkoholisch)";
        }
        return beverage.getName();
    }

    /**
     * <h2>Aufgabe 5</h2>
     * Prüft, ob für den angegebenen Namen ein Getränk im Automaten existiert.
     *
     * @param name Name des Getränks (Namen müssen vollständig übereinstimmen, Case-Sensitiv)
     *
     * @return true, falls es das Getränk im Automat gibt, ansonsten false.
     */
    @Override
    public boolean isBeverageListed(String name)
    {
        return beverages.stream().anyMatch(b -> name.equalsIgnoreCase(b.getName()));
    }

    /**
     * <h2>Aufgabe 6</h2>
     * Für den übergebenen Namen wird das erst beste Getränk zurückgegeben.
     * Ein Getränk kann bereits gefunden werden, wenn
     * nur der Anfang des Namens angegeben wird. (Case-Sensitiv)
     *
     * @param name Anfang oder vollständiger Name eines Getränks
     */
    @Override
    public Optional<Beverage> findBeverage(String name)
    {
        return (beverages.stream().filter(b -> b.getName().contains(name)).findFirst());
    }

    /**
     * <h2>Aufgabe 7</h2>
     * Liefert alle alkoholischen Getränke zurück. Ein Getränk zählt als alkoholisch, wenn es {@link Alcoholic} implementiert.
     * Es ist hier unerheblich, ob {@link Alcoholic#getAlcoholStrength()} einen Wert > 0 zurückliefert.
     */
    @Override
    public Set<Beverage> getAllAlcoholicBeverages()
    {
        return beverages.stream().filter(e -> e instanceof Alcoholic).collect(Collectors.toSet());
    }

    /**
     * <h2>Aufgabe 8</h2>
     * Liefert alle koffeinhaltigen Getränke zurück. Ein Getränk zählt als koffeinhaltig, wenn es {@link Caffeinated} implementiert.
     * Es ist hier unerheblich, ob {@link Caffeinated#getCaffeineStrength()} einen Wert > 0 zurückliefert.
     */
    @Override
    public Set<Beverage> getAllCaffeinatedBeverages()
    {
        return beverages.stream().filter(e -> e instanceof Caffeinated).collect(Collectors.toSet());
    }

    /**
     * <h2>Aufgabe 9</h2>
     * Liefert alle Beverages zurück die "kalt" sind.
     * (<b>Hinweis:</b> Ihr könnt frei definieren, wann ein Getränk für euch die Bedingung "kalt" erfüllt.)
     */
    @Override
    public List<Beverage> getOnlyColdBeverages()
    {
        return beverages.stream().filter(e -> e.getTemperature() < 10).toList();

    }

    /**
     * <h2>Aufgabe 10</h2>
     * Liefert alle Beverages zurück die "heiß" sind.
     * (<b>Hinweis:</b> Ihr könnt frei definieren, wann ein Getränk für euch die Bedingung "heiß" erfüllt.)
     */
    @Override
    public List<Beverage> getOnlyHotBeverages()
    {
        return beverages.stream().filter(e -> e.getTemperature() > 49).toList();
    }

    /**
     * <h2>Aufgabe 11</h2>
     * Es wird für den übergebenen Getränkenamen der Preis berechnet.
     * Der Inhalt des Getränks im Getränkeautomat darf sich dabei NICHT ändern.
     * <p>
     * Der Preis für eine Flasche berechnet sich auf dem Basispreis der Flasche und dem Preis für die Menge des Getränks, welches sich
     * in der Flasche befindet.<br>
     * Beispiel:
     * <pre>
     *       Flasche: Basispreis: 0.25
     *                Menge in der Flasche: 0.5 Liter
     *       Getränk: Preis pro Liter: 2.50
     *       Rechnung: 0.25 + 0.5 * 2.5 = 1.5
     *    </pre>
     * </p>
     *
     * @param name Name
     *
     * @return Preis für eine Flasche des Getränks
     */
    @Override
    public double calculatePriceForOneBottleOf(String name)
    {
        return beverages.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(b -> Bottle.PRICE_FOR_BOTTLE
                        + b.getAmount() * b.getPricePerLiter())
                .orElseThrow(() -> new IllegalArgumentException("Getränk nicht gefunden: " + name));
    }

    /**
     * <h2>Aufgabe 12</h2>
     * Für den übergebenen Namen und das Geld soll ein Getränk gekauft werden.
     * Der Vorrat im Getränkeautomat verringert sich um den Inhalt der Flasche.
     *
     * @param name  Name des Getränks (Muss analog zu {@link VendingMachineFilterOneFunctionality#findBeverage(String)} nicht
     *              vollständig sein)
     * @param money Betrag der für das Getränk bezahlt wird.
     *
     * @return ein {@link VendingMachinePurchase} in dem die gekaufte Flasche und das Restgeld
     * enthalten ist.
     *
     * @throws InsufficientBeverageException Wird geworfen, falls nicht mehr genug vom
     *                                       Getränk vorhanden ist.
     * @throws VendingMachineException       Wird geworfen, falls für den Namen kein
     *                                       Getränk gefunden werden konnte
     *                                       oder das Geld nicht ausreichend ist.
     *                                       Der Inhalt des Getränkeautomats darf sich
     *                                       in den Fällen nicht ändern.
     */
    @Override
    public VendingMachinePurchase buyBeverage(String name, double money)
    {
        return null;
    }

    /**
     * <h2>Aufgabe 13</h2>
     * Berechnet den Preis für eine beliebige Anzahl von Flaschen eines Getränks
     *
     * @param name            Name des Getränks (siehe {@link VendingMachineFilterOneFunctionality#findBeverage(String)})
     * @param numberOfBottles Anzahl der Flaschen
     *
     * @return Preis eines Getränks für die angegebene Anzahl von Flaschen
     */
    @Override
    public double calculatePriceForBottlesOf(String name, int numberOfBottles)
    {
        double priceForOneBottle = calculatePriceForOneBottleOf(name);
        return priceForOneBottle * numberOfBottles;
    }

    /**
     * <h2>Aufgabe 14</h2>
     * Liefert eine Map zurück, die alle Getränke nach ihrer Klasse gruppiert.
     * <h3>Tipp</h3>
     * Recherchiert, welche Methode aus {@link Collectors} euch Datensätz gruppieren lässt.
     */
    @Override
    public Map<Class<? extends Beverage>, List<Beverage>> getBeveragesGroupedByClass()
    {
        return beverages.stream()
                .collect(Collectors.groupingBy(Beverage::getClass));
    }

    /**
     * <h2>Aufgabe 15</h2>
     * Liefert eine Liste aller Getränke, deren Inhalt im Getränkeautomat unter der übergebenen
     * Grenze liegt.<br>
     * Beispiel:
     * <pre>
     *       Getränk1: Restmenge 1 Liter
     *       Getränk2: Restmenge 3 Liter
     *       Grenze: 3 Liter
     *       Return: List.of(Getränk1)
     * </pre>
     *
     * @param threshold Grenze unter, der der Inhalt der Getränke liegen soll
     */
    @Override
    public List<Beverage> getAllBeveragesWithAmountBelowThreshold(int threshold)
    {
        return beverages.stream()
                .filter(b -> b.getAmount() < threshold)
                .toList();
    }

    /**
     * <h2>Aufgabe 16</h2>
     * Liefert eine Map zurück, die dem Namen eines Getränks immer das Getränk selbst zuordnet. D.h. der Key der Map ist der Name des Getränks. Der
     * Value der Map ist das Getränk selbst.
     */
    @Override
    public Map<String, Beverage> getAllBeveragesMappedByName()
    {
        return beverages.stream()
                .collect(Collectors.toMap(Beverage::getName,b -> b));
    }

    /**
     * <h2>Aufgabe 17</h2>
     * Liefert eine Liste von Getränken für den übergebenen Filter zurück.
     *
     * @param filter Filter
     */
    @Override
    public List<Beverage> getListByFilter(Predicate<Beverage> filter)
    {
        return beverages.stream()
            .filter(filter)
            .toList();
    }

    /**
     * <h2>Aufgabe 18</h2>
     * Liefert eine Liste mit allen Füllständen zurück. Die Füllstände soll eindeutig sein, d.h. es dürfen keine doppelten Einträge in der Liste
     * vorkommen.
     * <h3>Tipp</h3>
     * Recherchiert, welche Methode aus {@link Stream} euch dabei hilft, die doppelten Einträge zu entfernen.
     */
    @Override
    public List<Double> getListOfCurrentAmountsOfBeverages()
    {
        return beverages.stream()
            .map(Beverage::getAmount)
            .distinct()
            .toList();
    }

    /**
     * <h2>Aufgabe 19</h2>
     * Liefert eine Liste aller Getränke zurück, die sich eine Person für das übergebene Budget leisten kann. Die Liste von Getränken soll vom
     * günstigsten zum teuersten sortiert sein. Eine Person kann sich ein Getränk leisten, wenn sie am Automat eine Flasche des entsprechenden
     * Getränks kaufen kann. Hier spielt es keine Rolle, welche Menge des entsprechenden Getränks im Automat vorhanden ist.
     *
     * @param budget Budget des Käufers
     */
    @Override
    public List<Beverage> findAllAffordableBeverages(double budget)
    {
        return beverages.stream()
            .filter(b -> {
                double price = calculatePriceForOneBottleOf(b.getName());
                return price <= budget;
            })
            .sorted((b1, b2) -> Double.compare(calculatePriceForOneBottleOf(
                    b1.getName()),calculatePriceForOneBottleOf(
                            b2.getName())))
                .toList();
    }

    /**
     * <h2>Aufgabe 20</h2>
     * Liefert die 5 Getränke mit dem geringsten Inhalt sortiert nach dem Inhalt absteigend zurück.<br>
     * Beispiel:
     * <pre>
     *    Getränk1: Menge 1 Liter
     *    Getränk2: Menge 5 Liter
     *    Getränk3: Menge 25 Liter
     *    Getränk4: Menge 17 Liter
     *    Getränk5: Menge 2 Liter
     *    Getränk6: Menge 9 Liter
     *    Getränk7: Menge 18 Liter
     *
     *    Ausgabe: [Getränk4, Getränk6, Getränk2, Getränk5, Getränk1]
     * </pre>
     */
    @Override
    public List<Beverage> getTopFiveBeveragesWithTheLeastAmountOrderedByAmountDescending()
    {
        return beverages.stream()
            .sorted(Comparator.comparingDouble(Beverage::getAmount))
            .limit(5)
            .sorted(Comparator.comparingDouble(Beverage::getAmount).reversed())
            .toList();
    }

    /**
     * <h2>Aufgabe 21</h2>
     * Berechnet den Gesamtwert von Getränken, die sich aktuell im Getränkeautomat befinden.
     * Es wird nur der Werte der Getränke betrachtet.<br>
     * Beispiel:
     * <pre>
     *       Getränk1: Preis pro Liter: 2.50
     *                Menge im Automaten: 10 Liter
     *       Getränk2: Preis pro Liter: 1.50
     *                Menge im Automaten: 20 Liter
     *       Rechnung: 2.5 * 10 + 1.5 * 20 = 55
     * </pre>
     */
    @Override
    public double calculateTotalValueOfAllBeverages()
    {
        return beverages.stream()
            .mapToDouble(b -> b.getAmount() * b.getPricePerLiter())
            .sum();
    }

    /**
     * <h2>Aufgabe 22</h2>
     * Berechnet analog zu {@link #calculateTotalValueOfAllBeverages()} den Wert für alle alkoholischen Getränke
     */
    @Override
    public double calculateTotalValueOfAllAlcoholicBeverages()
    {
        return beverages.stream()
            .filter(b -> b instanceof Alcoholic)
            .mapToDouble(b -> b.getAmount() * b.getPricePerLiter())
            .sum();
    }

    /**
     * <h2>Aufgabe 23</h2>
     * Berechnet die Durchschnittstemperatur aller Getränke. Eine Mengenverteilung spielt hier keine Rolle.<br>
     * Beispiel:
     * <pre>
     *       Getränk1: 10°C
     *       Getränk2: 20°C
     *       Rechnung: 10 + 20 / 2 = 15
     * </pre>
     */
    @Override
    public double calculateAverageTemperatureOfAllBeverages()
    {
        return beverages.stream()
            .mapToInt(Beverage::getTemperature)
            .average()
            .orElse(0);
    }

    /**
     * <h2>Aufgabe 24</h2>
     * Berechnet den durchschnittlichen Alkoholgehalt aller alkoholischen Getränke.
     * Rechnung analog zu {@link #calculateAverageTemperatureOfAllBeverages()}.
     */
    @Override
    public double calculateAverageAlcoholicStrengthOfAllAlcoholicBeverages()
    {
        return beverages.stream()
            .filter(b -> b instanceof Alcoholic)
            .mapToDouble(b -> ((Alcoholic) b).getAlcoholStrength())
            .average()
            .orElse(0);
    }

    /**
     * <h2>Aufgabe 25</h2>
     * Liefert das Produkt über die Menge aller Getränke.<br>
     * Beispiel:
     * <pre>
     *    Getränk1: Menge 10 Liter
     *    Getränk2: Menge 20 Liter
     *    Rechnung: 10 * 20 = 200
     * </pre>
     * (<b>Hinweis</b>: Hier soll die Methode {@link Stream#reduce(Object, BinaryOperator)} verwendet werden.)
     */
    @Override
    public double getMultipliedAmountsOfBeverages()
    {
        return beverages.stream()
            .map(Beverage::getAmount)
            .reduce(1.0, (a, b) -> a * b);
    }
}
