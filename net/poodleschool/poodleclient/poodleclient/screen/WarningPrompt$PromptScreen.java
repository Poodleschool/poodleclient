/*    */ package net.poodleschool.poodleclient.poodleclient.screen;
/*    */ 
/*    */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*    */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*    */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WVerticalList;
/*    */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*    */ import net.minecraft.class_156;
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
/*    */ class PromptScreen
/*    */   extends WindowScreen
/*    */ {
/*    */   public PromptScreen(GuiTheme theme) {
/* 77 */     super(theme, paramWarningPrompt.title);
/*    */     
/* 79 */     this.parent = paramWarningPrompt.parent;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initWidgets() {
/* 84 */     for (String line : WarningPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/* 85 */     add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*    */     
/* 87 */     WVerticalList list = (WVerticalList)add((WWidget)this.theme.verticalList()).expandX().widget();
/*    */     
/* 89 */     WButton joinDiscordButton = (WButton)list.add((WWidget)this.theme.button("Join Official Discord")).expandX().widget();
/* 90 */     WButton closeButton = (WButton)list.add((WWidget)this.theme.button("Close")).expandX().widget();
/*    */     
/* 92 */     joinDiscordButton.action = (() -> class_156.method_668().method_670(new String(new byte[] { 
/*    */             104, 116, 116, 112, 115, 58, 47, 47, 100, 105, 
/*    */             115, 99, 111, 114, 100, 46, 103, 103, 47, 54, 
/*    */             102, 113, 99, 50, 100, 54, 50, 67, 112 })));
/* 96 */     closeButton.action = this::method_25419;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/WarningPrompt$PromptScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */