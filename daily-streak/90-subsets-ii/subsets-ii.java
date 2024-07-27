class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList();

        int n = nums.length;
        int nPow2 = 1 << n;

        for (int i = 0; i < nPow2; i++) {
            List<Integer> subset = new ArrayList();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            Collections.sort(subset);

            if(!subSets.contains(subset)){
                subSets.add(subset);
            }
        }

        return subSets;
    }
}