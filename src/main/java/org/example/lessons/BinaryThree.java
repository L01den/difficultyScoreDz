package org.example.lessons;

import org.w3c.dom.Node;

public class BinaryThree<V extends Comparable<V>> {
    private Node root;
    private class Node{
        private V value;
        private Node left;
        private Node right;
        private Color color;
    }
    private enum Color{
        RED, BLACK;
    }

    public boolean add(V val){
        if(root != null){
            boolean result = addNode(root, val);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else{
            root = new Node();
            root.color = Color.BLACK;
            root.value = val;
            return true;
        }
    }
    private boolean addNode(Node node, V val){
        if(node.value == val){
            return false;
        } else{
            if(node.value.compareTo(val) > 0){
                if(node.left != null){
                    boolean result = addNode(node.left, val);
                    node.left = rebalance(node.left);
                    return result;
                } else{
                    node.left = new Node();
                    root.left.color = Color.RED;
                    root.left.value = val;
                    return true;
                }
            } else{
                if(node.right != null){
                    boolean result = addNode(node.right, val);
                    node.right = rebalance(node.left);
                    return result;
                }else{
                    node.right = new Node();
                    root.right.color = Color.RED;
                    root.right.value = val;
                    return true;
                }
            }
        }
    }
    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if(result.right != null && result.right.color == Color.RED &&
                result.left != null && result.left.color == Color.BLACK){
                needRebalance = true;
                result = rightSwap(result);
            }
            if(result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = lestSwap(result);
            }
            if(result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }
    private Node rightSwap(Node node){
        Node rightChild = node.right;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node lestSwap(Node node){
        Node leftChild = node.left;
        Node betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }
}
