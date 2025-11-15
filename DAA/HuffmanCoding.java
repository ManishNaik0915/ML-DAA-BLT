import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class HuffmanCoding {

    static void generateCodes(Node root, String code, Map<Character, String> map) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            map.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", map);
        generateCodes(root.right, code + "1", map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("\nEnter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            chars[i] = sc.next().charAt(0);

            System.out.print("Frequency of " + chars[i] + ": ");
            freq[i] = sc.nextInt();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));

        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        Node root = pq.poll();

        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        System.out.println("\nHuffman Codes:");
        for (char c : codes.keySet()) {
            System.out.println(c + " : " + codes.get(c));
        }
    }
}
