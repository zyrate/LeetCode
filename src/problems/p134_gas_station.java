package problems;

import org.junit.Test;

/**
 * 加油站
 */
public class p134_gas_station {
    /**
     * 暴力 - 时间溢出
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            if (gas.length == 1 && rest < 0)
                return -1;
            int j = i + 1 == gas.length ? 0 : i + 1;
            while (j != i && rest >= 0) {
                rest += gas[j] - cost[j];
                if (rest < 0)
                    break;
                j++;
                if (j == gas.length)
                    j = 0;
            }
            if (j == i)
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3});
    }
}