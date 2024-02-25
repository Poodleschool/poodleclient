/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.game.SendMessageEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class ChatFilterBypass
/*    */   extends Module {
/*    */   public ChatFilterBypass() {
/* 11 */     super(Addon.CATEGORY, "chat-filter-bypass", "Bypasses Chat Filters");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   private void onChat(SendMessageEvent event) {
/* 16 */     String message = event.message;
/* 17 */     message = message.replace("a", "a‌");
/* 18 */     message = message.replace("e", "e‌");
/* 19 */     message = message.replace("i", "i‌");
/* 20 */     message = message.replace("o", "o‌");
/* 21 */     message = message.replace("u", "u‌");
/* 22 */     event.message = message;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/ChatFilterBypass.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */