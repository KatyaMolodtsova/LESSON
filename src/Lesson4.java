import java.util.Arrays;

public class Lesson4 {
    public static void main(String[] args) {
        // копирование массивов
        int[] ints1;
        ints1 = new int[]{60, -80, 0, 200, 44, 90, 111};

        //int[] newInts = ints1; // две ссылки на одну и ту же область памяти
        int[] cloneInts = ints1.clone(); //полная копия и возвращает его

        int[] newInts = new int[15];
        System.arraycopy(ints1, 1, newInts, 4, 3); // частичная копия
//        System.out.println(Arrays.toString(newInts));

        int[] copyInts = Arrays.copyOf(ints1, 5); // создает новый массив сам
//        System.out.println(Arrays.toString(copyInts));

        //многомерные массивы
        int[][] ints3 = new int[3][4];
        //[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints3));

        int[][] ints4 = new int[3][];
        //[null, null, null]
        ints4[0] = new int[1]; // массив из одного элемента
        ints4[1] = new int[2];
        ints4[2] = new int[3];
        //[[0], [0, 0], [0, 0, 0]]

        int[][] ints5 = {
                {2, 3, 45},
                {6, 7, 81, 8},
                {16, -7, 801, 228}
        };
//        System.out.println(ints5[1][2]);
//        System.out.println(ints5[2][3]);
//        System.out.println(ints5[2][3]);

        for (int i = 0; i < ints5.length; i++) {
            for (int j = 0; j < ints5[i].length; j++) {
                ints5[i][j] *= ints5[i][j];
            }
        }
        System.out.println(Arrays.deepToString(ints5));
    }
}
