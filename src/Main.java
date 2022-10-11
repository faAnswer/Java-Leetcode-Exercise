import com.leetcode.GenNewTree;
import com.leetcode.TreeNode;

public class Main {
    public static void main(String[] args) {

        GenNewTree genNewTree = new GenNewTree();

        TreeNode root = genNewTree.insertLevelOrder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},0);

        System.out.println("Hello world!");
    }
}