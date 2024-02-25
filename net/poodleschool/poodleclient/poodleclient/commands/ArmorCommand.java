/*    */ package de.Jakob.navine.commands;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import meteordevelopment.meteorclient.commands.Command;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1713;
/*    */ import net.minecraft.class_2172;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class ArmorCommand extends Command {
/*    */   public ArmorCommand() {
/* 13 */     super("armor", "Allows you to move an item to your armor slot.", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void build(LiteralArgumentBuilder<class_2172> builder) {
/* 18 */     class_310 mc = class_310.method_1551();
/* 19 */     builder.then(literal("helmet").executes(ctx -> {
/*    */             mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, 36 + (mc.field_1724.method_31548()).field_7545, 39, class_1713.field_7791, (class_1657)mc.field_1724);
/*    */             return 1;
/*    */           }));
/* 23 */     builder.then(literal("chestplate").executes(ctx -> {
/*    */             mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, 36 + (mc.field_1724.method_31548()).field_7545, 38, class_1713.field_7791, (class_1657)mc.field_1724);
/*    */             return 1;
/*    */           }));
/* 27 */     builder.then(literal("leggings").executes(ctx -> {
/*    */             mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, 36 + (mc.field_1724.method_31548()).field_7545, 37, class_1713.field_7791, (class_1657)mc.field_1724);
/*    */             return 1;
/*    */           }));
/* 31 */     builder.then(literal("boots").executes(ctx -> {
/*    */             mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, 36 + (mc.field_1724.method_31548()).field_7545, 36, class_1713.field_7791, (class_1657)mc.field_1724);
/*    */             return 1;
/*    */           }));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/commands/ArmorCommand.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */