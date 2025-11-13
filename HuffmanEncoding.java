import java.util.*;

class HuffmanEncoding {

    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.ch = '-';
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int compareTo(Node n) {
            return this.freq - n.freq;
        }
    }

    static void generateCodes(Node root, String code, Map<Character, String> codes) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            codes.put(root.ch, code);
            return;
        }
        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }

    public static void main(String[] args) {
        String text = "apple";
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : freq.entrySet())
            pq.add(new Node(e.getKey(), e.getValue()));

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.freq + right.freq, left, right));
        }

        Node root = pq.poll();
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        System.out.println("Character | Huffman Code");
        for (HashMap.Entry e : codes.entrySet())
            System.out.println(e.getKey() + " | " + e.getValue());

        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray())
            encoded.append(codes.get(c));

        System.out.println("\nEncoded text: " + encoded);
    }
}
