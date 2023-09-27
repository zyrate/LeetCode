package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

/**
 * O(1) 时间插入、删除和获取随机元素
 */
public class p380_insert_delete_getrandom_o1 {
    /**
     * 双向链表 + HashMap
     */
    class RandomizedSet {
        class Node {
            Node pre;
            Node next;
            int val;
        }

        private Node head, tail;
        private HashMap<Integer, Node> map;
        private Node cursor;

        public RandomizedSet() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            map = new HashMap();
        }

        public boolean insert(int val) {
            if (map.get(val) != null)
                return false;
            Node node = new Node();
            node.val = val;
            node.pre = head;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            map.put(val, node);
            return true;
        }

        public boolean remove(int val) {
            Node node = map.get(val);
            if (node == null)
                return false;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(val);
            node = null;
            cursor = null;
            return true;
        }
        
        // 行不通，不够随机
        public int getRandom() {
            if (cursor == null) {
                cursor = head.next;
            }
            int val = cursor.val;
            if (cursor.next == tail) {
                cursor = head;
            }
            cursor = cursor.next;
            return val;
        }

        // 还是不够快
        public int getRandom02() {
            if (cursor == null) {
                cursor = head.next;
            }
            int select = new Random().nextInt(3); // 选择从头、尾、上次访问元素位置处游走
            int direct = new Random().nextInt(2); // 选择游走方向
            int step = new Random().nextInt(5); // 生成游走步数
            Node ptr = cursor;
            switch(select){
                case 0: ptr = head;break;
                case 1: ptr = tail;break;
                case 2: ptr = cursor;break;
            }
            if(direct == 0){
                while(step-- >= 0){
                    ptr = ptr.pre;
                    if(ptr == null || ptr == head) ptr = tail.pre;
                }
            }else if(direct == 1){
                while(step-- >= 0){
                    ptr = ptr.next;
                    if(ptr == null || ptr == tail) ptr = head.next;
                }
            }
            cursor = ptr;
            return ptr.val;
        }
    }

    @Test
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
    }

    /**
     * 数组+HashMap - 想到了，但是没想到删除的时候可以用最后一个补空位
     */
    class RandomizedSet02 {
        private ArrayList<Integer> list;
        private HashMap<Integer, Integer> map;
        public RandomizedSet02() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.get(val) != null)
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (map.get(val) == null)
                return false;
            int index = map.get(val);
            int lastIndex = list.size() - 1;
            if (index != lastIndex) {
                list.set(index, list.get(lastIndex));
                map.put(list.get(lastIndex), index);
            }
            list.remove(lastIndex);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = new Random().nextInt(list.size());
            return list.get(index);
        }
    }

    @Test
    public void test02() {
        RandomizedSet02 randomizedSet = new RandomizedSet02();
        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
    }

}