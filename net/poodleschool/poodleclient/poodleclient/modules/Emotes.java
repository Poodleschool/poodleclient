/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.game.SendMessageEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class Emotes extends Module {
/*    */   public Emotes() {
/* 10 */     super(Addon.CATEGORY, "emojify", "Adds some emojis to chat!");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   private void OnMessage(SendMessageEvent event) {
/* 15 */     String message = event.message;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     message = message.replaceAll(":skull:", "☠").replaceAll(":dynamite:", "🧨").replaceAll(":yay:", "🎉").replaceAll(":celebrate:", "🎉").replaceAll(":sword:", "🗡").replaceAll(":pumpkin:", "🎃").replaceAll(":gift:", "🎁").replaceAll(":ferris-wheel:", "🎡").replaceAll(":roller-coaster:", "🎢").replaceAll(":glasses:", "🕶").replaceAll(":goggles:", "🥽").replaceAll(":gem:", "💎").replaceAll(":ring:", "💍").replaceAll(":football:", "🏈").replaceAll(":medal:", "🏅").replaceAll(":dice:", "🎲").replaceAll(":die:", "🎲").replaceAll(":diamond:", "♦").replaceAll(":volume:", "🔊").replaceAll(":sound:", "🔊").replaceAll(":music:", "🎵").replaceAll(":axe:", "🪓").replaceAll(":pickaxe:", "⛏").replaceAll(":key:", "🔑").replaceAll(":potion:", "🧪").replaceAll(":splash-potion:", "⚗").replaceAll(":syringe:", "💉").replaceAll(":bandaid:", "🩹").replaceAll(":bandage:", "🩹").replaceAll(":heal:", "🩹").replaceAll(":microscope:", "🔬").replaceAll(":gun:", "🔫").replaceAll(":pistol:", "🔫").replaceAll(":bomb:", "💣").replaceAll(":boom:", "💣").replaceAll(":call:", "📞").replaceAll(":phone:", "📞").replaceAll(":telephone:", "☎").replaceAll(":battery:", "🔋").replaceAll(":music-disc:", "💿").replaceAll(":disc:", "💿").replaceAll(":music:", "💿").replaceAll(":film:", "📽").replaceAll(":money:", "💰").replaceAll(":\\$:", "💰").replaceAll(":pin:", "📌").replaceAll(":shears:", "✂").replaceAll(":scissors:", "✂").replaceAll(":trash:", "🗑").replaceAll(":alarm:", "⏰").replaceAll(":time:", "⏰").replaceAll(":hourglass:", "⏳");
/* 69 */     event.message = message;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/Emotes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */