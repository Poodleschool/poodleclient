/*    */ package net.poodleschool.poodleclient.poodleclient.screen;
/*    */ 
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import meteordevelopment.meteorclient.MeteorClient;
/*    */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*    */ import meteordevelopment.meteorclient.gui.GuiThemes;
/*    */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*    */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WVerticalList;
/*    */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*    */ import meteordevelopment.meteorclient.systems.config.Config;
/*    */ import net.minecraft.class_156;
/*    */ import net.minecraft.class_437;
/*    */ 
/*    */ 
/*    */ public class WarningPrompt
/*    */ {
/*    */   private final GuiTheme theme;
/*    */   private final class_437 parent;
/* 22 */   private String title = "";
/* 23 */   private final List<String> messages = new ArrayList<>();
/* 24 */   private String id = null;
/*    */   
/*    */   private WarningPrompt() {
/* 27 */     this(GuiThemes.get(), MeteorClient.mc.field_1755);
/*    */   }
/*    */   
/*    */   private WarningPrompt(GuiTheme theme, class_437 parent) {
/* 31 */     this.theme = theme;
/* 32 */     this.parent = parent;
/*    */   }
/*    */   
/*    */   public static WarningPrompt create() {
/* 36 */     return new WarningPrompt();
/*    */   }
/*    */   
/*    */   public static WarningPrompt create(GuiTheme theme, class_437 parent) {
/* 40 */     return new WarningPrompt(theme, parent);
/*    */   }
/*    */   
/*    */   public WarningPrompt title(String title) {
/* 44 */     this.title = title;
/* 45 */     return this;
/*    */   }
/*    */   
/*    */   public WarningPrompt message(String message) {
/* 49 */     this.messages.add(message);
/* 50 */     return this;
/*    */   }
/*    */   
/*    */   public WarningPrompt message(String message, Object... args) {
/* 54 */     this.messages.add(String.format(message, args));
/* 55 */     return this;
/*    */   }
/*    */   
/*    */   public WarningPrompt id(String from) {
/* 59 */     this.id = from;
/* 60 */     return this;
/*    */   }
/*    */   
/*    */   public void show() {
/* 64 */     if (this.id == null) id(this.title); 
/* 65 */     if ((Config.get()).dontShowAgainPrompts.contains(this.id))
/*    */       return; 
/* 67 */     if (!RenderSystem.isOnRenderThread()) {
/* 68 */       RenderSystem.recordRenderCall(() -> MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme)));
/*    */     } else {
/*    */       
/* 71 */       MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme));
/*    */     } 
/*    */   }
/*    */   
/*    */   private class PromptScreen extends WindowScreen {
/*    */     public PromptScreen(GuiTheme theme) {
/* 77 */       super(theme, WarningPrompt.this.title);
/*    */       
/* 79 */       this.parent = WarningPrompt.this.parent;
/*    */     }
/*    */ 
/*    */     
/*    */     public void initWidgets() {
/* 84 */       for (String line : WarningPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/* 85 */       add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*    */       
/* 87 */       WVerticalList list = (WVerticalList)add((WWidget)this.theme.verticalList()).expandX().widget();
/*    */       
/* 89 */       WButton joinDiscordButton = (WButton)list.add((WWidget)this.theme.button("Join Official Discord")).expandX().widget();
/* 90 */       WButton closeButton = (WButton)list.add((WWidget)this.theme.button("Close")).expandX().widget();
/*    */       
/* 92 */       joinDiscordButton.action = (() -> class_156.method_668().method_670(new String(new byte[] { 
/*    */               104, 116, 116, 112, 115, 58, 47, 47, 100, 105, 
/*    */               115, 99, 111, 114, 100, 46, 103, 103, 47, 54, 
/*    */               102, 113, 99, 50, 100, 54, 50, 67, 112 })));
/* 96 */       closeButton.action = this::method_25419;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/WarningPrompt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */