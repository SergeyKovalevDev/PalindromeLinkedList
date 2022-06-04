import java.util.Objects;
import java.util.stream.Stream;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int[] array = Stream
                .iterate(head, Objects::nonNull, node -> node.next)
                .mapToInt(node -> node.val)
                .toArray();

        boolean result = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(new Solution().isPalindrome(node1));
    }
}