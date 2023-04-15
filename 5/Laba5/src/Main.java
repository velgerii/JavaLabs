import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Runner runner;
        ArrayList<Thread> runners = new ArrayList<>();
        ArrayList<ArrayList<Integer>> AllMaps = new ArrayList<>();
        AllMaps.add(new ArrayList<>(Arrays.asList(0,1,0,0,1,0,0,0)));
        AllMaps.add(new ArrayList<>(Arrays.asList(1,2,4,8,1,0,0,0)));
        AllMaps.add(new ArrayList<>(Arrays.asList(0,2,0,1,1,1,1,0)));
        AllMaps.add(new ArrayList<>(Arrays.asList(6,4,3,4,5,2,4,0)));

        for (int i = 0; i < AllMaps.size(); i++)
        {
            runner = new Runner(AllMaps.get(i),i);
            Thread thread = new Thread(runner);
            runners.add(thread);
        }

        runners.parallelStream().forEach(thread -> thread.start());

        for (Thread thread : runners) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\nЗабег закончен");
    }
}
