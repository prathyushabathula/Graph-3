//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code run successfully on leetcode : Yes
//Any problem you faced while writing this code : No
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class FindCelebrity extends Relation {
        // public int findCelebrity(int n) {
        //     int[] indegrees = new int[n];
    
        //     for(int i = 0; i < n; i++) {
        //         for(int j = 0; j < n; j++) {
        //             if(i == j) continue;
        //             if(knows(i,j)) {
        //                 indegrees[i]--;
        //                 indegrees[j]++;
        //             }
        //         }
        //     }
        //     for(int i = 0; i < n; i++) {
        //         if(indegrees[i] == n-1) {
        //             return i;
        //         }
        //     }
        //     return -1;
        // }
        public int findCelebrity(int n) {
            int celeb = 0;
            for(int i = 0; i < n; i++) {
                if(knows(celeb,i)) {
                    celeb = i;
                }
            }
    
            for(int i = 0; i < n; i++) {
                if(i == celeb) continue;
                if(knows(celeb, i) || !knows(i, celeb)) return -1;
            }
            return celeb;
        }
    }