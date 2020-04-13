package com.mi.learn.Array;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 2:11 下午
 * @description 每次记录当前总和所对应的位置，如果存在表示在前面已经记录了，不能用后面的覆盖，
 * 记录后每次找当前总和减去目标值，是不是在map中，存在表示可以去除前面的
 * 不存在添加当前的(sum，i）
 */
public class MaxlenSumT2 {
    public int maxlen(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

}
