package Tree;

//AVL(self balancing tree implementation)
public class AVL {
    Node root;
    static class Node{
        Node left;
        Node right;
        int val;
        int height;

        Node(int val){
            this.val = val;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node root, int value){
        if(root == null){
            Node node  = new Node(value);
            root = node;
            return root;
        }

        if(root.val > value){
            root.left = insert(root.left, value);
        }else if(root.val < value){
            root.right = insert(root.right, value);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return rotate(root);
    }

    public void insertArray(int[] arr){
        for(int num : arr){
            insert(num);
        }
    }

    private Node rotate(Node root){
        if(height(root.left) - height(root.right) > 1){
            //at this condition we know that the tree is left heavy
            // the > 0 checks for the left sub-tree that is taller than the right sub tree which makes it left-left case
            if(height(root.left.left) - height(root.left.right) > 0){
                //this condition is for the left left rotation
                return rightRotate(root);
            }

            // the < 0 checks for the left sub-tree that is taller than the right sub tree which makes it left-right case
            if(height(root.left.left) - height(root.left.right) < 0){
                //condition for the left right rotation
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if(height(root.left) - height(root.right) < -1){
            //at this condition we know that the tree is right heavy
            if(height(root.right.left) - height(root.right.right) < 0){
                //right right right heavy
                return leftRotate(root);
            }

            if(height(root.right.left) - height(root.right.right) > 0){
                //right left heavy
                root.right = leftRotate(root.right);
                return rightRotate(root);
            }
        }

        return root;
    }

    private Node rightRotate(Node p){
        Node child = p.right;
        Node t = child.left;

        child.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }

    private int height(Node root){
        if(root == null){
            return -1;
        }
        return root.height; //if root.height is not initialized then will return 0
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node root){
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && balanced(root.left) && balanced(root.right);
    }

    public static void main(String[] args){
        AVL tree = new AVL();
        for(int i = 0; i < 1000; i++){
            tree.insert(i);
        }

        System.out.println(tree.height(tree.root));
    }
}
