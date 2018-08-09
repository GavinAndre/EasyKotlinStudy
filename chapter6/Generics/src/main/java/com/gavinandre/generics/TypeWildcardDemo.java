package com.gavinandre.generics;

import java.util.ArrayList;
import java.util.List;


class TypeWildcardDemo {

    private Animal animal = new Animal();

    public void extendWildcardDemo() {
        // List<Dog> list2 = new ArrayList<>();
        // list2.add(new Animal());

        // List<? extends Animal>禁止添加任意对象，不过可以添加null
        List<? extends Animal> list1 = new ArrayList<>();
        // list1.add(new Dog());
        // list1.add(new Animal());

        List<Animal> list3 = new ArrayList<>();
        list3.add(new Dog());
        list3.add(new Cat());
        animal.act(list3);

        List<Dog> list4 = new ArrayList<>();

        list4.add(new Dog());
        list4.add(new Dog());
        animal.act(list4);

        // Dog是Animal的子类,List<Dog>可以转换成List<? extends Animal>
        list1 = list4;
        animal.act(list1);

        List<Cat> list5 = new ArrayList<>();
        list5.add(new Cat());
        list5.add(new Cat());
        animal.act(list5);
    }

    public void superWildcardDemo() {

        // <? super T>实现了泛型逆变
        List<? super Dog> list = new ArrayList<>();
        // 可以添加自身和子类对象
        list.add(new Dog());
        list.add(new ShepherdDog());
        // 禁止添加父类对象
        // list.add(new Animal());

        List<? super ShepherdDog> list1 = new ArrayList<>();

        List<ShepherdDog> list6 = new ArrayList<>();
        list6.add(new ShepherdDog());
        animal.aboutShepherdDog(list1);

        List<Dog> list7 = new ArrayList<>();
        list7.add(new Dog());
        animal.aboutShepherdDog(list7);

        List<Animal> list8 = new ArrayList<>();
        list8.add(new Animal());
        // Animal是Dog的父类,Dog是ShepherdDog的子类
        // List<Animal>可以转换为List<? super ShepherdDog>
        list1 = list8;
        animal.aboutShepherdDog(list1);

        List<Cat> list9 = new ArrayList<>();
        list9.add(new Cat());
        // animal.aboutShepherdDog(list9);

    }

    class Animal {

        public void act(List<? extends Animal> list) {
            for (Animal animal : list) {
                animal.eat();
            }
        }

        public void aboutShepherdDog(List<? super ShepherdDog> list) {
            System.out.println("About ShepherdDog");
        }

        public void eat() {
            System.out.println("Eating");
        }

    }

    class Dog extends Animal {
    }

    class Cat extends Animal {
    }

    class ShepherdDog extends Dog {
    }

}
