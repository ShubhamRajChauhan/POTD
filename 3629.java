/* 
Leetcode : 3629
https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/description/
*/


class Solution {

    
    public int minJumps(int[] nums) {

        int n = nums.length;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int max = 0;

        for(int i = 0; i < n; i++) {
            if(!mp.containsKey(nums[i])) {
                mp.put(nums[i], new ArrayList<>());
            }

            mp.get(nums[i]).add(i); //this is not the else case, just after this if it will execute 

            max = Math.max(max, nums[i]);
        }

        sieve(max);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        HashSet<Integer> seen = new HashSet<>(); //to check visited prime number

        int steps = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- > 0) {

                int i = queue.poll();

                if(i == n - 1) return steps;

                //i - 1
                if(i - 1 >= 0 && !visited[i - 1]) {
                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }

                //i + 1
                if(i + 1 < n && !visited[i + 1]) {
                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }

                //skip if not prime or already processed
                if(!isPrime[nums[i]] || seen.contains(nums[i])) {
                    continue;
                }

                //if prime then visit all multiples
                for(int multiple = nums[i]; multiple <= max; multiple += nums[i]) {

                    if(!mp.containsKey(multiple)) {
                        continue;
                    }

                    for(int j : mp.get(multiple)) {

                        if(!visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                seen.add(nums[i]);

            }
            steps++;
        }

        return -1;
    }


    private boolean[] isPrime;

    private void sieve(int max) {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int num = 2; num * num <= max; num++) {
            if(isPrime[num]) {
                for(int multiple = num * num; multiple <= max; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }
    }

}