/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1294;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class Strafe
/*    */   extends Module {
/*    */   public static final double PI = 3.141592653589793D;
/*    */   public static final double RAD_TO_DEG = 57.29577951308232D;
/*    */   
/*    */   public static float getSpeed() {
/* 17 */     if ((class_310.method_1551()).field_1724 == null)
/* 18 */       return 0.0F; 
/* 19 */     return (float)getSpeed(((class_310.method_1551()).field_1724.method_18798()).field_1352, ((class_310.method_1551()).field_1724.method_18798()).field_1350);
/*    */   }
/*    */   
/*    */   public static double getSpeed(double motionX, double motionZ) {
/* 23 */     return Math.sqrt(motionX * motionX + motionZ * motionZ);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void strafe(float speed, double yaw) {
/* 30 */     (class_310.method_1551()).field_1724.method_18799(getStrafe(speed, yaw, ((class_310.method_1551()).field_1724.method_18798()).field_1351));
/*    */   }
/*    */   
/*    */   public static class_243 getStrafe(float speed, double yaw, double y) {
/* 34 */     return new class_243(
/* 35 */         -Math.sin(yaw) * speed, y, 
/*    */         
/* 37 */         Math.cos(yaw) * speed);
/*    */   }
/*    */ 
/*    */   
/*    */   public static double getDirection() {
/* 42 */     float rotationYaw = (class_310.method_1551()).field_1724.method_36454();
/*    */     
/* 44 */     if ((class_310.method_1551()).field_1724.field_6250 < 0.0F) {
/* 45 */       rotationYaw += 180.0F;
/*    */     }
/* 47 */     float forward = 1.0F;
/* 48 */     if ((class_310.method_1551()).field_1724.field_6250 < 0.0F) {
/* 49 */       forward = -0.5F;
/* 50 */     } else if ((class_310.method_1551()).field_1724.field_6250 > 0.0F) {
/* 51 */       forward = 0.5F;
/*    */     } 
/* 53 */     if ((class_310.method_1551()).field_1724.field_6212 > 0.0F) {
/* 54 */       rotationYaw -= 90.0F * forward;
/*    */     }
/* 56 */     if ((class_310.method_1551()).field_1724.field_6212 < 0.0F) {
/* 57 */       rotationYaw += 90.0F * forward;
/*    */     }
/* 59 */     return Math.toRadians(rotationYaw);
/*    */   }
/*    */   
/*    */   public static float getBaseMoveSpeed() {
/* 63 */     float baseSpeed = 0.2873F;
/* 64 */     if ((class_310.method_1551()).field_1724.method_6112(class_1294.field_5904) != null) {
/* 65 */       baseSpeed *= 1.0F + 0.2F * ((class_310.method_1551()).field_1724.method_6112(class_1294.field_5904).method_5578() + 1);
/*    */     }
/*    */     
/* 68 */     return baseSpeed;
/*    */   }
/*    */   
/*    */   public Strafe() {
/* 72 */     super(Addon.CATEGORY, "strafe", "Strafing!!11!!1");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre event) {
/* 77 */     strafe(getSpeed(), getDirection());
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/Strafe.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */