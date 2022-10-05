import java.util.*;
import sort.Sort;

public class App
{

    public App()
    {
    }

    public static void printArray(int array[])
    {
        int ai[];
        int j = (ai = array).length;
        for(int i = 0; i < j; i++)
        {
            int a = ai[i];
            System.out.print((new StringBuilder(String.valueOf(a))).append(" ").toString());
        }

        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength)
    {
        int array[] = new int[arrayLength];
        Random random = new Random();
        for(int i = 0; i < arrayLength; i++)
            array[i] = random.nextInt(100);

        return array;
    }

    public static boolean isSorted(int array[])
    {
        for(int i = 0; i < array.length - 1; i++)
            if(array[i] > array[i + 1])
                return false;

        return true;
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String flag;
        do
        {
            System.out.println("enter the length of the random int array:");
            int arrayLength = scanner.nextInt();
            long startTime = System.currentTimeMillis();
            int array[] = createRandomArray(arrayLength);
            //System.out.print("\nUnsorted Numbers:  " + Arrays.toString(array));
            startTime = System.currentTimeMillis();
            int sortedArray[] = Sort.mergeSort(array);
            double mergeTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
            System.out.printf("\n\nMergeSort  an array of size %d is %.8f s\n", new Object[] {
                Integer.valueOf(arrayLength), mergeTime
            });
            //System.out.print("\nMergeSort Numbers: " + Arrays.toString(sortedArray));
            //System.out.println((new StringBuilder("The sorted array is in correct order: ")).append(isSorted(sortedArray)).toString());
            startTime = System.currentTimeMillis();
            Sort.bubbleSort(array);
            double bubbleTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
            System.out.printf("BubbleSort an array of size %d is %.8f s\n", new Object[] {
                Integer.valueOf(arrayLength), Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D)
            });
            System.out.println((new StringBuilder("\nMergeSort and BubbleSort generate the same result: ")).append(Arrays.equals(sortedArray, array)).toString()); 
            System.out.println((new StringBuilder("\nBubbleSort takes ")).append(String.valueOf(bubbleTime/mergeTime)).append(" times more than MergeSort does.")); 
            //System.out.print("\nBubbleSort Numbers:" + Arrays.toString(array));
            
            System.out.println("\nContinue? enter Y or N:");
            
            flag = scanner.next();
        } while(!(flag.equals("N") || flag.equals("n")));
        scanner.close();
        System.out.println("Bye!");
    }
}
