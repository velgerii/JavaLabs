import java.util.ArrayList;

public class Runner implements Runnable
{
    ArrayList<Integer> map;
    int number;
    int obstacle;

   public Runner(ArrayList<Integer> map, Integer number){
       this.map = map;
       this.number = number;
   }

    @Override
    public void run() {
        System.out.println("Бегун "+ number+ " начал забег");
        for (int i = 0; i < map.size();i++) {
            obstacle = map.get(i);

            try {
                Thread.sleep(obstacle*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Бегун " + number+" закончил забег");
    }
}
