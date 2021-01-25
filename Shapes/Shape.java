package Shapes;

import java.util.Random;

public class Shape {


    // Пересчисление форм.
    public enum Tetrominoe {
        NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape
    }


    public Tetrominoe pieceShape;

    // Кординаты формы
    public int[][] cords = new int[4][2];


    // Установка кординаты формы
    public void setShape(Tetrominoe shape) {

        // Массив с кординатами всех форм
        int[][][] cordsTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}}, //NoShape
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}, //ZShape
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}}, //SShape
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}}, //LShape
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, //TShape
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}}, //SquareShape
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, // LShape
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}} //MirLShape
        };


        // Добавление в массив с кординатами кординаты точек формы
        for (int i = 0; i < 4; i++) {
            System.arraycopy(cordsTable[shape.ordinal()], 0, cords, 0, 4);
        }

        // Тетромино из перечисления становиться нащуй формой
        pieceShape = shape;
    }

    // Устанавливает занчение x по индексу в массиве
    private void setX(int index, int x) {
        cords[index][0] = x;
    }

    // Устанавливает знаение y по индексу в массивуе
    private void setY(int index, int y) {
        cords[index][1] = y;
    }


    public int x(int index) {
        return cords[index][0];
    }

    public int y(int index) {
        return cords[index][1];
    }

    public Tetrominoe getShape() {
        return pieceShape;
    }

    public int minY() {

        int m = cords[0][1];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, cords[i][1]);
        }

        return m;
    }


    // Вращение нашей формы в лево
    public Shape rotateLeft() {

        // Если квадрат то не вращаем
        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        // Изменяеи нашу форму
        var result = new Shape();
        result.pieceShape = pieceShape;


        // Меняем кординаты блока
        for (int i = 0; i < 4; i++) {

            result.setX(i, y(i));
            result.setY(i, -x(i));
        }

        return result;
    }

    // Вращение в право по такой же логике как и влево
    public Shape rotateRight() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {

            result.setX(i, -y(i));
            result.setY(i, x(i));
        }

        return result;
    }


    // Выкидываем рандомный блок на доску
    public void setRandomShape() {

        var r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;

        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[x]);
    }


}
