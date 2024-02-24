package com.example.mymod;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.world.GameMode;

public class MyMod implements ModInitializer {

    @Override
    public void onInitialize() {
        registerCommands();
    }

    private void registerCommands() {
        // Register the .give command
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
                dispatcher.register(CommandManager.literal("give").executes(context -> {
                    executeGiveCommand(context.getSource());
                    return 1;
                }))
        );

        // Register the .gamemode command
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
                dispatcher.register(CommandManager.literal("gamemode").executes(context -> {
                    executeGamemodeCommand(context.getSource());
                    return 1;
                }))
        );

        // Register the OP module command
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
                dispatcher.register(CommandManager.literal("op").executes(context -> {
                    executeOpCommand(context.getSource());
                    return 1;
                }))
        );
    }

    private void executeGiveCommand(ServerCommandSource source) {
        // Your custom logic for the .give command here
        // For example, give the player a diamond sword
        ItemStack diamondSword = new ItemStack(net.minecraft.item.Items.DIAMOND_SWORD);
        source.getPlayer().getInventory().offerOrDrop(diamondSword);
        source.sendFeedback(new LiteralText("Given a Diamond Sword to the player."), false);
    }

    private void executeGamemodeCommand(ServerCommandSource source) {
        // Your custom logic for the .gamemode command here
        // For example, switch the player's gamemode between survival and creative
        GameMode currentMode = source.getPlayer().interactionManager.getGameMode();
        GameMode newMode = (currentMode == GameMode.SURVIVAL) ? GameMode.CREATIVE : GameMode.SURVIVAL;
        source.getPlayer().interactionManager.setGameMode(newMode);
        source.sendFeedback(new LiteralText("Changed gamemode."), false);
    }

    private void executeOpCommand(ServerCommandSource source) {
        // Your custom logic for the "op" command here
        // For example, make the player an operator
        GameProfile gameProfile = source.getPlayer().getGameProfile();
        source.getMinecraftServer().getPlayerManager().addToOperators(gameProfile);
        source.sendFeedback(new LiteralText("Player is now an operator."), false);
    }
}
