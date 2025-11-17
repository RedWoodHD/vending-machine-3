package de.shd.project.automat;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.shd.project.beverage.Alcoholic;
import de.shd.project.beverage.Beverage;
import de.shd.project.beverage.Caffeinated;
import de.shd.project.container.Bottle;
import de.shd.project.supplier.BeverageSupplier;

import static de.shd.project.container.Bottle.*;


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
public class VendingMachine implements VendingMachineDisplayFunctionality,VendingMachineFilterOneFunctionality
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
        String result = "";
        if (beverage instanceof Alcoholic)
        {
            result = result + "," + beverage.getName() + "(alkoholisch)";
        }
        else if (beverage instanceof Caffeinated)
        {
            result = result + "," + beverage.getName() + "(koffeinhaltig)";
        }
        else
        {
            result = result + "," + beverage.getName();
        }
        return result;
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
        return beverages.stream().anyMatch(b -> name.equals(b.getName()));
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
        return beverages.stream().filter(b -> name.contains(b.getName())).findFirst();
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
}
