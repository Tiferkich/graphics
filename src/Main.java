

import javax.swing.*;
import java.awt.*;
import java.util.*;


class Main {

    public static ArrayList<Integer> generateRandomNumbers(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            list.add(randomNumber);
        }

        return list;
    }


    public static void BubbleSort() {
        JFrame frame = new JFrame("Squares with Padding");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) (screenWidth / 1.2), (int) (screenHeight / 1.2));
        frame.setVisible(true);

        ArrayList<Integer> array = generateRandomNumbers(120, 1, 500);
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            booleans.add(false);
        }
        //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ

        SquarePanel panel = new SquarePanel(array, booleans);
        // Проходим по всем элементам списка
        frame.add(panel);


        int n = array.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Для каждого элемента проходим от начала до последнего неотсортированного элемента
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего, меняем их местами
                if (array.get(j) > array.get(j + 1)) {
                    Collections.swap(array, j, j + 1);
                    booleans.set(j, Boolean.TRUE);
                    booleans.set(j + 1, Boolean.TRUE);
                    panel.updateArray();
                    //Sound.playSound("sounds/new.wav").join();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    booleans.set(j, Boolean.FALSE);
                    booleans.set(j + 1, Boolean.FALSE);
                    swapped = true;
                }
            }

            // Если не произошло обменов элементов, завершаем сортировку
            //break;
        }
        for (int i = 0; i < array.size(); i++) {
            booleans.set(i, Boolean.FALSE);
        }
        panel.updateArray();
    }


    // Можно использовать Color.RED, Color.GREEN и т.д.

    public static void main(String[] args) {
        BubbleSort();
    }

}