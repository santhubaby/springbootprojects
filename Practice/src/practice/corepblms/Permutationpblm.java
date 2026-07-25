package practice.corepblms;
import java.util.*;
import java.io.*;

class Permutationpblm {

    public static void getpermutations(List<Integer> nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.size()) {
            // Add a copy of nums to ans
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            // Swap idx and i
            Collections.swap(nums, idx, i);

            // Recurse
            getpermutations(nums, idx + 1, ans);

            // Swap back (backtrack)
            Collections.swap(nums, idx, i);
        }
    }

    public static List<List<Integer>> getperms(List<Integer> nums, int idx, List<List<Integer>> ans) {
        getpermutations(nums, idx, ans);
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        List<List<Integer>> ans = new ArrayList<>();
        getperms(nums, 0, ans);

        // Print all permutations
        for (List<Integer> perm : ans) {
            System.out.println(perm);
        }
    }
}
