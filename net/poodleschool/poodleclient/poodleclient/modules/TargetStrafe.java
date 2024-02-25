/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.entity.player.PlayerMoveEvent;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.mixininterface.IVec3d;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.combat.KillAura;
/*    */ import meteordevelopment.meteorclient.utils.player.PlayerUtils;
/*    */ import meteordevelopment.meteorclient.utils.player.Rotations;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_243;
/*    */ 
/*    */ public class TargetStrafe
/*    */   extends Module {
/* 18 */   private float direction = 1.0F;
/*    */   
/*    */   public TargetStrafe() {
/* 21 */     super(Addon.CATEGORY, "target-strafe", "Strafe around player");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 26 */     this.direction = 1.0F;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onMove(PlayerMoveEvent e) {
/* 31 */     class_1297 entityStrafe = ((KillAura)Modules.get().get(KillAura.class)).getTarget();
/* 32 */     if (entityStrafe == null)
/*    */       return; 
/* 34 */     doTargetStrafe(entityStrafe, this.direction, 1.0F, e, 0);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre e) {
/* 39 */     if (this.mc.field_1724.field_5976) {
/* 40 */       this.direction = -this.direction;
/* 41 */       this.direction = (this.direction >= 0.0F) ? 1.0F : -1.0F;
/*    */     } 
/*    */   }
/*    */   
/*    */   private void doTargetStrafe(class_1297 curTarget, float direction_, float radius, PlayerMoveEvent moveEvent, int mathRadius) {
/* 46 */     if (!PlayerUtils.isMoving())
/*    */       return; 
/* 48 */     float forward_ = 0.0F;
/* 49 */     float strafe_ = 0.0F;
/* 50 */     float speed_ = (float)Math.sqrt(moveEvent.movement.field_1352 * moveEvent.movement.field_1352 + moveEvent.movement.field_1350 * moveEvent.movement.field_1350);
/*    */     
/* 52 */     if (speed_ <= 1.0E-4D) {
/*    */       return;
/*    */     }
/* 55 */     float _direction = 0.0F;
/* 56 */     if (direction_ > 0.001D) {
/* 57 */       _direction = 1.0F;
/* 58 */     } else if (direction_ < -0.001D) {
/* 59 */       _direction = -1.0F;
/*    */     } 
/* 61 */     float curDistance = 0.01F;
/* 62 */     if (mathRadius == 1) {
/* 63 */       curDistance = (float)this.mc.field_1724.method_19538().method_1022(curTarget.method_19538());
/* 64 */     } else if (mathRadius == 0) {
/* 65 */       curDistance = (float)Math.sqrt((this.mc.field_1724.method_23317() - curTarget.method_23317()) * (this.mc.field_1724.method_23317() - curTarget.method_23317()) + (this.mc.field_1724.method_23321() - curTarget.method_23321()) * (this.mc.field_1724.method_23321() - curTarget.method_23321()));
/*    */     } 
/* 67 */     if (curDistance < radius - speed_) {
/* 68 */       forward_ = -1.0F;
/* 69 */     } else if (curDistance > radius + speed_) {
/* 70 */       forward_ = 1.0F;
/*    */     } else {
/* 72 */       forward_ = (curDistance - radius) / speed_;
/*    */     } 
/* 74 */     if (curDistance < radius + speed_ * 2.0F && curDistance > radius - speed_ * 2.0F) {
/* 75 */       strafe_ = 1.0F;
/*    */     }
/* 77 */     strafe_ *= _direction;
/* 78 */     float strafeYaw = (float)Rotations.getYaw(curTarget);
/* 79 */     float covert_ = (float)Math.sqrt((forward_ * forward_ + strafe_ * strafe_));
/*    */     
/* 81 */     forward_ /= covert_;
/* 82 */     strafe_ /= covert_;
/* 83 */     double turnAngle = Math.toDegrees(Math.asin(strafe_));
/* 84 */     if (turnAngle > 0.0D) {
/* 85 */       if (forward_ < 0.0F) {
/* 86 */         turnAngle = 180.0D - turnAngle;
/*    */       }
/* 88 */     } else if (forward_ < 0.0F) {
/* 89 */       turnAngle = -180.0D - turnAngle;
/*    */     } 
/* 91 */     strafeYaw = (float)Math.toRadians(strafeYaw + turnAngle);
/*    */ 
/*    */ 
/*    */     
/* 95 */     class_243 move = new class_243(-Math.sin(strafeYaw) * speed_, moveEvent.movement.field_1351, Math.cos(strafeYaw) * speed_);
/*    */     
/* 97 */     this.mc.field_1724.method_18800(move.field_1352, (this.mc.field_1724.method_18798()).field_1351, move.field_1350);
/* 98 */     ((IVec3d)moveEvent.movement).set(move.field_1352, move.field_1351, move.field_1350);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/TargetStrafe.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */