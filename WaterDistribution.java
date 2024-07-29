//Time Complexity : Elog(E) + (V+E)
//Space Complexity : O(E)
//Did this code run successfully on leetcode : Yes
//Any problem you faced while writing this code : No
class WaterDistribution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int result = 0;
        this.uf = new int[n+1];

        for(int i=0; i<=n; i++) {
            uf[i] = i;
        }

        List<int[]> edges = new ArrayList<>();
        for(int i=1; i<=n;i++) {
            edges.add(new int[]{0,i,wells[i-1]});
        }

        for(int[] pipe : pipes) {
            edges.add(pipe);
        }

        Collections.sort(edges, (a,b)->a[2]-b[2]);
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int px = find(x);
            int py = find(y);

            if(px != py) {
                result += edge[2];
                uf[px] = py;
            }
        }
        return result;
    }
    private int find(int x) {
        if(uf[x] != x) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}