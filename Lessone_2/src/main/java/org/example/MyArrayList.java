package org.example;
import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<T> {

    private Object[] elements; // Массив для хранения элементов
    private int size; // Текущий размер массива

    // Конструктор по умолчанию
    public MyArrayList() {
        elements = new Object[32]; // Изначально массив размером 10
        size = 0; // Начальный размер 0
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить
     */

    public void add(T element) {
        ensureCapacity(); // Убедиться, что есть достаточно места
        elements[size++] = element; // Добавить элемент и увеличить размер
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        ensureCapacity(); // Убедиться, что есть достаточно места
        // Сдвигаем элементы вправо, чтобы освободить место для нового элемента
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element; // Вставляем новый элемент
        size++; // Увеличиваем размер
    }

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (T) elements[index]; // Возвращаем элемент
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        // Сдвигаем элементы влево, чтобы закрыть пробел
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Уменьшаем размер и очищаем ссылку
    }

    /**
     * Очищает все элементы в списке.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null); // Очищаем массив
        size = 0; // Устанавливаем размер в 0
    }

    /**
     * Сортирует коллекцию с использованием заданного компаратора.
     *
     * @param comparator компаратор для определения порядка сортировки
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, size - 1, comparator); // Запускаем быструю сортировку
    }

    /**
     * Обеспечивает достаточную емкость массива.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2); // Увеличиваем массив вдвое
        }
    }

    /**
     * Реализация алгоритма быстрой сортировки.
     *
     * @param low начальный индекс подмассива
     * @param high конечный индекс подмассива
     * @param comparator компаратор для определения порядка сортировки
     */
    private void quickSort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator); // Разделяем массив
            quickSort(low, pivotIndex - 1, comparator); // Сортируем левую часть
            quickSort(pivotIndex + 1, high, comparator); // Сортируем правую часть
        }
    }
    /**
     * Разделяет массив на две части для быстрой сортировки.
     *
     * @param low начальный индекс подмассива
     * @param high конечный индекс подмассива
     * @param comparator компаратор для определения порядка сортировки
     * @return индекс опорного элемента после разбиения
     */
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = get(high); // Опорный элемент — последний элемент массива
        int i = (low - 1); // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) { // Если текущий элемент меньше или равен опорному
                i++;
                swap(i, j); // Меняем местами элементы
            }
        }
        swap(i + 1, high); // Перемещаем опорный элемент на правильную позицию
        return i + 1; // Возвращаем индекс опорного элемента
    }

    /**
     * Меняет местами два элемента в массиве.
     *
     * @param i первый индекс
     * @param j второй индекс
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return текущий размер списка
     */
    public int size() {
        return size;
    }
}

