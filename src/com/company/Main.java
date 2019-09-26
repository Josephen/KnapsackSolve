package com.company;
import java.util.*;

public class Main {
    static void printknapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] +
                            K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        int res = K[n][W];
        System.out.println("Max value:" + res);
        w = W;

        System.out.print("Items weight: " );
        for (i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {
                System.out.print(wt[i - 1] + " ");
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int num = in.nextInt();
        System.out.println();
        int[] val = new int[num];
        int[] wt = new int [num];
        System.out.print("Enter weight of knapsack: ");
        int W = in.nextInt();
        System.out.println();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter value and weight of item ");
            System.out.print(i+1);
            System.out.print(" : ");
            val[i] = in.nextInt();
            wt[i] = in.nextInt();
            System.out.println();
        }

        printknapSack(W, wt, val, num);
    }
}
