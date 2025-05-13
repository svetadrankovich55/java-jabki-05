import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void createArray() {
        int[] array = Main.createArray(15);
        assertEquals(15, array.length);
        int[] array1 = Main.createArray(10);
        for (int num : array1) {
            assertTrue(num >= 0 && num < 100, "Элемент " + num + " вне диапазона [0, 100)");
        }
    }

    @Test
    void generateAndPrintRandomArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Main.generateAndPrintRandomArray(0));
        assertEquals("Размер массива должен быть больше нуля!", exception.getMessage());
    }


    @Test
    void sumArray() {
        int[] input = {1, 2, 3, 4, 5};
        assertEquals(15, Main.sumArray(input));
        int[] singleElement = {42};
        assertEquals(42, Main.sumArray(singleElement));
        int[] negatives = {-1, -2, -3, -4};
        assertEquals(-10, Main.sumArray(negatives));
        int[] mixed = {-5, 10, 3, -2, 0};
        assertEquals(6, Main.sumArray(mixed));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Main.generateAndPrintRandomArray(0));
        assertEquals("Размер массива должен быть больше нуля!", exception.getMessage());
    }


    @Test
    void findMinElement() {
        int[] arr = {43};
        assertEquals(43, Main.findMinElement(arr));
        int[] arr1 = {-5, -2, -10, -1};
        assertEquals(-10, Main.findMinElement(arr1));
        int[] arr2 = {-5, 0, 5, -10, 10};
        assertEquals(-10, Main.findMinElement(arr2));
        int[] arr3 = {2, 1, 1, 3, 1};
        assertEquals(1, Main.findMinElement(arr3));
        int[] arr4 = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(Integer.MIN_VALUE, Main.findMinElement(arr4));
    }

    @Test
    void monthsStartingWithM() {
        String[] months = {"January", "February", "March", "April", "May", "June"};
        Main.monthsStartingWithM(months);
        String expectedOutput = "Месяцы, начинающиеся на 'М':\r\nMarch\r\nMay\r\n";
        assertEquals(expectedOutput, outContent.toString());
        String[] emptyArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.monthsStartingWithM(emptyArray));
        assertEquals("Массив месяцев пуст или не инициализирован", exception.getMessage());
    }

    @Test
    void reverseArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, Main.reverseArray(input));
        int[] input1 = {-5, 0, 5, -10, 10};
        int[] expected2 = {10, -10, 5, 0, -5};
        assertArrayEquals(expected, Main.reverseArray(input));
        int[] emptyArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.reverseArray(emptyArray));
        assertEquals("Массив не может быть null или пустым", exception.getMessage());
    }

    @Test
    void hasDuplicates() {
        int[] array = {1, 2, 3, 4, 2};
        assertTrue(Main.hasDuplicates(array));
        int[] array1 = {1, 2, 3, 4, 5};
        assertFalse(Main.hasDuplicates(array1));
        int[] array2 = {1, 1, 2, 2, 3, 3};
        assertTrue(Main.hasDuplicates(array2));
        int[] array3 = {1};
        assertFalse(Main.hasDuplicates(array3));
        int[] emptyArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.reverseArray(emptyArray));
        assertEquals("Массив не может быть null или пустым", exception.getMessage());
    }

    @Test
    void replaceNegativesWithAbsolute() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, Main.replaceNegativesWithAbsolute(input));
        int[] input1 = {-1, -2, -3, -4};
        int[] expected1 = {1, 2, 3, 4};
        assertArrayEquals(expected1, Main.replaceNegativesWithAbsolute(input1));
        int[] input2 = {-1, 2, -3, 4};
        int[] expected2 = {1, 2, 3, 4};
        assertArrayEquals(expected2, Main.replaceNegativesWithAbsolute(input2));
        int[] emptyArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.replaceNegativesWithAbsolute(emptyArray));
        assertEquals("Массив не может быть null или пустым", exception.getMessage());
    }

    @Test
    void createDiagonalMatrix() {
        int[][] expected = {{1}};
        assertArrayEquals(expected, Main.createDiagonalMatrix(1));
        int[][] expected1 = {
                {1, 0},
                {0, 1}
        };
        assertArrayEquals(expected1, Main.createDiagonalMatrix(2));
        int[][] expected2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertArrayEquals(expected2, Main.createDiagonalMatrix(3));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Main.createDiagonalMatrix(0));
        assertEquals("Размер матрицы должен быть больше нуля!", exception.getMessage());
    }

    @Test
    void matrixSum() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(45, Main.matrixSum(matrix));
        int[][] matrix1 = {
                {1, 2},
                {3, 4, 5},
                {6}
        };
        assertEquals(21, Main.matrixSum(matrix1));
        int[][] matrix2 = {{15}};
        assertEquals(15, Main.matrixSum(matrix2));
        int[][] matrix3 = {
                {1, -2},
                {-3, 4}
        };
        assertEquals(0, Main.matrixSum(matrix3));
        int[][] emptyMatrix = {};
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Main.matrixSum(emptyMatrix)
        );
        assertEquals("Матрица не может быть null или пустой", exception.getMessage());
    }

    @Test
    void findMaxElement() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = Main.findMaxElement(matrix);
        assertArrayEquals(new int[]{9, 2, 2}, result);
        int[][] matrix1 = {{25}};
        int[] result1 = Main.findMaxElement(matrix1);
        assertArrayEquals(new int[]{25, 0, 0}, result1);
        int[][] emptyMatrix = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.findMaxElement(emptyMatrix));
        assertEquals("Матрица не может быть null или пустой", exception.getMessage());
    }

    @Test
    void isSquareMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertTrue(Main.isSquareMatrix(matrix));
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertFalse(Main.isSquareMatrix(matrix1));
        int[][] matrix2 = {};
        assertTrue(Main.isSquareMatrix(matrix2));
        int[][] matrix3 = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.isSquareMatrix(matrix3));
        assertEquals("Матрица не может быть null или пустой", exception.getMessage());
    }

    @Test
    void analyzeMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = Main.analyzeMatrix(matrix);
        assertArrayEquals(new int[]{45, 9, 1}, result);
        int[][] matrix1 = {{32}};
        int[] result1 = Main.analyzeMatrix(matrix1);
        assertArrayEquals(new int[]{32, 32, 32}, result1);
        int[][] matrix2 = {
                {-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}
        };
        int[] result2 = Main.analyzeMatrix(matrix2);
        assertArrayEquals(new int[]{-45, -1, -9}, result2);
        int[][] emptyMatrix = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.analyzeMatrix(emptyMatrix));
        assertEquals("Матрица не может быть null или пустой", exception.getMessage());
    }

    @Test
    void oddEvenFillingMatrix() {
        int[][] matrix = {
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        };
        int[][] expected = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        assertArrayEquals(expected, Main.oddEvenFillingMatrix(matrix));
        int[][] matrix1 = {
                {2, 2, 2},
                {2},
                {2, 2, 2, 2}
        };
        int[][] expected1 = {
                {0, 1, 0},
                {1},
                {0, 1, 0, 1}
        };
        assertArrayEquals(expected1, Main.oddEvenFillingMatrix(matrix1));
        int[][] emptyMatrix = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.oddEvenFillingMatrix(emptyMatrix));
        assertEquals("Матрица не может быть null или пустой", exception.getMessage());
    }
}