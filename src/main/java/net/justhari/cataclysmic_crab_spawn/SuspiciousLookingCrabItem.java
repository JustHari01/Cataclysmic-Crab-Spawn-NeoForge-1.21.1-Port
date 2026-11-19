package net.justhari.cataclysmic_crab_spawn;

import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public final class SuspiciousLookingCrabItem extends Item {
    private static final String SUMMON_COMMAND = "summon cataclysm:amethyst_crab ^ ^5 ^5";

    public SuspiciousLookingCrabItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        tooltip.add(Component.translatable("item.cataclysmic_crab_spawn.suspicious_looking_crab.description_0")
                .withStyle(ChatFormatting.DARK_GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> result = super.use(level, player, hand);
        ItemStack usedStack = result.getObject();

        if (level.isClientSide) {
            Minecraft.getInstance().gameRenderer.displayItemActivation(usedStack);
            level.playLocalSound(player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BEACON_POWER_SELECT, SoundSource.MASTER, 1.0F, 1.0F, false);
        } else if (level instanceof ServerLevel serverLevel) {
            CommandSourceStack source = serverLevel.getServer().createCommandSourceStack()
                    .withPosition(new Vec3(player.getX(), player.getY(), player.getZ()))
                    .withRotation(Vec2.ZERO)
                    .withLevel(serverLevel)
                    .withPermission(4)
                    .withSuppressedOutput();
            serverLevel.getServer().getCommands().performPrefixedCommand(source, SUMMON_COMMAND);
            serverLevel.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()),
                    SoundEvents.BEACON_POWER_SELECT, SoundSource.MASTER, 1.0F, 1.0F);
        }

        return result;
    }
}
