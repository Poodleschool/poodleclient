/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import net.minecraft.class_1713;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_1935;
/*    */ import net.minecraft.class_2487;
/*    */ import net.minecraft.class_2499;
/*    */ import net.minecraft.class_2520;
/*    */ import net.minecraft.class_2596;
/*    */ 
/*    */ public class DevModule extends Module {
/*    */   public DevModule() {
/* 16 */     super(Addon.CATEGORY, "n-dev-module", "dev-in!!1!");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 21 */     Int2ObjectArrayMap<class_1799> map = new Int2ObjectArrayMap();
/* 22 */     class_1799 is = new class_1799((class_1935)class_1802.field_8094, 1);
/*    */     
/* 24 */     class_2487 compound = new class_2487();
/*    */     
/* 26 */     class_2499 list = new class_2499();
/* 27 */     class_2499 lastList = new class_2499();
/* 28 */     list.add(lastList);
/*    */     
/* 30 */     for (int i = 0; i < 500; i++) {
/* 31 */       class_2499 tmp = new class_2499();
/* 32 */       lastList.add(tmp);
/* 33 */       lastList = tmp;
/*    */     } 
/*    */     
/* 36 */     compound.method_10566("yes", (class_2520)list);
/* 37 */     is.method_7980(compound);
/*    */     
/* 39 */     map.put(0, is);
/* 40 */     this.mc.field_1724.field_3944.method_52787((class_2596)new class_2813(this.mc.field_1724.field_7512.field_7763, this.mc.field_1724.field_7512
/*    */           
/* 42 */           .method_37421(), 36, -1, class_1713.field_7791, this.mc.field_1724.field_7512
/*    */ 
/*    */ 
/*    */           
/* 46 */           .method_34255().method_7972(), (Int2ObjectMap)map));
/*    */ 
/*    */ 
/*    */     
/* 50 */     toggle();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/DevModule.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */