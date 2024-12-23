package com.code.aseoha.block.control;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants.Translations;
import net.tardis.mod.controls.XControl;
import net.tardis.mod.controls.YControl;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class YButton extends StoneButtonBlock {
    public YButton(Properties prop) {
        super(prop);
//        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @NotNull
    @Override
    public ActionResultType use(@NotNull BlockState state, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull PlayerEntity player, @NotNull Hand handIn, @NotNull BlockRayTraceResult hit) {
        if (!WorldHelper.isDimensionBlocked(worldIn)) {
            ConsoleTile console = (ConsoleTile)worldIn.getBlockEntity(TardisHelper.TARDIS_POS);
            if (!worldIn.isClientSide) {
                console.getControl(YControl.class).ifPresent((Control) -> {
                    Control.onRightClicked(console, player);
                });
                console.updateClient();
            }
            if ((Boolean)state.getValue(POWERED)) {
                return ActionResultType.CONSUME;
            } else {
                this.press(state, worldIn, pos);
                this.playSound(player, worldIn, pos, true);
                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            }
        } else if (WorldHelper.isDimensionBlocked(worldIn)) {
            player.displayClientMessage(Translations.NO_USE_OUTSIDE_TARDIS, true);
        }

        return ActionResultType.SUCCESS;

    }
}