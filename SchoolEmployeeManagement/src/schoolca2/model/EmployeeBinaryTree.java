/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Jeremiah
 */

public class EmployeeBinaryTree {

    // Binary Tree Node
    private static class Node {

        Employee employee;
        Node left;
        Node right;

        Node(Employee employee) {
            this.employee = employee;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int nodeCount;

    public EmployeeBinaryTree() {
        root = null;
        nodeCount = 0;
    }

    // Insert using Level-Order Insertion
    public void insert(Employee employee) {

        Node newNode = new Node(employee);

        if (root == null) {
            root = newNode;
            nodeCount++;
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            // Fill left child first
            if (current.left == null) {
                current.left = newNode;
                nodeCount++;
                return;
            } else {
                queue.add(current.left);
            }

            // Then fill right child
            if (current.right == null) {
                current.right = newNode;
                nodeCount++;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Level-Order Traversal
    public List<Employee> levelOrderTraversal() {

        List<Employee> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            result.add(current.employee);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }

    // Calculate Tree Height (number of levels)
    public int getHeight() {

        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int height = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Node current = queue.remove();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            height++;
        }

        return height;
    }

    // Return total number of nodes
    public int getNodeCount() {
        return nodeCount;
    }
}
