package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    private static Map<Integer, String> map = new LinkedHashMap<>();
    private static BSTNode root;

    @BeforeAll
    static void inputValueInMap() {
        map.put(21, "Value 21");
        map.put(32, "Value 32");
        map.put(28, "Value 28");
        map.put(16, "Value 16");
        map.put(24, "Value 24");
        map.put(19, "Value 19");
        map.put(26, "Value 26");
        map.put(23, "Value 23");
        map.put(33, "Value 33");
        map.put(30, "Value 30");
        map.put(25, "Value 25");
        map.put(27, "Value 27");
        map.put(14, "Value 14");
        map.put(29, "Value 29");
        map.put(17, "Value 17");
        map.put(15, "Value 15");
        map.put(34, "Value 34");
        map.put(20, "Value 20");
        map.put(31, "Value 31");
        map.put(22, "Value 22");
        map.put(18, "Value 18");

    }

    @Test
    void firstTest() {
        root = new BSTNode(14, "Value 14");
        for (int key : map.keySet()) {
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size(), root.count(root));
    }

    @Test
    void secondTest() {
        BSTNode node;

        root = new BSTNode(14, "Value 14");
        for (int key : map.keySet()) {
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size(), root.count(root));

        node = root.search(root, 18);
        assertEquals("Value 18", node.getValue());

        node = root.search(root, 32);
        assertEquals("Value 32", node.getValue());

        node = root.search(root, 4);
        assertNull(node);
    }

    @Test
    void thirdTest() {
        BSTNode node;

        root = new BSTNode(14, "Value 14");
        for (int key : map.keySet()) {
            if (key == 24) {
                continue;
            }
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size() - 1, root.count(root));

        root.insert(root, 24, "Value 24");
        node = root.search(root, 24);
        assertEquals("Value 24", node.getValue());

        root.insert(root, 24, "Value 24 second");
        assertEquals(map.size(), root.count(root));
        node = root.search(root, 24);
        assertEquals("Value 24 second", node.getValue());
    }

    @Test
    void fourthTest() {
        BSTNode node;

        root = new BSTNode(14, "Value 14");
        for (int key : map.keySet()) {
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size(), root.count(root));

        root = root.delete(root, 18);
        assertEquals(map.size() - 1, root.count(root));
        node = root.search(root, 18);
        assertNull(node);
    }
}