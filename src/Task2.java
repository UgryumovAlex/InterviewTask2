public class Task2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        //---------------------------------------------------------------------
        System.out.println("MyArrayList");
        MyList<Integer> intsArrayList = new MyArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            intsArrayList.add(1000000-i);
        }

        System.out.println("Количество элементов : " + intsArrayList.size());
        System.out.println("Индекс 400000 : " + intsArrayList.indexOf(400000));

        Integer value = intsArrayList.remove(666666);
        System.out.println("Удаляем значение с индексом 666666, значение = " + value);

        System.out.println("Значение индекса элемента " + intsArrayList.size() + " : " + intsArrayList.indexOf(intsArrayList.size()));

        if (intsArrayList.remove((Integer)555555)) {
            System.out.println("Removed 555555");
            System.out.println(intsArrayList.size());
        }
        //---------------------------------------------------------------------
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);

        System.out.println("----------------------");

        start = System.currentTimeMillis();
        //---------------------------------------------------------------------
        System.out.println("MyLinkedList");
        MyList<Integer> intsLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            intsLinkedList.add(1000000-i);
        }

        System.out.println("Количество элементов : " + intsLinkedList.size());
        System.out.println("Индекс 400000 : " + intsLinkedList.indexOf(400000));

        value = intsLinkedList.remove(666666);
        System.out.println("Удаляем значение с индексом 666666, значение = " + value);

        System.out.println("Значение индекса элемента " + intsLinkedList.size() + " : " + intsLinkedList.indexOf(intsLinkedList.size()));

        if (intsLinkedList.remove((Integer)555555)) {
            System.out.println("Removed 555555");
            System.out.println(intsLinkedList.size());
        }
        //---------------------------------------------------------------------
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }
}
