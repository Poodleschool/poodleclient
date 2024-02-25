/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.mixins.ChatUtilsAccessor;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.settings.StringSetting;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.utils.player.ChatUtils;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.kyori.adventure.platform.fabric.FabricClientAudiences;
/*    */ import net.kyori.adventure.text.minimessage.MiniMessage;
/*    */ import net.minecraft.class_2561;
/*    */ 
/*    */ public class ChatPrefix
/*    */   extends Module {
/* 18 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private class_2561 curFormat;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Setting<String> format;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChatPrefix() {
/* 38 */     super(Addon.CATEGORY, "chat-prefix", "Change the meteor chat prefix"); this.format = this.sgGeneral.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder()).name("format")).description("The chat format")).defaultValue("  <dark_gray>|</dark_gray> <hover:show_text:'<gradient:#084CFB:#B786FD>Made with <red>❤</red> by Jakob'><gradient:#084CFB:#B786FD><bold>ɴᴀᴠɪɴᴇ</bold>³</gradient></hover> <dark_gray>» </dark_gray>")).onChanged(str -> { this.curFormat = FabricClientAudiences.of().toNative(MiniMessage.miniMessage().deserialize(str)); ChatUtilsAccessor.setPrefix(this.curFormat); ChatUtils.info("Prefix changed!", new Object[0]);
/* 39 */           })).wide().build()); if (!isActive())
/* 40 */       toggle(); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre ignored) {
/* 45 */     if (this.curFormat == null)
/* 46 */       this.format.onChanged(); 
/* 47 */     ChatUtilsAccessor.setPrefix(this.curFormat);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/ChatPrefix.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */