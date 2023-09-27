package problems;

/**
 * 递枕头 - 水题
 */
public class p2582_pass_the_pillow {
    public int passThePillow(int n, int time) {
        if (n > time)
            return time + 1;
        int cost = n - 1;
        if (time / cost % 2 == 0) {
            return 1 + time % cost;
        } else {
            return n - time % cost;
        }
    }
}