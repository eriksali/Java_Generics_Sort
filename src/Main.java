import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.Student;
import sort.SortingAlgorithm;
public class Main
{

    @SuppressWarnings("unckecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "i":
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
                case "f":
                    arrayList.add((Student<T>)new Student<Float>(id, random.nextFloat()));
                    break;
                case "d": 
                    arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble()));
                    break;
                default:
                    //System.out.println("Use Integer as the grade data type");
                    //arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    System.out.println("Exit");
                    break;

            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> void main(String args[]) throws Exception
    {
        try (Scanner scanner = new Scanner(System.in)) {

            //String typeName = "";
            int arrayLength = 0;
            System.out.println("Please input the array size: ");
            arrayLength = scanner.nextInt();

            System.out.println("Please input the grade data type (choose i/Integer, f/Float, or d/Double): ");
            String typeName = scanner.next();

            do {
                
                
                //int arrayLength = 20;
                ArrayList<Student<Integer>> arrayList = createRandomArray(arrayLength, typeName);

                System.out.println(arrayList.toString());
                System.out.println(SortingAlgorithm.isSorted(arrayList));
                SortingAlgorithm.mergeSort(arrayList);
                //SortingAlgorithm.bubbleSort(arrayList);
                System.out.println(arrayList.toString());
                System.out.println(SortingAlgorithm.isSorted(arrayList));

                System.out.println("Please input the array size: (0 to exit)");
                arrayLength = scanner.nextInt();
            } while(!(arrayLength == 0));
            scanner.close();
        }
    }
}
