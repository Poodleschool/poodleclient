/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonUtils
/*    */ {
/*    */   public static boolean requireFields(JsonObject target, String... fields) {
/* 16 */     for (String field : fields) {
/* 17 */       if (!target.has(field))
/* 18 */         return true; 
/*    */     } 
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/JsonUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */