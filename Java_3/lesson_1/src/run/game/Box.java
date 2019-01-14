package run.game;

import java.util.ArrayList;

public class Box<T> extends  Fruit {
    private T fruitBox;
    ArrayList<T> fruits;

    public T getFruitBox() {
        return fruitBox;
    }
    Box(int i){//передаем количество фруктов
        for (int j = 0; j < i; j++) {
            fruits.add(this.getFruitBox());
        }

    }
    public void setFruitBox(T fruitBox) {
        this.fruitBox = fruitBox;
    }
    public float getWeight(){//узнаем вес ящика
       return weight * fruits.size() + 1;
    };
    public boolean compare(Box<T> b1){//сравнили вес 2 боксов
       if(this.getWeight() == b1.getWeight()){
           return true;
       }
       return false;
    }
    public Box<T> shift(Box<T> box){//сравнили фрукты и если они одинаковые то пересыпали в другой ящик.
        if(this.fruitBox instanceof Apple && box.fruitBox instanceof Apple ||
                this.fruitBox instanceof Orange && box.fruitBox instanceof Orange ){
        for (int i = 0; i < this.fruits.size(); i++) {
            box.fruits.add(this.getFruitBox());
        }
            this.fruits.clear();
        }


    return null;
    }
}
