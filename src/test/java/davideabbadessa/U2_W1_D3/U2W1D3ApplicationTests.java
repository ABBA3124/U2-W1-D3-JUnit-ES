package davideabbadessa.U2_W1_D3;

import davideabbadessa.U2_W1_D3.entities.Order;
import davideabbadessa.U2_W1_D3.entities.Pizza;
import davideabbadessa.U2_W1_D3.entities.Table;
import davideabbadessa.U2_W1_D3.entities.Topping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U2W1D3ApplicationTests {

    @Test
    void contextLoads() {
    }

    //calcolo il prezzo di una pizza
    @Test
    public void testPrezzoPizza() {
        Topping prosciutto = new Topping("prosciutto", 92, 0.00);
        Topping ananas = new Topping("ananas", 0, 0.0);
        Pizza margherita = new Pizza("Margherita", Arrays.asList(prosciutto, ananas), false);
        assertEquals(4.30, margherita.getPrice());
    }

    //calcolo se item viene aggiunto ad un ordine
    @Test
    public void testAggiungiOrdine() {
        //primo ordine
        Table tavolo = new Table(1, 5, true, 2.00);
        Order ordine = new Order(4, tavolo);
        Topping prosciutto = new Topping("prosciutto", 92, 0.69);
        Topping ananas = new Topping("ananas", 0, 4.99);
        Pizza margherita = new Pizza("Margherita", Arrays.asList(prosciutto, ananas), false);
        //inserisco primo ordine dentro lista
        ordine.addItem(margherita);

        //secondo ordine
        Table tavolo1 = new Table(1, 5, true, 2.00);
        Order ordine1 = new Order(4, tavolo);
        Pizza margherita1 = new Pizza("Margherita", Arrays.asList(prosciutto, ananas), false);
        //inserisco secondo ordine dentro lista
        ordine.addItem(margherita1);

        assertEquals(2, ordine.getOrderedProducts().size());
    }

    //calcolo totale di un ordine
    @Test
    public void testTotaleOrdine() {
        Table tavolo150 = new Table(150, 12, true, 2.00);
        Order ordine150 = new Order(10, tavolo150);
        Topping prosciutto = new Topping("prosciutto", 92, 1.00);
        Topping ananas = new Topping("ananas", 0, 2.99);
        Pizza margherita150 = new Pizza("Margherita", Arrays.asList(prosciutto, ananas), false);
        ordine150.addItem(margherita150);

        assertEquals(28.29, ordine150.getTotal());


    }

    //test parametrico
    @ParameterizedTest
    @CsvSource({
            "Margherita, 4.30",
            "Hawaiian, 6.77",
            "Salami, 5.29"
    })


    //4.30 Margherita
    //6.77 Hawaiian
    //5.29 Salami
    public void testPrezzoDiOgniPizza(String nomePizza, double prezzoCheMiAspetto) throws IllegalAccessException {

        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping pomodoro = new Topping("Pomodoro", 0, 0.00);
        Topping ananas = new Topping("Ananas", 0, 0.79);
        Topping salame = new Topping("Salame", 0, 0.99);
        Topping prosciutto = new Topping("Prosciutto", 0, 0.99);

        Pizza pizza;
        switch (nomePizza) {
            case "Margherita":
                pizza = new Pizza("Margherita", Arrays.asList(pomodoro), false);
                if (pizza.getPrice() == prezzoCheMiAspetto) {
                    System.out.println(" ✔️ " + "Hai inserito: " + pizza.getPrice() + " Bravo Prezzo corretto, il test è andato a buon fine !");
                } else {
                    System.out.println(" ❌ " + "Hai inserito questo prezzo: " + prezzoCheMiAspetto + " Il prezzo di questa pizza:  " + pizza.getName() + " --> è: " + pizza.getPrice());

                }
                break;
            case "Hawaiian":
                pizza = new Pizza("Hawaiian", Arrays.asList(pomodoro, ananas, prosciutto, mozzarella), false);
                if (pizza.getPrice() == prezzoCheMiAspetto) {
                    System.out.println(" ✔️ " + "Hai inserito: " + pizza.getPrice() + " Bravo Prezzo corretto, il test è andato a buon fine !");
                } else {
                    System.out.println(" ❌ " + "Hai inserito questo prezzo: " + prezzoCheMiAspetto + " Il prezzo di questa pizza:  " + pizza.getName() + " --> è: " + pizza.getPrice());

                }
                break;
            case "Salami":
                pizza = new Pizza("Salami", Arrays.asList(salame, pomodoro), false);
                if (pizza.getPrice() == prezzoCheMiAspetto) {
                    System.out.println(" ✔️ " + "Hai inserito: " + pizza.getPrice() + " Bravo Prezzo corretto, il test è andato a buon fine !");
                } else {
                    System.out.println(" ❌ " + "Hai inserito questo prezzo: " + prezzoCheMiAspetto + " Il prezzo di questa pizza:  " + pizza.getName() + " --> è: " + pizza.getPrice());

                }
                break;

            default:
                throw new IllegalAccessException("nome pizza non valido: " + nomePizza);

        }
        assertEquals(prezzoCheMiAspetto, pizza.getPrice());

    }


}
