package Lesson3;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

class MainClassLesson3Test {
    private Logger task7;


    public MainClassLesson3Test() {
        PropertyConfigurator.configure("src/main/resources/logs/config/log4j.properties");
        task7 = Logger.getLogger("task7");


    }



    @DisplayName("Тест 1")
    @Test
    void test1() {
        PropertyConfigurator.configure("src/main/resources/logs/config/log4j.properties");
        MainClassLesson3 main = new MainClassLesson3();
        int[] arr7 = {1, 1, 1, 4, 1};
        task7.info("Начало  теста 1");

        Assertions.assertEquals(true, MainClassLesson3.checkBalance(arr7));


    }

    @DisplayName("Testing task 7 by params")
    @ParameterizedTest
    @MethodSource("arraysData")
    void paramTest(int testNum, boolean res, int[] array) {
        task7.info("Тестирование метода взвешивания массива , задание 7. Тест №"+testNum);
        task7.info("Начало теста , ожидаемый результат = " + res + " массив = " + Arrays.toString(array));

        boolean result = MainClassLesson3.checkBalance(array);
        if (res!=result){

            task7.error("ERR!!");
        } else {
            task7.info("DONE");
        }
        Assertions.assertEquals(res,result);


    }

    static Stream<Arguments> arraysData() {
        return Stream.of(
                Arguments.arguments(1,false, new int[]{1, 2, 3, 3, 2, 1}),
                Arguments.arguments(2,true, new int[]{1, 2, 3, 3, 2, 1}),
                Arguments.arguments(3,false, new int[]{1, 2, 3, 4, 2, 1}),
                Arguments.arguments(4,true, new int[]{3, 3, 3, 3, 2, 4}),
                Arguments.arguments(5,false, new int[]{1, 2, 1, 3, 2, 1})
        );

    }

    @DisplayName("Testing Shift Array")
    @Test
    void testShiftArray1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int conuntToSfift = 1;
        int[] result = {8, 1, 2, 3, 4, 5, 6, 7};
        MainClassLesson3.ShiftArrayToN(array, conuntToSfift);
        Assertions.assertEquals(Arrays.toString(array), Arrays.toString(result));
    }

    @DisplayName("Testing Shift Array")
    @Test
    void testShiftArray2() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int conuntToSfift = -1;
        int[] result = {2, 3, 4, 5, 6, 7, 8, 1};
        task7.info("Тестирование метода сдвига массива, задание 8");
        task7.info("Исходный массив" + Arrays.toString(array) + " Сдвиг = " + conuntToSfift + " ожидаем массив =" + Arrays.toString(result));

        MainClassLesson3.ShiftArrayToN(array, conuntToSfift);
        if (Arrays.toString(array).equals(Arrays.toString(result))) {
            task7.info("Test done");
        } else {
            task7.debug("ERRORE!!!!");
        Assertions.assertEquals(Arrays.toString(array), Arrays.toString(result));

}
    }
}