public class Program {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Turtle turtle = new Turtle();

        Animal[] animal = new Animal[3];
        animal[0] = dog;
        animal[1] = tiger;
        animal[2] = turtle;

        Person person = new Person() {
            private int hp = 100;

            public void control(Barkable b) {
                if (b instanceof Tiger) {
                    hp -= 80;
                    System.out.println(((Tiger) b).getName() + "를 제압하였습니다.");
                } else if (b instanceof Dog) {
                    hp -= 10;
                    System.out.println(((Dog) b).getName() + "를 제압하였습니다.");
                }
            }

            public void showInfo() {
                System.out.println("사람 HP : " + hp);
            }
        };

        showResult(animal, person);
    }

    private static void showResult(Animal[] animals, Person p) {
        int len = animals.length;
        int i;

        for (i = 0; i < len; i++) {
            if (animals[i] instanceof Barkable) {
                System.out.println((i + 1) + "번째 동물 : " + animals[i].getName());
                System.out.println((i + 1) + "번째 동물 울음소리 : " + ((Barkable) animals[i]).bark());
                p.control((Barkable) animals[i]);
                p.showInfo();
            }

        }


    }
}
