package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayTwo
{
   // | A - Rock | B - Paper | C - Scissors
   // | X - Rock | Y - Paper | Z - Scissors

   public static int challengeOne()
   {
      Map<String, Integer> possibleScores = new HashMap<>();
      possibleScores.put("A X", 4);
      possibleScores.put("A Y", 8);
      possibleScores.put("A Z", 3);
      possibleScores.put("B X", 1);
      possibleScores.put("B Y", 5);
      possibleScores.put("B Z", 9);
      possibleScores.put("C X", 7);
      possibleScores.put("C Y", 2);
      possibleScores.put("C Z", 6);

      return calculateScore(possibleScores);
   }

   public static int challengeTwo()
   {
      Map<String, Integer> possibleScores = new HashMap<>();
      possibleScores.put("A X", 3);
      possibleScores.put("A Y", 4);
      possibleScores.put("A Z", 8);
      possibleScores.put("B X", 1);
      possibleScores.put("B Y", 5);
      possibleScores.put("B Z", 9);
      possibleScores.put("C X", 2);
      possibleScores.put("C Y", 6);
      possibleScores.put("C Z", 7);

      return calculateScore(possibleScores);
   }

   private static int calculateScore(Map<String, Integer> possibleScores)
   {
      int total = 0;
      File file = new File("input2.txt");
      try (Scanner rps = new Scanner(file))
      {
         while (rps.hasNext())
         {
            String game = rps.nextLine();

            if (!game.isEmpty())
            {
               total += possibleScores.get(game);
            }
         }
      }
      catch (FileNotFoundException e)
      {
         throw new RuntimeException(e);
      }
      return total;
   }

   public static void main(String[] args)
   {
      System.out.println(challengeOne());
      System.out.println(challengeTwo());
   }
}
