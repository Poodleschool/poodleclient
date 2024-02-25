/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.game.SendMessageEvent;
/*    */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ 
/*    */ public class FancyChat extends Module {
/*    */   private final SettingGroup sgGeneral;
/*    */   
/*    */   public FancyChat() {
/* 13 */     super(Addon.CATEGORY, "fancy-chat", "Adds style to your messages.");
/*    */ 
/*    */     
/* 16 */     this.sgGeneral = this.settings.getDefaultGroup();
/*    */     
/* 18 */     this.mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/* 19 */         .name("mode"))
/* 20 */         .description("Select a chat style mode."))
/* 21 */         .defaultValue(Modes.Italic))
/* 22 */         .build());
/*    */   }
/*    */   private final Setting<Modes> mode;
/*    */   @EventHandler
/*    */   private void OnMessage(SendMessageEvent event) {
/* 27 */     String msg = event.message;
/* 28 */     switch ((Modes)this.mode.get()) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case Italic:
/* 35 */         msg = msg.replaceAll("a", "𝑎").replaceAll("b", "𝑏").replaceAll("c", "𝑐").replaceAll("d", "𝑑").replaceAll("e", "𝑒").replaceAll("f", "𝑓").replaceAll("g", "𝑔").replaceAll("h", "ℎ").replaceAll("i", "𝑖").replaceAll("j", "𝑗").replaceAll("k", "𝑘").replaceAll("l", "𝑙").replaceAll("m", "𝑚").replaceAll("n", "𝑛").replaceAll("o", "𝑜").replaceAll("p", "𝑝").replaceAll("q", "𝑞").replaceAll("r", "𝑟").replaceAll("s", "𝑠").replaceAll("t", "𝑡").replaceAll("u", "𝑢").replaceAll("v", "𝑣").replaceAll("w", "𝑤").replaceAll("x", "𝑥").replaceAll("y", "𝑦").replaceAll("z", "𝑧");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case Bold:
/* 43 */         msg = msg.replaceAll("a", "𝗮").replaceAll("b", "𝗯").replaceAll("c", "𝗰").replaceAll("d", "𝗱").replaceAll("e", "𝗲").replaceAll("f", "𝗳").replaceAll("g", "𝗴").replaceAll("h", "𝗵").replaceAll("i", "𝗶").replaceAll("j", "𝗷").replaceAll("k", "𝗸").replaceAll("l", "𝗹").replaceAll("m", "𝗺").replaceAll("n", "𝗻").replaceAll("o", "𝗼").replaceAll("p", "𝗽").replaceAll("q", "𝗾").replaceAll("r", "𝗿").replaceAll("s", "𝘀").replaceAll("t", "𝘁").replaceAll("u", "𝘂").replaceAll("v", "𝘃").replaceAll("w", "𝘄").replaceAll("x", "𝘅").replaceAll("y", "𝘆").replaceAll("z", "𝘇");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case RPG:
/* 51 */         msg = msg.replaceAll("a", "𝔞").replaceAll("b", "𝔟").replaceAll("c", "𝔠").replaceAll("d", "𝔡").replaceAll("e", "𝔢").replaceAll("f", "𝔣").replaceAll("g", "𝔤").replaceAll("h", "𝔥").replaceAll("i", "𝔦").replaceAll("j", "𝔧").replaceAll("k", "𝔨").replaceAll("l", "𝔩").replaceAll("m", "𝔪").replaceAll("n", "𝔫").replaceAll("o", "𝔬").replaceAll("p", "𝔭").replaceAll("q", "𝔮").replaceAll("r", "𝔯").replaceAll("s", "𝔰").replaceAll("t", "𝔱").replaceAll("u", "𝔲").replaceAll("v", "𝔳").replaceAll("w", "𝔴").replaceAll("x", "𝔵").replaceAll("y", "𝔶").replaceAll("z", "𝔷");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case Wurst:
/* 59 */         msg = msg.replaceAll("a", "𝚊").replaceAll("b", "𝚋").replaceAll("c", "𝚌").replaceAll("d", "𝚍").replaceAll("e", "𝚎").replaceAll("f", "𝚏").replaceAll("g", "𝚐").replaceAll("h", "𝚑").replaceAll("i", "𝚒").replaceAll("j", "𝚓").replaceAll("k", "𝚔").replaceAll("l", "𝚕").replaceAll("m", "𝚖").replaceAll("n", "𝚗").replaceAll("o", "𝚘").replaceAll("p", "𝚙").replaceAll("q", "𝚚").replaceAll("r", "𝚛").replaceAll("s", "𝚜").replaceAll("t", "𝚝").replaceAll("u", "𝚞").replaceAll("v", "𝚟").replaceAll("w", "𝚠").replaceAll("x", "𝚡").replaceAll("y", "𝚢").replaceAll("z", "𝚣");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case Billboard:
/* 67 */         msg = msg.replaceAll("a", "𝕒").replaceAll("b", "𝕓").replaceAll("c", "𝕔").replaceAll("d", "𝕕").replaceAll("e", "𝕖").replaceAll("f", "𝕗").replaceAll("g", "𝕘").replaceAll("h", "𝕙").replaceAll("i", "𝕚").replaceAll("j", "𝕛").replaceAll("k", "𝕜").replaceAll("l", "𝕝").replaceAll("m", "𝕞").replaceAll("n", "𝕟").replaceAll("o", "𝕠").replaceAll("p", "𝕡").replaceAll("q", "𝕢").replaceAll("r", "𝕣").replaceAll("s", "𝕤").replaceAll("t", "𝕥").replaceAll("u", "𝕦").replaceAll("v", "𝕧").replaceAll("w", "𝕨").replaceAll("x", "𝕩").replaceAll("y", "𝕪").replaceAll("z", "𝕫");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case Cursive:
/* 75 */         msg = msg.replaceAll("a", "𝒶").replaceAll("b", "𝒷").replaceAll("c", "𝒸").replaceAll("d", "𝒹").replaceAll("e", "𝑒").replaceAll("f", "𝒻").replaceAll("g", "𝑔").replaceAll("h", "𝒽").replaceAll("i", "𝒾").replaceAll("j", "𝒿").replaceAll("k", "𝓀").replaceAll("l", "𝓁").replaceAll("m", "𝓂").replaceAll("n", "𝓃").replaceAll("o", "𝑜").replaceAll("p", "𝓅").replaceAll("q", "𝓆").replaceAll("r", "𝓇").replaceAll("s", "𝓈").replaceAll("t", "𝓉").replaceAll("u", "𝓊").replaceAll("v", "𝓋").replaceAll("w", "𝓌").replaceAll("x", "𝓍").replaceAll("y", "𝓎").replaceAll("z", "𝓏");
/*    */         break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       case SmallCaps:
/* 83 */         msg = msg.replaceAll("a", "ᴀ").replaceAll("b", "ʙ").replaceAll("c", "ᴄ").replaceAll("d", "ᴅ").replaceAll("e", "ᴇ").replaceAll("f", "ꜰ").replaceAll("g", "ɢ").replaceAll("h", "ʜ").replaceAll("i", "ɪ").replaceAll("j", "ᴊ").replaceAll("k", "ᴋ").replaceAll("l", "ʟ").replaceAll("m", "ᴍ").replaceAll("n", "ɴ").replaceAll("o", "ᴏ").replaceAll("p", "ᴘ").replaceAll("q", "ǫ").replaceAll("r", "ʀ").replaceAll("s", "ꜱ").replaceAll("t", "ᴛ").replaceAll("u", "ᴜ").replaceAll("v", "ᴠ").replaceAll("w", "ᴡ").replaceAll("x", "x").replaceAll("y", "ʏ").replaceAll("z", "ᴢ"); break;
/*    */     } 
/* 85 */     event.message = msg;
/*    */   }
/*    */   
/*    */   public enum Modes {
/* 89 */     Italic,
/* 90 */     Bold,
/* 91 */     RPG,
/* 92 */     Wurst,
/* 93 */     SmallCaps,
/* 94 */     Billboard,
/* 95 */     Cursive;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/FancyChat.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */