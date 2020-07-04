package Chapter16_Greedy;
import java.util.*;

// Creating the node class for each node in the Huffman Tree
class huffman_node{
    char c;
    int data;

    huffman_node left;
    huffman_node right;

    // Custom comparator - Can also be done using Lambda function
    static class MyComparator implements Comparator<huffman_node>{
        @Override
        public int compare(huffman_node n1, huffman_node n2) {
            return n1.data - n2.data;
        }
    }
}

public class huffman_code {
    private static void printHuffmanTree(huffman_node root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + " : "+ s);
            return;
        }
        printHuffmanTree(root.left, s + "0");
        printHuffmanTree(root.right, s + "1");
    }
    public static void main(String[] args) {
        int n = 6;      // No. of characters
        char[] chars = {'a','b','c','d','e','f'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        // Priority Queue - to sort the nodes in increasing order of their frequencies
//        PriorityQueue<huffman_node> priorityQueue = new PriorityQueue<huffman_node>(n, new huffman_node.MyComparator());

        // Using Lambda Function:
        PriorityQueue<huffman_node> priorityQueue = new PriorityQueue<huffman_node>(n, (a,b) ->  a.data - b.data);

        for(int i = 0; i < n; i++){
            huffman_node node = new huffman_node();
            node.c = chars[i];
            node.data = freq[i];

            node.left = null;
            node.right = null;

            priorityQueue.add(node);
        }

        // Creating the root of the Huffman Tree
        huffman_node root = null;

        while (priorityQueue.size() > 1){
            // Taking the first minimum node based on frequency count
            huffman_node x = priorityQueue.peek();
            priorityQueue.poll();

            // Taking the second minimum node based on frequency count
            huffman_node y = priorityQueue.peek();
            priorityQueue.poll();

            // Adding the two nodes frequency count and creating a new node
            huffman_node sum_node = new huffman_node();
            sum_node.c = '-';
            sum_node.data = x.data + y.data;

            // first minimum node as left child
            sum_node.left = x;

            // second minimum node as right child
            sum_node.right = y;

            // updating the root everytime, with the new node created
            root = sum_node;

            // Adding the new node to the priorityQueue to keep it in sorted in increasing order of frequency
            priorityQueue.add(sum_node);
        }

        printHuffmanTree(root, "");
    }
}
