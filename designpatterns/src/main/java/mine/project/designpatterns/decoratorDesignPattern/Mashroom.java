package mine.project.designpatterns.decoratorDesignPattern;

public class Mashroom extends ToppingDecorator{
    private BasePizza pizza;

    public Mashroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 15;
    }
}
