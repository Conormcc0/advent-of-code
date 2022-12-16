package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3
{
   static String charScore = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

   public static AtomicInteger partOne()
      throws IOException
   {
      AtomicInteger total = new AtomicInteger();

      try (Stream<String> lines = Files.lines(Paths.get("input3.txt")).parallel())
      {
         lines.forEach(line -> {
            if (!line.isEmpty())
            {
               Set<Character> firstHalf = line.substring(0, line.length() / 2).chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
               Set<Character> secondHalf = line.substring(line.length() / 2).chars().mapToObj(e -> (char)e).collect(Collectors.toSet());

               firstHalf.retainAll(secondHalf);
               total.addAndGet(charScore.indexOf(firstHalf.stream().findFirst().get()) + 1);
            }
         });
      }
      return total;
   }

   public static AtomicInteger partTwo()
      throws IOException
   {
      AtomicInteger total = new AtomicInteger();

      try (Stream<String> lines = Files.lines(Paths.get("input3.txt")))
      {
         List<Set<Character>> elfgroup = new ArrayList<>();
         lines.forEach(line -> {
            Set<Character> elf = line.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
            elfgroup.add(elf);

            if (elfgroup.size() % 3 == 0)
            {
               elfgroup.get(0).retainAll(elfgroup.get(1));
               elfgroup.get(0).retainAll(elfgroup.get(2));
               total.addAndGet(charScore.indexOf(elfgroup.get(0).stream().findFirst().get()) + 1);
               elfgroup.clear();
            }
         });

         return total;
      }
   }

   public static void main(String[] args)
      throws IOException
   {
      System.out.printf("Part one: %d", partOne().intValue());
      System.out.printf("\nPart two: %d", partTwo().intValue());
   }
}
