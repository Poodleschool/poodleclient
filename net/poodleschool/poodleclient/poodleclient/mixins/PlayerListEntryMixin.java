/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.UwU;
/*    */ import java.util.function.Supplier;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_640;
/*    */ import net.minecraft.class_8685;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({class_640.class})
/*    */ public abstract class PlayerListEntryMixin
/*    */ {
/*    */   @Unique
/* 22 */   private static final class_2960 skin = new class_2960("navine", "skin.png");
/*    */ 
/*    */   
/*    */   @Final
/*    */   @Shadow
/*    */   private Supplier<class_8685> field_45607;
/*    */ 
/*    */   
/*    */   @Inject(method = {"getSkinTextures"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getSkinTexture(CallbackInfoReturnable<class_8685> cir) {
/* 32 */     if (((UwU)Modules.get().get(UwU.class)).editSkins())
/* 33 */       cir.setReturnValue(new class_8685(skin, ((class_8685)this.field_45607
/*    */ 
/*    */             
/* 36 */             .get()).comp_1911(), ((class_8685)this.field_45607
/* 37 */             .get()).comp_1627(), ((class_8685)this.field_45607
/* 38 */             .get()).comp_1628(), class_8685.class_7920.field_41122, ((class_8685)this.field_45607
/*    */             
/* 40 */             .get()).comp_1630())); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/PlayerListEntryMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */