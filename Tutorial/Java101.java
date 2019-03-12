package Tutorial;

import java.util.Scanner;

public class Java101 {
    public static class PublicClass {
    }

    private static class PrivateClass {
    }

    enum Gender {
        NULL, MALE, FEMALE, OTHER
    }

    public static class Person {
        private static String name;
        private static int age;
        private static Gender gender;

        Person() {
            this("EMPTY STRING", 0, Gender.NULL);
        }

        Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        String secondsAlive() {
            int name =  this.age * 365 /*days*/ * 24 /*hours*/ * 60 /*minutes*/ * 60 /*seconds*/;
            return(this.name + " has lived " + name + " seconds.");
        }

        void printPerson() {
            System.out.println("    NAME:   " + this.name);
            System.out.println("    AGE:    " + this.age);
            System.out.println("    GENDER: " + this.gender);

            System.out.println();
            System.out.println("    " + this.secondsAlive());
        }
    }

    private void testConstructor() {
        Person person = new Person();

        System.out.println("EMPTY CONSTRUCTOR:");
        person.printPerson();
    }

    private void testConstructor(String name, int age, Gender gender) {
        Person person = new Person(name, age, gender);

        System.out.println("NON-EMPTY CONSTRUCTOR:");
        person.printPerson();
    }

    private void testStaticClass() {
        Person person1 = new Person("Mario", 21, Gender.MALE);

        System.out.println("StaticPerson1:");
        person1.printPerson();

        Person person2 = new Person("Oiram", 12, Gender.FEMALE);

        System.out.println("\nStaticPerson2:");
        person2.printPerson();

        System.out.println("\nStaticPerson1:");
        person1.printPerson();
    }

    public static void main(String[] args) {
        Java101 java101 = new Java101();

        Scanner in = new Scanner(System.in);

        String name = in.nextLine();
        int age = in.nextInt();
        String genderString = in.nextLine();
        Gender gender;

        switch (genderString) {
            case "Gender.MALE":
                gender = Gender.MALE;
                break;
            case "Gender.FEMALE":
                gender = Gender.FEMALE;
                break;
            case "Gender.OTHER":
                gender = Gender.OTHER;
                break;
            default:
                gender = Gender.NULL;
        }

        java101.testConstructor();
        System.out.println();

        java101.testConstructor(name, age, gender);

        //System.out.println();
        //java101.testStaticClass();
    }
}
