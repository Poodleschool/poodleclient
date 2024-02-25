/*    */ package net.poodleschool.poodleclient.poodleclient.util.config;
/*    */ 
/*    */ import meteordevelopment.meteorclient.MeteorClient;
/*    */ import meteordevelopment.meteorclient.systems.System;
/*    */ import net.minecraft.class_2487;
/*    */ 
/*    */ public class NavineConfig
/*    */   extends System<NavineConfig> {
/*  9 */   private static final NavineConfig INSTANCE = new NavineConfig();
/*    */ 
/*    */   
/* 12 */   public String rpcPrefix = "#";
/* 13 */   public float blurStrength = 5.0F;
/* 14 */   public float menuButtonPosition = 5.0F;
/*    */ 
/*    */   
/*    */   public NavineConfig() {
/* 18 */     super("navine-config");
/* 19 */     init();
/* 20 */     load(MeteorClient.FOLDER);
/*    */   }
/*    */   
/*    */   public static NavineConfig get() {
/* 24 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   public class_2487 toTag() {
/* 29 */     class_2487 tag = new class_2487();
/*    */     
/* 31 */     tag.method_10582("rpcPrefix", this.rpcPrefix);
/* 32 */     tag.method_10548("blurStrength", this.blurStrength);
/* 33 */     tag.method_10548("menuButtonPosition", this.menuButtonPosition);
/*    */     
/* 35 */     return tag;
/*    */   }
/*    */ 
/*    */   
/*    */   public NavineConfig fromTag(class_2487 tag) {
/* 40 */     this.rpcPrefix = tag.method_10558("rpcPrefix");
/* 41 */     this.blurStrength = tag.method_10583("blurStrength");
/* 42 */     this.menuButtonPosition = tag.method_10583("menuButtonPosition");
/* 43 */     return this;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/config/NavineConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */