package com.supernova.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.supernova.block.ShipBlockEntity;
import com.supernova.entity.ShipEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;

/** La nave colocada sobre la base se dibuja grande (escala x2). */
public class ShipBlockRenderer implements BlockEntityRenderer<ShipBlockEntity> {
    public ShipBlockRenderer(BlockEntityRendererProvider.Context ctx) { }

    @Override
    public void render(ShipBlockEntity be, float pt, PoseStack ps, MultiBufferSource buf, int light, int overlay) {
        ps.pushPose();
        ps.translate(0.5, 0, 0.5);
        ps.scale(ShipEntity.SCALE, ShipEntity.SCALE, ShipEntity.SCALE);
        ps.translate(-0.5, 0, -0.5);
        ShipModelRenderer.render(ps, buf, light, OverlayTexture.NO_OVERLAY);
        ps.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(ShipBlockEntity be) {
        return true;
    }
}
