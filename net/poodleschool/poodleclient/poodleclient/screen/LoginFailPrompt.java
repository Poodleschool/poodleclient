/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.HWID;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import meteordevelopment.meteorclient.MeteorClient;
/*     */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*     */ import meteordevelopment.meteorclient.gui.GuiThemes;
/*     */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WHorizontalList;
/*     */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*     */ import meteordevelopment.meteorclient.systems.config.Config;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_437;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ 
/*     */ 
/*     */ public class LoginFailPrompt
/*     */ {
/*     */   private final GuiTheme theme;
/*     */   private final class_437 parent;
/*  26 */   private String title = "";
/*  27 */   private final List<String> messages = new ArrayList<>();
/*  28 */   private String id = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private LoginFailPrompt() {
/*  33 */     this(GuiThemes.get(), MeteorClient.mc.field_1755);
/*     */   } private Runnable onOk = () -> {
/*     */     
/*     */     }; private LoginFailPrompt(GuiTheme theme, class_437 parent) {
/*  37 */     this.theme = theme;
/*  38 */     this.parent = parent;
/*     */   }
/*     */   
/*     */   public static LoginFailPrompt create() {
/*  42 */     return new LoginFailPrompt();
/*     */   }
/*     */   
/*     */   public static LoginFailPrompt create(GuiTheme theme, class_437 parent) {
/*  46 */     return new LoginFailPrompt(theme, parent);
/*     */   }
/*     */   
/*     */   public LoginFailPrompt title(String title) {
/*  50 */     this.title = title;
/*  51 */     return this;
/*     */   }
/*     */   
/*     */   public LoginFailPrompt message(String message) {
/*  55 */     this.messages.add(message);
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public LoginFailPrompt message(String message, Object... args) {
/*  60 */     this.messages.add(String.format(message, args));
/*  61 */     return this;
/*     */   }
/*     */   
/*     */   public LoginFailPrompt id(String from) {
/*  65 */     this.id = from;
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public LoginFailPrompt onOk(Runnable action) {
/*  70 */     this.onOk = action;
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   public void show() {
/*  75 */     if (this.id == null) id(this.title); 
/*  76 */     if ((Config.get()).dontShowAgainPrompts.contains(this.id))
/*     */       return; 
/*  78 */     if (!RenderSystem.isOnRenderThread()) {
/*  79 */       RenderSystem.recordRenderCall(() -> MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme)));
/*     */     } else {
/*     */       
/*  82 */       MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme));
/*     */     } 
/*     */   }
/*     */   
/*     */   private class PromptScreen extends WindowScreen {
/*     */     public PromptScreen(GuiTheme theme) {
/*  88 */       super(theme, LoginFailPrompt.this.title);
/*     */       
/*  90 */       this.parent = LoginFailPrompt.this.parent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initWidgets() {
/*  95 */       this.window.width = 200.0D;
/*  96 */       this.window.height = 150.0D;
/*  97 */       for (String line : LoginFailPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/*  98 */       add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*     */       
/* 100 */       WHorizontalList list = (WHorizontalList)add((WWidget)this.theme.horizontalList()).expandX().widget();
/*     */       
/* 102 */       WButton copyHwidButton = (WButton)list.add((WWidget)this.theme.button("Copy HWID")).expandX().widget();
/* 103 */       copyHwidButton.action = (() -> {
/*     */           String forClipboard = HWID.bytesToHex(HWID.generateHWID());
/*     */           
/*     */           ByteBuffer buffer = MemoryUtil.memUTF8(forClipboard);
/*     */           try {
/*     */             GLFW.glfwSetClipboardString(class_310.method_1551().method_22683().method_4490(), buffer);
/*     */           } finally {
/*     */             MemoryUtil.memFree(buffer);
/*     */           } 
/*     */           method_25419();
/*     */         });
/* 114 */       WButton okButton = (WButton)list.add((WWidget)this.theme.button("Ok")).expandX().widget();
/* 115 */       okButton.action = (() -> {
/*     */           LoginFailPrompt.this.onOk.run();
/*     */           method_25419();
/*     */         });
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/LoginFailPrompt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */