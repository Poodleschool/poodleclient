/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.events.ModuleToggleEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1109;
/*    */ import net.minecraft.class_1113;
/*    */ import net.minecraft.class_3417;
/*    */ 
/*    */ public class SoundEffects extends Module {
/*    */   public SoundEffects() {
/* 13 */     super(Addon.CATEGORY, "sound-effects", "Play sounds on module toggle");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onModuleToggle(ModuleToggleEvent e) {
/* 18 */     this.mc.method_1483().method_4873((class_1113)class_1109.method_4757(
/* 19 */           e.newState ? class_3417.field_14699 : class_3417.field_15105, 1.0F, 1.0F));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/SoundEffects.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */