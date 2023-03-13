package Apple_Questions_LeetCode.Two_Sum;
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need) && map.get(need) != i){
                return new int[]{i, map.get(need)};
            }
        }
        return null;
    }
}