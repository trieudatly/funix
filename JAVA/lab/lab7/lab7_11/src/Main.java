import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();

        int[] arr = getIntegers(n);
        arr = sortIntegers(arr);
        printArray(arr);
    }

    public static int[] getIntegers(int capacity){
        System.out.print("nhap mang: ");
        int[] arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for(int item : arr){
            System.out.print(item + " ");
        }
    }

    public static int[] sortIntegers(int[] arr){
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for(int i = 0; i < sortedArray.length - 1; i++){
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
                //printArray(sortedArray);
                //System.out.println("if " + flag);

            }
            //System.out.println("for " + flag);
        }
        return sortedArray;
    }
}