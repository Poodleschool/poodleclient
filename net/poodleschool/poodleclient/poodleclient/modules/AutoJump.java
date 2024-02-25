/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.entity.player.PlayerMoveEvent;
/*    */ import meteordevelopment.meteorclient.mixininterface.IVec3d;
/*    */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.utils.player.PlayerUtils;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1293;
/*    */ import net.minecraft.class_1294;
/*    */ import net.minecraft.class_243;
/*    */ 
/*    */ public class AutoJump
/*    */   extends Module {
/* 18 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 20 */   private final Setting<Boolean> onlySprint = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 21 */       .name("only-sprint"))
/* 22 */       .description("Only Auto Jump if you Sprint"))
/* 23 */       .defaultValue(Boolean.valueOf(false)))
/* 24 */       .build());
/*    */ 
/*    */   
/* 27 */   private final Setting<Boolean> onlyMove = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 28 */       .name("only-move"))
/* 29 */       .description("Only Auto Jump if you Move"))
/* 30 */       .defaultValue(Boolean.valueOf(true)))
/* 31 */       .build());
/*    */   private class_243 prev;
/*    */   
/*    */   public AutoJump() {
/* 35 */     super(Addon.CATEGORY, "auto-jump", "Combine with Speed");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onMove(PlayerMoveEvent e) {
/* 42 */     if (this.prev == null) this.prev = e.movement; 
/* 43 */     if (this.mc.field_1724 == null)
/* 44 */       return;  if (((Boolean)this.onlyMove.get()).booleanValue() && 
/* 45 */       !PlayerUtils.isMoving())
/*    */       return; 
/* 47 */     if (((Boolean)this.onlySprint.get()).booleanValue()) {
/* 48 */       if (this.mc.field_1724.method_24828() && this.mc.field_1724.method_5624()) {
/* 49 */         this.mc.field_1724.method_6043();
/* 50 */         ((IVec3d)e.movement).setY(getHop(0.40123128D));
/*    */       }
/*    */     
/* 53 */     } else if (this.mc.field_1724.method_24828()) {
/* 54 */       this.mc.field_1724.method_6043();
/* 55 */       ((IVec3d)e.movement).setY(getHop(0.40123128D));
/*    */     } 
/*    */     
/* 58 */     this.prev = e.movement;
/*    */   }
/*    */   
/*    */   protected double getHop(double height) {
/* 62 */     class_1293 jumpBoost = this.mc.field_1724.method_6059(class_1294.field_5913) ? this.mc.field_1724.method_6112(class_1294.field_5913) : null;
/* 63 */     if (jumpBoost != null) height += ((jumpBoost.method_5578() + 1) * 0.1F); 
/* 64 */     return height;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/AutoJump.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */