package mine.project.designpatterns.decoratorDesignPattern;

import com.fasterxml.jackson.databind.ser.Serializers.Base;

public class ExtraCheese extends ToppingDecorator{
    private BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 10;
    }
}
