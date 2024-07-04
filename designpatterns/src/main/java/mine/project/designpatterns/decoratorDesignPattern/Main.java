package mine.project.designpatterns.decoratorDesignPattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------------Margherita--------------------------------");
        BasePizza margherita = new Margherita();
        System.out.println(margherita.cost());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();

        System.out.println("-------------------Margherita with extra cheese---------------------------");
        BasePizza margheritaWithEC = new ExtraCheese(new Margherita());
        System.out.println(margheritaWithEC.cost());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();

        System.out.println("----------------Margherita with extra cheese and mashroom-----------------");
        BasePizza margheritaWithECWithM = new Mashroom(new ExtraCheese(new Margherita()));
        System.out.println(margheritaWithECWithM.cost());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();

        System.out.println("-------------------------Veg Delight with mashroom------------------------");
        BasePizza vegDelightWithM = new Mashroom(new VegDelight());
        System.out.println(vegDelightWithM.cost());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
    }
}
