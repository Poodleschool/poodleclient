/*    */ package de.Jakob.navine.commands;
/*    */ 
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ import meteordevelopment.meteorclient.commands.Command;
/*    */ import meteordevelopment.meteorclient.utils.network.MeteorExecutor;
/*    */ import net.minecraft.class_2172;
/*    */ import net.minecraft.class_310;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.client.methods.CloseableHttpResponse;
/*    */ import org.apache.http.client.methods.HttpPost;
/*    */ import org.apache.http.client.methods.HttpUriRequest;
/*    */ import org.apache.http.entity.ContentType;
/*    */ import org.apache.http.entity.mime.MultipartEntityBuilder;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClients;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.PointerBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.util.tinyfd.TinyFileDialogs;
/*    */ 
/*    */ public class SetSkinCommand extends Command {
/*    */   private final PointerBuffer filters;
/*    */   
/* 29 */   public SetSkinCommand() { super("setskin", "Change your skin :D", new String[0]);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     this.filters = BufferUtils.createPointerBuffer(1);
/*    */     ByteBuffer txtFilter = MemoryUtil.memASCII("*.png");
/*    */     this.filters.put(txtFilter);
/*    */     this.filters.rewind(); } public void build(LiteralArgumentBuilder<class_2172> builder) {
/* 39 */     builder.then(literal("slim").executes(context -> {
/*    */             String file = TinyFileDialogs.tinyfd_openFileDialog("Select Skin", null, this.filters, "image files", false);
/*    */             
/*    */             if (file == null) {
/*    */               return 1;
/*    */             }
/*    */             
/*    */             MeteorExecutor.execute(());
/*    */             
/*    */             return 1;
/*    */           }));
/* 50 */     builder.then(literal("classic").executes(context -> {
/*    */             String file = TinyFileDialogs.tinyfd_openFileDialog("Select Skin", null, this.filters, "image files", false);
/*    */             if (file == null) {
/*    */               return 1;
/*    */             }
/*    */             MeteorExecutor.execute(());
/*    */             return 1;
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setSkin(File f, boolean slim) {
/*    */     try {
/* 64 */       CloseableHttpClient httpClient = HttpClients.createDefault();
/* 65 */       HttpPost uploadFile = new HttpPost("https://api.minecraftservices.com/minecraft/profile/skins");
/*    */       
/* 67 */       uploadFile.addHeader("Authorization", "Bearer " + class_310.method_1551().method_1548().method_1674());
/*    */       
/* 69 */       MultipartEntityBuilder builder = MultipartEntityBuilder.create();
/*    */       
/* 71 */       builder.addTextBody("variant", slim ? "slim" : "classic", ContentType.TEXT_PLAIN);
/*    */       
/* 73 */       builder.addBinaryBody("file", new FileInputStream(f), ContentType.APPLICATION_OCTET_STREAM, f
/*    */ 
/*    */ 
/*    */           
/* 77 */           .getName());
/*    */ 
/*    */       
/* 80 */       HttpEntity multipart = builder.build();
/* 81 */       uploadFile.setEntity(multipart);
/* 82 */       CloseableHttpResponse response = httpClient.execute((HttpUriRequest)uploadFile);
/* 83 */       HttpEntity responseEntity = response.getEntity();
/* 84 */       httpClient.close();
/* 85 */     } catch (Exception e) {
/* 86 */       error(e.getLocalizedMessage(), new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/commands/SetSkinCommand.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */