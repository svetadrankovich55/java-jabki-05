import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int[] numbers = new int[10];
        String[] names = {"Ilya", "Elena", "Андрей"};

        //System.out.println(numbers);

        /*
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
         */

        /*
        for (String name : names) {
            System.out.println(name);
        }
         */

        // Запись значение
        numbers[0] = 1;

        // System.out.println(numbers[0]);
        // System.out.println(names[1]);
        // System.out.println(names.length);

        // System.out.println(average(1000));
        // System.out.println(averageV2(1000));

        int[][] matrix = new int[10][10];
        int[][] grid = {{1, 2}, {3, 4}};

        // print(matrix);
        // print(grid);

        // printIndex(matrix);
        // printIndex(grid);

        int[][] data = createMatrix(100);
        print(data);
        sum(data);
        generateAndPrintRandomArray(7);
        System.out.println(sumArray(createArray(8)));
        System.out.println(findMinElement(createArray(10)));

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthsStartingWithM(months);
        System.out.println(Arrays.toString(reverseArray(createArray(9))));

        int[] arr = {1, 2, 4, 3, 4};
        System.out.println(hasDuplicates(arr));
        int[] arr3 = {1, 2, 3, 4};
        System.out.println(hasDuplicates(arr3));

        int[] arr1 = createArray(10);
        System.out.println(Arrays.toString(arr1));
        System.out.println(hasDuplicates(arr1));

        int[] arr2 = {-1, 2, -4, -3, -4};
        System.out.println(Arrays.toString(replaceNegativesWithAbsolute(arr2)));

        print(createDiagonalMatrix(3));
        System.out.println(matrixSum(createMatrix(4)));
        System.out.println(Arrays.toString(findMaxElement(createMatrix(5))));

        System.out.println(isSquareMatrix(createMatrix(7, 3)));
        System.out.println(isSquareMatrix(createMatrix(7, 7)));
        System.out.println(Arrays.toString(analyzeMatrix(createMatrix(6,7))));
        print(oddEvenFillingMatrix(createMatrix(7,7)));

    }

    // O(2n)
    static int average(int size) {
        int[] arr = new int[size];

        // O(n)
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(100);
        }

        int sum = 0;

        // O(n)
        for (int e : arr) {
            sum += e;
        }

        return sum / size;
    }

    // O(n)
    static int averageV2(int size) {
        int[] arr = new int[size];
        int sum = 0;

        // O(n)
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(100);
            sum += arr[i];
        }

        return sum / size;
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printIndex(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("(%s, %s)", i, j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = RANDOM.nextInt(100);
            }
        }
        return matrix;
    }

    static int[][] createMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = RANDOM.nextInt(100);
            }
        }
        return matrix;
    }

    static void sum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            System.out.printf("Строка %s: сумма = %s\n", i, sum);
        }
    }

    // Одномерные массивы

    // 0. Создание одномерного массива для переиспользования

    static int[] createArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(100);
        }
        return arr;
    }
    // 1. Создайте метод, который выводит массив в консоль.

    static void generateAndPrintRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля!");
        }
        int[] arr = createArray(size);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 2. Напишите метод, который принимает массив целых чисел и возвращает сумму всех его элементов.

    static int sumArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // 3. Реализуйте метод для поиска минимального элемента в одномерном массиве

    static int findMinElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 4. Создайте массив строк, инициализируйте его названиями месяцев года. Выведите все строки, начинающиеся на букву "М"

    static void monthsStartingWithM(String[] months) {
        if (months == null || months.length == 0) {
            throw new IllegalArgumentException("Массив месяцев пуст или не инициализирован");
        }
        System.out.println("Месяцы, начинающиеся на 'М':");
        for (String month : months) {
            if (month.startsWith("M")) {
                System.out.println(month);
            }
        }
    }

    // 5. Напишите метод, который инвертирует порядок элементов в одномерном массиве

    public static int[] reverseArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // 6. Напишите метод, который проверяет, есть ли в массиве повторяющиеся элементы

    public static boolean hasDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 7. Напишите метод, который заменяет все отрицательные числа в массиве на их абсолютные значения.

    public static int[] replaceNegativesWithAbsolute(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }
        return arr;
    }

    // Многомерные массивы

    // 1. Создайте двумерный массив 3x3, заполните его единицами на главной диагонали и нулями в остальных ячейках. Выведите массив

    public static int[][] createDiagonalMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше нуля!");
        }
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1; // Заполняем диагональ
        }
        return matrix;
    }
    //Вывод реализован в Main путем переиспользования метода print

    // 2. Напишите метод, вычисляющий сумму всех элементов в двумерном массиве
    public static int matrixSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не может быть null или пустой");
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // 3. Реализуйте поиск максимального элемента в матрице и вывод его координат (строка, столбец)

    static int[] findMaxElement(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не может быть null или пустой");
        }
        int max = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;

                }
            }
        }
        return new int[]{max, row, col};
    }

    // 4. Реализуйте проверку, является ли двумерный массив квадратным (количество строк = количеству столбцов)

    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матрица не может быть null или пустой");
        }
        if (matrix.length == 0) {
            return true;
        }
        int rows = matrix.length;
        for (int[] row : matrix) {
            if (row.length != rows) {
                return false;
            }
        }
        return true;
    }

    // 5. Напишите метод, который находит сумму элементов каждой строки, минимальное и максимальное значение двумерного массива и выводит результаты

    public static int[] analyzeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не может быть null или пустой");
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i] == null) continue;

                rowSum += matrix[i][j];
                if (matrix[i][j] > max) {
                    max = matrix[i][j];

                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += rowSum;
        }
        return new int[]{sum, max, min};
    }

    // 6. Создайте двумерный массив, заполните его так, чтобы элементы на четных позициях были 0, на нечетных — 1

    public static int[][] oddEvenFillingMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не может быть null или пустой");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) continue;
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }
}