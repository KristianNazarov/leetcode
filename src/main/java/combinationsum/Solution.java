package combinationsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /*
    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
     */



    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        candidates = Arrays.stream(candidates).sorted().toArray();

        if (target < candidates[0])
            return Collections.emptyList();

        int k = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();

        findCombination(k, target, candidates, res, currComb);

        return res;
    }

    private void findCombination(int k, int t, int[] candidates, List<List<Integer>> res, List<Integer> currComb)
    {
        if(k == candidates.length) {
            if(t == 0) {
                res.add(new ArrayList<>(currComb));
            }
            return;
        }

        if(candidates[k] <= t) {
            currComb.add(candidates[k]);
            findCombination(k, t - candidates[k], candidates, res, currComb);
            currComb.remove(currComb.size()-1);
        }
        findCombination(k + 1, t, candidates, res, currComb);

    }





    @Test
    public void test1()
    {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> expectedRes = List.of(List.of(2,2,3), List.of(7));
        List<List<Integer>> res = combinationSum(candidates, target);

        Assertions.assertIterableEquals(expectedRes, res);
    }

    @Test
    public void test2()
    {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> expectedRes = List.of(List.of(2,2,2,2), List.of(2,3,3), List.of(3,5));
        List<List<Integer>> res = combinationSum(candidates, target);

        Assertions.assertIterableEquals(expectedRes, res);
    }

    @Test
    public void test3()
    {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expectedRes = Collections.emptyList();
        List<List<Integer>> res = combinationSum(candidates, target);

        Assertions.assertIterableEquals(expectedRes, res);
    }

    @Test
    public void test4()
    {
        int[] candidates = {7,3,6,9};
        int target = 6;
        List<List<Integer>> expectedRes = List.of(List.of(3,3), List.of(6));
        List<List<Integer>> res = combinationSum(candidates, target);

        Assertions.assertIterableEquals(expectedRes, res);
    }




    /*
    Example 1:

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
            2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:

    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:

    Input: candidates = [2], target = 1
    Output: []
    */



}
