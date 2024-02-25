/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.combat.Criticals;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2828;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_746;
/*    */ import net.minecraft.class_863;
/*    */ 
/*    */ public class ReachPlus extends Module {
/*    */   public ReachPlus() {
/* 21 */     super(Addon.CATEGORY, "reach+", "ty nxyi lol");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 26 */     if (Modules.get().isActive(Criticals.class)) warning("criticals may stop Reach+ from working sry ma frien :/", new Object[0]); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre e) {
/* 31 */     if (this.mc.field_1724 == null || this.mc.field_1687 == null || this.mc.field_1761 == null)
/* 32 */       return;  Optional<class_1297> entity = class_863.method_23101((class_1297)this.mc.field_1724, 150);
/* 33 */     if (this.mc.field_1690.field_1886.method_1434()) {
/* 34 */       class_243 op = this.mc.field_1724.method_19538();
/* 35 */       if (entity.isPresent()) {
/* 36 */         if (((class_746)Objects.<class_746>requireNonNull(this.mc.field_1724)).method_7261(0.0F) < 1.0F)
/*    */           return; 
/* 38 */         class_243 playerPos = this.mc.field_1724.method_19538();
/* 39 */         teleportFromTo(this.mc, playerPos, ((class_1297)entity.get()).method_19538());
/* 40 */         this.mc.field_1761.method_2918((class_1657)this.mc.field_1724, entity.get());
/* 41 */         teleportFromTo(this.mc, ((class_1297)entity.get()).method_19538(), playerPos);
/* 42 */         this.mc.field_1724.method_33574(playerPos);
/* 43 */         while (op != this.mc.field_1724.method_19538())
/* 44 */           teleportFromTo(this.mc, this.mc.field_1724.method_19538(), op); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void teleportFromTo(class_310 mc, class_243 fromPos, class_243 toPos) {
/* 50 */     if (mc.field_1724 == null)
/* 51 */       return;  double distancePerBlock = 8.5D;
/* 52 */     double targetDistance = Math.ceil(fromPos.method_1022(toPos) / distancePerBlock);
/* 53 */     for (int i = 1; i <= targetDistance; i++) {
/* 54 */       class_243 tempPos = fromPos.method_35590(toPos, i / targetDistance);
/* 55 */       mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(tempPos.field_1352, tempPos.field_1351, tempPos.field_1350, true));
/* 56 */       if (i % 4 == 0)
/*    */         try {
/* 58 */           Thread.sleep(0L);
/* 59 */         } catch (InterruptedException interruptedException) {} 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/ReachPlus.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */