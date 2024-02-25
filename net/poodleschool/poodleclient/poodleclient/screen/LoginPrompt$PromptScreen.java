/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ 
/*     */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*     */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WVerticalList;
/*     */ import meteordevelopment.meteorclient.gui.widgets.input.WTextBox;
/*     */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PromptScreen
/*     */   extends WindowScreen
/*     */ {
/*     */   public PromptScreen(GuiTheme theme) {
/*  85 */     super(theme, paramLoginPrompt.title);
/*     */     
/*  87 */     this.parent = paramLoginPrompt.parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initWidgets() {
/*  92 */     for (String line : LoginPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/*  93 */     add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*     */     
/*  95 */     WVerticalList list = (WVerticalList)add((WWidget)this.theme.verticalList()).expandX().widget();
/*     */     
/*  97 */     WTextBox textBox = (WTextBox)list.add((WWidget)this.theme.textBox("", "Enter username", (text, c) -> (Character.isLetterOrDigit(c) || c == '_'))).expandX().widget();
/*  98 */     WButton submitButton = (WButton)list.add((WWidget)this.theme.button("Submit")).expandX().widget();
/*  99 */     WButton withoutButton = (WButton)list.add((WWidget)this.theme.button("Continue without login")).expandX().widget();
/*     */     
/* 101 */     submitButton.action = (() -> {
/*     */         LoginPrompt.this.onSubmit.accept(textBox.get(), Boolean.valueOf(false));
/*     */         
/*     */         method_25419();
/*     */       });
/* 106 */     withoutButton.action = (() -> {
/*     */         LoginPrompt.this.onSubmit.accept("free", Boolean.valueOf(true));
/*     */         method_25419();
/*     */       });
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/LoginPrompt$PromptScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */