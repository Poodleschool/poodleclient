/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Entry<K, V>
/*    */ {
/*    */   private final K key;
/*    */   private final V value;
/*    */   
/*    */   public Entry(K key, V value) {
/* 14 */     this.key = key;
/* 15 */     this.value = value;
/*    */   }
/*    */   
/*    */   public K getKey() {
/* 19 */     return this.key;
/*    */   }
/*    */   
/*    */   public V getValue() {
/* 23 */     return this.value;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/MapUtil$Entry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */