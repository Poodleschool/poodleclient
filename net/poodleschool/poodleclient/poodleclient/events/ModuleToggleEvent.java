/*    */ package de.Jakob.navine.events;
/*    */ 
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ 
/*    */ public class ModuleToggleEvent
/*    */ {
/*    */   public final Module module;
/*    */   public final boolean newState;
/*    */   
/*    */   public ModuleToggleEvent(Module module, boolean newState) {
/* 11 */     this.module = module;
/* 12 */     this.newState = newState;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/events/ModuleToggleEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */