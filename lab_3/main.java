import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner flow = new Scanner(System.in);
        AVLTree t = new AVLTree();
        AVLTree.Node root = null;
        int choice = 0;
        while (choice != 5) {
            System.out.println("(1) Insert");
            System.out.println("(2) Delete");
            System.out.println("(3) Search");
            System.out.println("(4) Output");
            System.out.println("(5) Exit");

            choice = flow.nextInt();
            if (choice == 1) {
                System.out.print("Value to Insert: ");
                root = t.insert(root, flow.nextInt());
            }
            else if (choice == 2) {
                System.out.print("Value to Delete: ");
                root = t.deleteNode(root, flow.nextInt());
            }
            else if (choice == 3) {
                System.out.print("Value to Search: ");
                boolean result = t.searchData(root, flow.nextInt());
                if (result == true)
                    System.out.println("Node found");
                else
                    System.out.println("Node NOT found");
                }
            else if (choice == 4) {
                System.out.println("(1) Preorder");
                System.out.println("(2) Inorder");
                System.out.println("(3) Postorder");
                System.out.println("(4) Lvl-order");

                int subchoice;
                subchoice = flow.nextInt();

                if (subchoice == 1)
                    t.preorder(root);
                else if (subchoice == 2)
                    t.inorder(root);
                else if (subchoice == 3)
                    t.postorder(root);
                else if (subchoice == 4)
                    t.levelorder(root);
                else
                    System.out.println("Incorrect choice");
            }
            else if (choice == 5) {
                System.out.println("Bye!");
                break;
            }
            else {
                System.out.println("Incorrect choice");
                continue;
            }
        }
    }
}