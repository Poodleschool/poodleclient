/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.screen.NavineTitleScreen;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_437;
/*    */ import net.minecraft.class_442;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {class_442.class}, priority = 9999)
/*    */ public abstract class TitleScreenMixin
/*    */   extends class_437
/*    */ {
/*    */   protected TitleScreenMixin(class_2561 title) {
/* 17 */     super(title);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"init"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void init(CallbackInfo ci) {
/* 26 */     if (this.field_22787 != null) {
/* 27 */       this.field_22787.method_1507((class_437)new NavineTitleScreen(this.field_22785));
/* 28 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/TitleScreenMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */