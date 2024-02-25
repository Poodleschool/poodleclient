/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ 
/*     */ import net.poodleschool.poodleclient.poodleclient.util.HWID;
/*     */ import java.nio.ByteBuffer;
/*     */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*     */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WHorizontalList;
/*     */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*     */ import net.minecraft.class_310;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*  88 */     super(theme, paramLoginFailPrompt.title);
/*     */     
/*  90 */     this.parent = paramLoginFailPrompt.parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initWidgets() {
/*  95 */     this.window.width = 200.0D;
/*  96 */     this.window.height = 150.0D;
/*  97 */     for (String line : LoginFailPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/*  98 */     add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*     */     
/* 100 */     WHorizontalList list = (WHorizontalList)add((WWidget)this.theme.horizontalList()).expandX().widget();
/*     */     
/* 102 */     WButton copyHwidButton = (WButton)list.add((WWidget)this.theme.button("Copy HWID")).expandX().widget();
/* 103 */     copyHwidButton.action = (() -> {
/*     */         String forClipboard = HWID.bytesToHex(HWID.generateHWID());
/*     */         
/*     */         ByteBuffer buffer = MemoryUtil.memUTF8(forClipboard);
/*     */         try {
/*     */           GLFW.glfwSetClipboardString(class_310.method_1551().method_22683().method_4490(), buffer);
/*     */         } finally {
/*     */           MemoryUtil.memFree(buffer);
/*     */         } 
/*     */         method_25419();
/*     */       });
/* 114 */     WButton okButton = (WButton)list.add((WWidget)this.theme.button("Ok")).expandX().widget();
/* 115 */     okButton.action = (() -> {
/*     */         LoginFailPrompt.this.onOk.run();
/*     */         method_25419();
/*     */       });
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/LoginFailPrompt$PromptScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */