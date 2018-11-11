package core.homeworkJava;

public class Task1ArraysRepeat {

        public static void main(String[] args) {
            int[] array = { 1, 2, 3, 1, 4, 3};
            int[] count = new int[5];

            for (int i = 0; i < array.length; i++) {
                count[array[i]]++;
            }

            for (int i = 1; i < count.length; i++) {
                System.out.println(i + " : " + count[i]);
            }
        }
    }

