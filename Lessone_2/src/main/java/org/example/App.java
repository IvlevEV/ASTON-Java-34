package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        testAddAndGet(); // Тестирование добавления и получения элементов
        testRemove(); // Тестирование удаления элементов
        testClear(); // Тестирование очистки списка
        testSort(); // Тестирование обычной сортировки списка

    }

/**
}
 * Тестирование добавления и получения элементов.
 */
private static void testAddAndGet() {
    MyArrayList<Integer> list = new MyArrayList<>();

    MyArrayList<String> list_2= new MyArrayList<>();

    list.add(10);
    list.add(20);
    list.add(30);
    list.add(11);
    list_2.add("Aston");
    System.out.println(list_2.get(0));



    assert list.get(0).equals(10) : "Ошибка: ожидается 10";
    assert list.get(1).equals(20) : "Ошибка: ожидается 20";
    assert list.get(2).equals(30) : "Ошибка: ожидается 30";

    System.out.println("testAddAndGet пройден.");
}

    /**
     * Тестирование удаления элементов.
     */
    private static void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(1); // Удаляем элемент с индексом 1 (20)
        System.out.println(list.get(1));
        assert list.get(1).equals(30) : "Ошибка: после удаления";

        System.out.println("testRemove пройден.");
    }

    /**
     * Тестирование очистки списка.
     */
    private static void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        list.clear();
        System.out.println(list.size());
        assert list.size() == 0 : "Ошибка: ожидается размер 0 после очистки";

        System.out.println("testClear пройден.");
    }

    /**
     * Тестирование обычной сортировки списка.
     */
    private static void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(30);
        list.add(10);
        list.add(20);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.sort(Integer::compareTo); // Сортируем список
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        assert list.get(0).equals(10) : "Ошибка: ожидается 10 после сортировки";
        assert list.get(1).equals(20) : "Ошибка: ожидается 20 после сортировки";
        assert list.get(2).equals(30) : "Ошибка: ожидается 30 после сортировки";

        System.out.println("testSort пройден.");
    }

}