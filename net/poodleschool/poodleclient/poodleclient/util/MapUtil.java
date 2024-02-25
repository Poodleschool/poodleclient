/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ public class MapUtil
/*    */ {
/*    */   public static class Entry<K, V>
/*    */   {
/*    */     private final K key;
/*    */     private final V value;
/*    */     
/*    */     public Entry(K key, V value) {
/* 14 */       this.key = key;
/* 15 */       this.value = value;
/*    */     }
/*    */     
/*    */     public K getKey() {
/* 19 */       return this.key;
/*    */     }
/*    */     
/*    */     public V getValue() {
/* 23 */       return this.value;
/*    */     }
/*    */   }
/*    */   
/*    */   public static <K, V> HashMap<K, V> map(Entry<K, V>... keys) {
/* 28 */     HashMap<K, V> map = new HashMap<>();
/*    */     
/* 30 */     for (Entry<K, V> key : keys) {
/* 31 */       map.put(key.getKey(), key.getValue());
/*    */     }
/*    */     
/* 34 */     return map;
/*    */   }
/*    */   
/*    */   public static <K, V> Entry<K, V> entry(K key, V value) {
/* 38 */     return new Entry<>(key, value);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/MapUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */