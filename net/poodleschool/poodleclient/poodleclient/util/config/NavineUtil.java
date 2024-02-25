/*    */ package net.poodleschool.poodleclient.poodleclient.util.config;
/*    */ 
/*    */ import meteordevelopment.meteorclient.MeteorClient;
/*    */ import meteordevelopment.meteorclient.utils.PostInit;
/*    */ 
/*    */ public class NavineUtil
/*    */ {
/*    */   @PostInit
/*    */   public static void init() {
/* 10 */     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
/*    */             System.out.println("Saving Navine Config");
/*    */             NavineConfig.get().save(MeteorClient.FOLDER);
/*    */           }));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/config/NavineUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */