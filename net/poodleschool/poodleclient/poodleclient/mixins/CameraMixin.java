/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.SmoothCamera;
/*    */ import meteordevelopment.meteorclient.mixininterface.ICamera;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_4184;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyArgs;
/*    */ import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
/*    */ 
/*    */ @Mixin({class_4184.class})
/*    */ public abstract class CameraMixin
/*    */   implements ICamera {
/*    */   @ModifyArgs(method = {"update"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;setPos(DDD)V"))
/*    */   private void onUpdateSetPosArgs(Args args) {
/* 17 */     SmoothCamera smoothCamera = (SmoothCamera)Modules.get().get(SmoothCamera.class);
/*    */     
/* 19 */     if (smoothCamera.isActive())
/* 20 */       args.set(1, Double.valueOf(smoothCamera.getStartY())); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/CameraMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */