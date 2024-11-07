package com.code.aseoha.client.renderers.exteriors;

import com.code.aseoha.client.models.exteriors.AlfieHudolinExterior;
import com.code.aseoha.client.models.exteriors.mk_two_davidson;
import com.code.aseoha.tileentities.exteriors.AlfieHudolinTile;
import com.code.aseoha.tileentities.exteriors.mk2_davidson;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.misc.WorldText;

@OnlyIn(Dist.CLIENT)
public class mk2_davidson_render extends ExteriorRenderer<mk2_davidson> {
    public static ResourceLocation TEXTURE = new ResourceLocation("aseoha", "textures/exteriors/mk2/mk2_davidson.png");
    public static mk_two_davidson MODEL = new mk_two_davidson();
    public static WorldText TEXT = new WorldText(0.87F, 0.125F, 0.015F, 0);

    public mk2_davidson_render(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    public void renderExterior(mk2_davidson tile, float v, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int i, int i1, float v1) {
        matrixStack.pushPose();
        matrixStack.translate(0.0, -2.5, 0.0);
        ResourceLocation texture = TEXTURE;
        if (tile.getVariant() != null) {
            texture = tile.getVariant().getTexture();
        }

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(TRenderTypes.getTardis(texture));
        MODEL.render(tile, 0.25F, matrixStack, ivertexbuilder, i, i1, v1);
        matrixStack.popPose();
    }
}
