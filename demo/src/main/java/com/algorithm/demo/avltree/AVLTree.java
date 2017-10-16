package com.algorithm.demo.avltree;

import java.util.Map;
import java.util.TreeMap;

public class AVLTree<K extends Comparable<K> , V> {

	Map<Long, Long> map = new TreeMap<Long, Long>();
	
	private transient Entry<K, V> root;
	
	class Entry<K, V> implements Map.Entry<K, V> {

		K k;
		V v;
		Entry<K, V> left;
		Entry<K, V> right;
		Entry<K, V> parent;
		int height;			// 平衡因子，左子树深度 - 右子树深度
		
		public Entry(K k, V v, Entry<K, V> parent) {
			this.k = k;
			this.v = v;
			this.parent = parent;
			this.height = 0;
		}
		
		public boolean equal(Object o) {
			
			if (!(o instanceof Map.Entry)) {
				return false;
			}
			
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (k.equals(e.getKey()) && v.equals(e.getValue())) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

		@Override
		public V setValue(V value) {
			V vv = v;
			v = value;
			return vv;
		}
	}
	
	public void put(K k, V v) {
		
		if (!(k instanceof Comparable)) {
			throw new IllegalArgumentException();
		}
		
		if (root == null) {
			root = new Entry<K, V>(k, v, null);
			return;
		}
		
		Entry<K, V> entry = root;
		Entry<K, V> parent = root;
		int cmp = 0;
		do {
			
			parent = entry;
			cmp = k.compareTo(entry.k);
			if (cmp > 0) {
				entry = entry.right;
			} else if (cmp < 0) {
				entry = entry.left;
			} else {
				entry.v = v;
				return;
			}
		} while (entry != null);
		
		put(parent, k, v);
	}
	
	private void put(Entry<K, V> node, K k, V v) {
		
		if (node == null) {
			return;
		}
		
		boolean left;
		Entry<K, V> parent = node.parent;
		Entry<K, V> grandfather = null;
		if (parent != null) {
			grandfather = parent.parent;
		}
		int cmp = k.compareTo(node.getKey());
		if (cmp > 0) {
			node.right = new Entry<K, V>(k, v, node);
			node.height -= 1;		// 只在叶子结点上插入，故 node 不存在平衡问题
			if (parent != null) {
				node.parent.height -= 1;
			}
			left = true;
		} else {
			node.left = new Entry<K, V>(k, v, node);
			node.height += 1;
			if (parent != null) {
				parent.height += 1;
			}
			left = false;
		}
		
		fixAfterInsert(node.parent, left);
	}
	
	private void fixAfterInsert(Entry<K, V> node, boolean left) {
		
		if (node == null || node.height == 0 || node.height == 1 || node.height == -1) {
			return;
		}
		
		// node 左子树深度比右子树大 2
		if (node.height > 1) {
			
			if (left) {
				
			} else {
				
			}
		} else {	// node 的右子树深度比左子树大 2
			
			if (left) {
				
			} else {
				
			}
		}
	}
	
	private void rotateLeftLeft(Entry<K, V> entry) {
		
		
	}
	
	public static void main(String[] args) {

		
	}
}
