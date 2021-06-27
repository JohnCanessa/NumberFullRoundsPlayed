import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class NumberOfFullRoundsYouHavePlayed {


    /**
     * Utility function.
     * 
     * !!!! NOT PART OF SOLUTION !!!!
     */
    static int normalizeTime (String str, boolean start) {

        // **** convert hours to minutes ****
        String[] hm = str.split(":");
        int mins = Integer.parseInt(hm[0]);
        mins *= 60;

        // **** compensate for 15 minute intervals ****
        int m = Integer.parseInt(hm[1]);
        while (m % 15 != 0) {
            if (start)
                m += 1;
            else 
                m -= 1;
        }

        // **** update number of minutes ****
        return mins += m;
    }


    /**
     * Compute the number of minutes since the start of the day in minutes.
     * Utility function.
     */
    static int stringToMinutes (String str) {
        String[] hm = str.split(":");
        int mins = Integer.parseInt(hm[0]);
        mins *= 60;
        mins += Integer.parseInt(hm[1]);
        return mins;
    }


    /**
     * A new online video game has been released, 
     * and in this video game, 
     * there are 15-minute rounds scheduled every quarter-hour period. 
     * 
     * This means that at HH:00, HH:15, HH:30 and HH:45, a new round starts, 
     * where HH represents an integer number from 00 to 23. 
     * A 24-hour clock is used, so the earliest time in the day is 00:00 and the latest is 23:59.
     * 
     * Given two strings startTime and finishTime in the format "HH:MM" 
     * representing the exact time you started and finished playing the game, respectively, 
     * calculate the number of full rounds that you played during your game session.
     * 
     * Runtime: 1 ms, faster than 63.86% of Java online submissions.
     * Memory Usage: 36.9 MB, less than 97.39% of Java online submissions.
     * 
     * Time:  Space: 
     */
    static int numberOfRounds (String startTime, String finishTime) {

        // **** sanity check(s) ****
        if (startTime.equals(finishTime)) return 0;

        // **** initialization ****
        int rounds = 0;

        // **** convert start time to minutes ****
        int st = stringToMinutes(startTime);

        // **** convert finish time to minutes ****
        int ft = stringToMinutes(finishTime);

        // **** compute difference in minutes ****
        if (ft > st) {

            // ???? ????
            // System.out.println("<<< ft: " + ft + " > st: " + st);

            // **** current day ****
            // int t = 0;
            // while (t < (24 * 60)) {
            for (int t = 0; t < (24 * 60); t += 15) {

                // **** count this round ****
                if (st <= t && ft >= (t + 15)) {

                    // **** increment round count ****
                    rounds++;

                    // ???? ????
                    // System.out.println("<<<  t: " + t + " rounds: " + rounds);
                }

                // // **** increment time by 15 minutes ****
                // t += 15;
            }

            // **** return number of rounds ****
            return rounds;
        } else {

            // ???? ????
            // System.out.println("<<< ft: " + ft + " <= st: " + st);

            // **** previous day ****
            // int t = 0;
            // while (t < (24 * 60)) {
            for (int t = 0; t < (24 * 60); t += 15) {

                // **** count this round ****
                if (st <= t && (24 * 60) >= (t + 15)) {

                    // **** increment round count ****
                    rounds++;

                    // ???? ????
                    // System.out.println("<<<  t: " + t + " rounds: " + rounds);
                }

                // // **** increment time by 15 minutes ****
                // t += 15;
            }

            // **** current day ****
            // t = 0;
            // while (t < (24 * 60)) {
            for (int t = 0; t < (24 * 60); t += 15) {

                // **** count this round ****
                if (0 <= t && ft >= (t + 15)) {

                    // **** increment round count ****
                    rounds++;

                    // ???? ????
                    // System.out.println("<<<  t: " + t + " rounds: " + rounds);
                }

                // **** increment time by 15 minutes ****
                // t += 15;
            }

            // **** return number of rounds ****
            return rounds;
        }
    }



     /**
      * Test scaffold
      * @throws IOException
      */
      public static void main(String[] args) throws IOException {
          
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read start time ****
        String startTime = br.readLine().trim();

        // **** read finish time ****
        String finishTime = br.readLine().trim();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<<  startTime ==>" + startTime + "<==");
        System.out.println("main <<< finishTime ==>" + finishTime + "<==");

        // **** call function of interest and display result ****
        System.out.println("main <<< rounds: " + numberOfRounds(startTime, finishTime));
      }
}