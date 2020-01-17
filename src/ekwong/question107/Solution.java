package ekwong.question107;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Solution {

    /**
     * 递归法
     * 效果堪忧
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                List<List<Integer>> listList = new ArrayList<>();
                listList.add(list);
                return listList;
            } else if (root.left != null && root.right == null) {
                List<List<Integer>> listList = levelOrderBottom(root.left);
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                listList.add(list);
                return listList;
            } else if (root.left == null) {
                List<List<Integer>> listList = levelOrderBottom(root.right);
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                listList.add(list);
                return listList;
            } else {
                List<List<Integer>> leftListList = levelOrderBottom(root.left);
                List<List<Integer>> rightListList = levelOrderBottom(root.right);
                int leftSize = leftListList.size();
                int rightSize = rightListList.size();
                List<List<Integer>> listList = new ArrayList<>(leftSize);
                if (leftSize > rightSize) {
                    for (int i = 0; i < leftSize; i++) {
                        int j = i - (leftSize - rightSize);
                        if (j >= 0) {
                            List<Integer> integerList = new ArrayList<>();
                            integerList.addAll(leftListList.get(i));
                            integerList.addAll(rightListList.get(j));
                            listList.add(integerList);
                        } else {
                            listList.add(leftListList.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < rightSize; i++) {
                        int j = i - (rightSize - leftSize);
                        if (j >= 0) {
                            List<Integer> integerList = new ArrayList<>();
                            integerList.addAll(leftListList.get(j));
                            integerList.addAll(rightListList.get(i));
                            listList.add(integerList);
                        } else {
                            listList.add(rightListList.get(i));
                        }
                    }
                }
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                listList.add(list);
                return listList;
            }
        } else {
            return new ArrayList<>();
        }
    }


    /**
     * Runtime: 1 ms, faster than 84.44% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 43.1 MB, less than 5.00% of Java online submissions for Binary Tree Level Order Traversal II.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root != null) {
            int firstValue = root.val;
            List<Integer> firstList = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            firstList.add(firstValue);
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            if (nodeList.size() > 0) {
                List<List<Integer>> list = levelUp(nodeList);
                list.add(firstList);
                return list;
            } else {
                List<List<Integer>> listList = new ArrayList<>();
                listList.add(firstList);
                return listList;
            }
        }
        return new ArrayList<>();
    }

    private List<List<Integer>> levelUp(List<TreeNode> nodeList) {
        List<Integer> integerList = new ArrayList<>();
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            integerList.add(node.val);
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        if (nextNodeList.size() != 0) {
            List<List<Integer>> list = levelUp(nextNodeList);
            if (integerList.size() != 0) {
                list.add(integerList);
            }
            return list;
        } else {
            List<List<Integer>> listList = new ArrayList<>();
            listList.add(integerList);
            return listList;
        }
    }


    private Stack<List<Integer>> stack = new Stack<>();

    /**
     * Runtime: 2 ms, faster than 6.90% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 43.1 MB, less than 5.00% of Java online submissions for Binary Tree Level Order Traversal II.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            int firstValue = root.val;
            List<Integer> firstList = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            firstList.add(firstValue);
            stack.push(firstList);
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            levelInteger(nodeList);
            while (!stack.isEmpty()) {
                lists.add(stack.pop());
            }
        }
        return lists;
    }

    private void levelInteger(List<TreeNode> nodeList) {
        List<Integer> integerList = new ArrayList<>();
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            integerList.add(node.val);
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        if (integerList.size() != 0) {
            stack.push(integerList);
        }
        if (nodeList.size() != 0) {
            levelInteger(nextNodeList);
        }
    }

}
