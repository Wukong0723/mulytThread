
import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        new Solve().slove();
//    }
//}
//
//class Solve {
//    public void slove() {
//        Scanner s=new Scanner(new BufferedInputStream(System.in));
//    }
//}
public class Main {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        s.slove();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1","1");


        MultiMap<Integer, Integer> map = HashMultimap.create();
        MultiMap



    }
}
class Solution{
    List<List<Integer>> graph=new ArrayList<>();
    int[] in=new int[1005];
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public void slove() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int T=scanner.nextInt();
        for (int i = 0; i <10005 ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < T; i++) {
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            for (int j = 0; j <=n ; j++) {
                in[j]=0;
            }
            for (int j = 0; j <= n; j++) {
                graph.get(j).clear();
            }
            for (int j = 0; j < m; j++) {
                int c=scanner.nextInt();
                int last=-1;
                int curr=0;
                for (int k = 0; k < c; k++) {
                    curr=scanner.nextInt();
                    if (last!=-1){
                        in[curr]++;
                        graph.get(last).add(curr);
                    }
                    last=curr;
                }
            }
            getAns(n);
        }
        out.flush();
    }
    private void getAns(int n){
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if (in[i]==0)queue.add(i);
        }
        while (!queue.isEmpty()){
            if (queue.size()>1){
                out.println("NO");
                return;
            }
            int curr=queue.poll();
            ans.add(curr);
            for(int i:graph.get(curr)){
                in[i]--;
                if (in[i]==0)queue.add(i);
            }
        }
        if (ans.size()<n){
            out.println("NO");
            return;
        }
        for(int i:ans){
            out.print(i);
            out.print(" ");
        }
        out.println();
    }
}
