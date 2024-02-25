/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.events.PlayerStrideEvent;
/*    */ import de.Jakob.navine.modules.AttackEffects;
/*    */ import meteordevelopment.meteorclient.MeteorClient;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_1282;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_3414;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ import org.spongepowered.asm.mixin.injection.Slice;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1657.class})
/*    */ public class MixinPlayerEntity
/*    */ {
/*    */   @ModifyVariable(method = {"tickMovement"}, at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;strideDistance:F", shift = At.Shift.BEFORE, ordinal = 0), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setMovementSpeed(F)V"), to = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSpectator()Z")), index = 1, ordinal = 0, require = 1, allow = 1)
/*    */   private float hookStrideForce(float strideForce) {
/* 22 */     return ((PlayerStrideEvent)MeteorClient.EVENT_BUS.post(new PlayerStrideEvent(strideForce))).getStrideForce();
/*    */   }
/*    */   
/*    */   @Inject(method = {"getHurtSound"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getHurtSound(class_1282 source, CallbackInfoReturnable<class_3414> cir) {
/* 27 */     if (((AttackEffects)Modules.get().get(AttackEffects.class)).shouldPlaySound())
/* 28 */       cir.setReturnValue(null); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/MixinPlayerEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */