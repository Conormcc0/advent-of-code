package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayOne
{

   public static void main(String[] args)
      throws FileNotFoundException
   {
      int highestCals1 = 0;
      int highestCals2 = 0;
      int highestCals3 = 0;

      File file = new File("input.txt");

      try (Scanner calories = new Scanner(file))
      {
         int elfCals = 0;
         while (calories.hasNext())
         {
            String value = calories.nextLine();
            if (!value.trim().isEmpty())
            {
               elfCals += Integer.parseInt(value);
            }
            else
            {
               if (elfCals > highestCals1)
               {
                  highestCals1 = elfCals;
               }
               else if (elfCals > highestCals2)
               {
                  highestCals2 = elfCals;
               }
               else if (elfCals > highestCals3)
               {
                  highestCals3 = elfCals;
               }
               elfCals = 0;
            }
         }
      }

      System.out.println("Highest calorie values = " + (highestCals1 + highestCals2 + highestCals3));
   }
}
