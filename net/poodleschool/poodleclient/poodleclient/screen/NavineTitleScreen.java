/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.HWID;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.RPCClient;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.config.NavineConfig;
/*     */ import net.poodleschool.poodleclient.packets.AuthResultPacket;
/*     */ import net.poodleschool.poodleclient.packets.LoginPacket;
/*     */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import ladysnake.satin.api.managed.ManagedShaderEffect;
/*     */ import ladysnake.satin.api.managed.ShaderEffectManager;
/*     */ import meteordevelopment.meteorclient.gui.GuiThemes;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import net.fabricmc.loader.api.FabricLoader;
/*     */ import net.fabricmc.loader.api.ModContainer;
/*     */ import net.minecraft.class_1113;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_286;
/*     */ import net.minecraft.class_287;
/*     */ import net.minecraft.class_289;
/*     */ import net.minecraft.class_293;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_332;
/*     */ import net.minecraft.class_3417;
/*     */ import net.minecraft.class_4325;
/*     */ import net.minecraft.class_437;
/*     */ import net.minecraft.class_4749;
/*     */ import net.minecraft.class_500;
/*     */ import net.minecraft.class_5250;
/*     */ import net.minecraft.class_526;
/*     */ import net.minecraft.class_5348;
/*     */ import net.minecraft.class_6880;
/*     */ import net.minecraft.class_757;
/*     */ import org.joml.Matrix4f;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ 
/*     */ public class NavineTitleScreen extends class_437 {
/*  43 */   private final List<class_5250> options = new ArrayList<>();
/*     */   
/*     */   private class_5250 SINGLE_PLAYER;
/*     */   
/*     */   private class_5250 MULTI_PLAYER;
/*     */   private class_5250 REALMS;
/*     */   private class_5250 OPTIONS;
/*     */   private class_5250 QUIT;
/*  51 */   private static int color = (new Color(50, 168, 100)).getPacked(); private static final ManagedShaderEffect blur;
/*     */   static {
/*  53 */     blur = ShaderEffectManager.getInstance().manage(new class_2960("shaders/post/blur.json"), shader -> shader.setUniformValue("Radius", (NavineConfig.get()).blurStrength));
/*     */   }
/*     */   
/*     */   public NavineTitleScreen(class_2561 title) {
/*  57 */     super(title);
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
/* 274 */     this.a = (() -> Boolean.valueOf(loggedIn));
/*     */     
/* 276 */     this.loginFail = (() -> LoginFailPrompt.create(GuiThemes.get(), this.field_22787.field_1755).id("navine-login-fail").title("Navine Login").message("Failed to log you in.").onOk().show());
/*     */     try {
/*     */       Optional<ModContainer> optional = FabricLoader.getInstance().getModContainer("navine-client");
/*     */       if (optional.isEmpty())
/*     */         return; 
/*     */       String str = ((ModContainer)optional.get()).getMetadata().getCustomValue("meteor-client:color").getAsString();
/*     */       Color clr = new Color(color);
/*     */       clr.parse(str);
/*     */       color = clr.getPacked();
/*     */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   private static boolean loggedIn = false;
/*     */   private static boolean HAS_REGISTERED_HANDLER = false;
/*     */   public final Supplier<Boolean> a;
/*     */   private final Runnable loginFail;
/*     */   
/*     */   public static void addShutdownHandler() {
/*     */     RPCClient.addShutdownHandler(() -> HAS_REGISTERED_HANDLER = false);
/*     */   }
/*     */   
/*     */   protected void method_25426() {
/*     */     this.options.clear();
/*     */     blur.setUniformValue("Radius", (NavineConfig.get()).blurStrength);
/*     */     if (!HAS_REGISTERED_HANDLER && RPCClient.isRPCActive() && RPCClient.getClient() != null)
/*     */       RPCClient.addLoginHandler(authResult -> {
/*     */             if (authResult.getResult() == AuthResultPacket.AuthResult.SUCCESS) {
/*     */               loggedIn = true;
/*     */             } else {
/*     */               this.loginFail.run();
/*     */             } 
/*     */           }); 
/*     */     if (loggedIn) {
/*     */       this.options.add(this.SINGLE_PLAYER = class_2561.method_43471("menu.singleplayer"));
/*     */       this.options.add(this.MULTI_PLAYER = class_2561.method_43471("menu.multiplayer"));
/*     */       this.options.add(this.REALMS = class_2561.method_43471("menu.online"));
/*     */       this.options.add(this.OPTIONS = class_2561.method_43471("menu.options"));
/*     */     } else {
/*     */       this.options.add(class_2561.method_43470("Copy HWID"));
/*     */       this.options.add(class_2561.method_43470("Login"));
/*     */       this.options.add(class_2561.method_43470("Announcements"));
/*     */     } 
/*     */     this.options.add(this.QUIT = class_2561.method_43471("menu.quit"));
/*     */   }
/*     */   
/*     */   private void drawTexture(class_332 ctx, class_2960 texture, float x, float y, float z, float u, float v, float width, float height, float textureWidth, float textureHeight) {
/*     */     drawTexture(ctx, texture, x, x + width, y, y + height, z, width, height, u, v, textureWidth, textureHeight);
/*     */   }
/*     */   
/*     */   private void drawTexture(class_332 ctx, class_2960 texture, float x1, float x2, float y1, float y2, float z, float regionWidth, float regionHeight, float u, float v, float textureWidth, float textureHeight) {
/*     */     drawTexturedQuad(ctx, texture, x1, x2, y1, y2, z, (u + 0.0F) / textureWidth, (u + regionWidth) / textureWidth, (v + 0.0F) / textureHeight, (v + regionHeight) / textureHeight);
/*     */   }
/*     */   
/*     */   private void drawTexturedQuad(class_332 ctx, class_2960 texture, float x1, float x2, float y1, float y2, float z, float u1, float u2, float v1, float v2) {
/*     */     RenderSystem.setShaderTexture(0, texture);
/*     */     RenderSystem.setShader(class_757::method_34542);
/*     */     Matrix4f matrix4f = ctx.method_51448().method_23760().method_23761();
/*     */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*     */     bufferBuilder.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
/*     */     bufferBuilder.method_22918(matrix4f, x1, y1, z).method_22913(u1, v1).method_1344();
/*     */     bufferBuilder.method_22918(matrix4f, x1, y2, z).method_22913(u1, v2).method_1344();
/*     */     bufferBuilder.method_22918(matrix4f, x2, y2, z).method_22913(u2, v2).method_1344();
/*     */     bufferBuilder.method_22918(matrix4f, x2, y1, z).method_22913(u2, v1).method_1344();
/*     */     class_286.method_43433(bufferBuilder.method_1326());
/*     */   }
/*     */   
/*     */   public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
/*     */     super.method_25394(context, mouseX, mouseY, delta);
/*     */     int imgWidth = 3840;
/*     */     int imgHeight = 2160;
/*     */     double scaleX = this.field_22789 / imgWidth;
/*     */     double scaleY = this.field_22790 / imgHeight;
/*     */     double scale = Math.max(scaleX, scaleY);
/*     */     int w = (int)(scale * imgWidth), h = (int)(scale * imgHeight);
/*     */     double centerMouseX = mouseX / this.field_22789 - 0.5D;
/*     */     double centerMouseY = mouseY / this.field_22790 - 0.5D;
/*     */     int offcenter = 20;
/*     */     drawTexture(context, class_2960.method_43902("navine", "sigma.png"), (float)(-offcenter + centerMouseX * offcenter / 2.0D), (float)(-offcenter + centerMouseY * offcenter / 2.0D), 0.0F, 0.0F, 0.0F, (float)((this.field_22789 + offcenter * 2) + centerMouseX * offcenter / 2.0D), (float)((this.field_22790 + offcenter * 2) + centerMouseY * offcenter / 2.0D), (w + offcenter * 2), (h + offcenter * 2));
/*     */     blur.render(delta);
/*     */     if (this.field_22787 == null)
/*     */       return; 
/*     */     int count = 0;
/*     */     for (class_5250 name : this.options) {
/*     */       if (name.equals(class_2561.method_43470("Login")) && loggedIn)
/*     */         method_25419(); 
/*     */       float x = this.field_22789 / this.options.size() * count + this.field_22789 / this.options.size() / 2.0F + 8.0F - this.field_22787.field_1772.method_27525((class_5348)name) / 2.0F;
/*     */       float y = this.field_22790 * (NavineConfig.get()).menuButtonPosition / 100.0F;
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       boolean hovered = (mouseX >= x && mouseY >= y && mouseX < x + this.field_22787.field_1772.method_27525((class_5348)name) && mouseY < y + 9.0F);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       context.method_25296(0, (int)(y + (9 / 2)), this.field_22789, (int)(y + (9 / 2)) + 10, 1879048192, 0);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       context.method_25296(0, (int)(y + (9 / 2)) - 10, this.field_22789, (int)(y + (9 / 2)), 0, 1879048192);
/*     */       context.method_27534(this.field_22787.field_1772, (class_2561)name, this.field_22789 / this.options.size() * count + this.field_22789 / this.options.size() / 2 + 8, (int)y, hovered ? color : -1);
/*     */       count++;
/*     */     } 
/*     */     if (!loggedIn) {
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       context.method_25300(this.field_22787.field_1772, "You are not authenticated!", this.field_22789 / 2, this.field_22790 / 2 - 9 / 2, -1);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       context.method_25300(this.field_22787.field_1772, "(recode build)", this.field_22789 / 2, this.field_22790 / 2 - 9 / 2 + 9, -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean method_25402(double mouseX, double mouseY, int button) {
/*     */     boolean result = false;
/*     */     if (this.field_22787 == null)
/*     */       return false; 
/*     */     int count = 0;
/*     */     for (class_5250 name : this.options) {
/*     */       float x = this.field_22789 / this.options.size() * count + this.field_22789 / this.options.size() / 2.0F + 8.0F - this.field_22787.field_1772.method_27525((class_5348)name) / 2.0F;
/*     */       float y = this.field_22790 * (NavineConfig.get()).menuButtonPosition / 100.0F;
/*     */       Objects.requireNonNull(this.field_22787.field_1772);
/*     */       if (mouseX >= x && mouseY >= y && mouseX < (x + this.field_22787.field_1772.method_27525((class_5348)name)) && mouseY < (y + 9.0F))
/*     */         if (name.equals(this.SINGLE_PLAYER)) {
/*     */           result = true;
/*     */           this.field_22787.method_1507((class_437)new class_526(this));
/*     */         } else if (name.equals(this.MULTI_PLAYER)) {
/*     */           result = true;
/*     */           class_437 screen = this.field_22787.field_1690.field_21840 ? (class_437)new class_500(this) : (class_437)new class_4749(this);
/*     */           this.field_22787.method_1507(screen);
/*     */         } else if (name.equals(this.REALMS)) {
/*     */           result = true;
/*     */           this.field_22787.method_1507((class_437)new class_4325(this));
/*     */         } else if (name.equals(this.OPTIONS)) {
/*     */           result = true;
/*     */           this.field_22787.method_1507((class_437)new class_429(this, this.field_22787.field_1690));
/*     */         } else if (name.equals(this.QUIT)) {
/*     */           result = true;
/*     */           this.field_22787.method_1592();
/*     */         } else if (name.equals(class_2561.method_43470("Copy HWID"))) {
/*     */           result = true;
/*     */           String forClipboard = HWID.bytesToHex(HWID.generateHWID());
/*     */           ByteBuffer buffer = MemoryUtil.memUTF8(forClipboard);
/*     */           try {
/*     */             GLFW.glfwSetClipboardString(class_310.method_1551().method_22683().method_4490(), buffer);
/*     */           } finally {
/*     */             MemoryUtil.memFree(buffer);
/*     */           } 
/*     */         } else if (name.equals(class_2561.method_43470("Continue"))) {
/*     */           result = true;
/*     */           LoginPrompt.create().id("navine-login").message("Please login to use Navine.").title("Navine Login").onSubmit(this::check).show();
/*     */         } else if (name.equals(class_2561.method_43470("Announcements"))) {
/*     */           WarningPrompt.create().id("navine-warning").title("Navine Announcements").message("No current announcements!").show();
/*     */         }  
/*     */       count++;
/*     */     } 
/*     */     if (result)
/*     */       this.field_22787.method_1483().method_4873((class_1113)class_1109.method_47978((class_6880)class_3417.field_15015, 1.0F)); 
/*     */     return result;
/*     */   }
/*     */   
/*     */   public boolean method_25422() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   private void check(String username, boolean free) {
/*     */     if (free) {
/*     */       loggedIn = true;
/*     */       method_25419();
/*     */       return;
/*     */     } 
/*     */     if (!StringUtils.isAlphanumeric(username)) {
/*     */       this.loginFail.run();
/*     */       return;
/*     */     } 
/*     */     if (RPCClient.isRPCActive() && RPCClient.getClient() != null && RPCClient.getClient().isConnected())
/*     */       RPCClient.getClient().sendPacket((EmptyPacket)new LoginPacket(username, HWID.bytesToHex(HWID.generateHWID()))); 
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/NavineTitleScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */