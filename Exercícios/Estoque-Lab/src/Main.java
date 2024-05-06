import models.Estoque;
import models.Item;

public class Main {
    public static void main(String[] args) {
        // Criando alguns itens
        Item item1 = new Item(10, "Item A");
        Item item2 = new Item(20, "Item B");
        Item item3 = new Item(30, "Item C");

        // Criando o estoque
        Estoque estoque = new Estoque();

        // Adicionando itens ao estoque
        estoque.adicionarArray(item1);
        estoque.adicionarArray(item2);
        estoque.adicionarArray(item3);

        // Imprimindo o estoque
        System.out.println("Estoque após adicionar itens:");
        for (int i = 0; i < estoque.getItensArray().size(); i++) {
            System.out.println("Item na posição " + i + ": " + estoque.getItensArray().get(i));
        }

        // Buscando um item no estoque pela posição
        System.out.println("\nBuscando o item na posição 1:");
        estoque.buscar(1);

        // Modificando um item no estoque
        Item novoItem = new Item(50, "Novo Item");
        System.out.println("\nModificando o item na posição 0:");
        estoque.modificar(novoItem, 0);
        for (int i = 0; i < estoque.getItensArray().size(); i++) {
            System.out.println("Item na posição " + i + ": " + estoque.getItensArray().get(i));
        }

        // Deletando um item do estoque
        System.out.println("\nDeletando o item na posição 2:");
        estoque.deletar(2);
        for (int i = 0; i < estoque.getItensArray().size(); i++) {
            System.out.println("Item na posição " + i + ": " + estoque.getItensArray().get(i));
        }
    }
}
