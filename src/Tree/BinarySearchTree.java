package Tree;

//binary search tree data structure
public class BinarySearchTree{
    Node root;
    static class Node{
        Node left;
        Node right;
        int val;
        int height; //find the height of the tree

        Node(int val){
            this.val = val;
            this.height = 0; //we don't need to do this, if int value is not assigned it's by default to 0
        }
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private Node insert(Node root, int val){
        if(root == null){
            Node node = new Node(val);
            return node;
        }

        if(root.val > val){
            root.left = insert(root.left, val);
        }else if(root.val < val){
            root.right = insert(root.right, val);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;  //[5, 6, 7, 3, 4, 1]
        return root;
    }

    public void insertArray(int[] arr){
        for(int num : arr){
            insert(num);
        }
    }

    private int height(Node root){
        if(root == null){
            return -1;
        }
        System.out.println(root.height);
        return root.height;
    }

    //inorder traversal tree.
    public void display(){
        display(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }

    //you can return node type as well for further logical operation
    public boolean search(int target){
        return search(root, target);
    }

    private boolean search(Node root, int target){
        if(root == null){
            return false;
        }

        if(root.val == target){
            return true;
        }else if(root.val < target){
            return search(root.right, target);
        }else {
            return search(root.left, target);
        }
    }

    //deletion in binary-search
    public void delete(int val){
        root = delete(root, val);
    }

    public Node delete(Node root, int target){
        if(root == null){
            return null;
        }

        if(root.val == target){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                //root has both the left and the right children
                //inorder successor
                root.val = min(root.right);

                //delete the node with the found minimum
                root.right  = delete(root.right, root.val);
            }
        }else if(root.val < target){
            root.right = delete(root.right, target);
        }else{
            root.left = delete(root.left, target);
        }
        return root;
    }

    public int min(Node root){
        int minVal = root.val;
        while(root.left != null){
            minVal = root.left.val;
            root = root.left;
        }
        return minVal;
    }

    public int findHeight(int target){
        return findHeight(root, target);
    }

    private int findHeight(Node root, int target){
        if(root == null){
            return -1;
        }
        if(root.val == target){
            return root.height;
        }

        if(root.val > target){
            return findHeight(root.left, target);
        }
        return findHeight(root.right, target);
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {5,6};
        tree.insertArray(arr);
        tree.display();
    }
}