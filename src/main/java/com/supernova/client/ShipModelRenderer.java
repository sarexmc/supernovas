package com.supernova.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.supernova.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.BlockState;

/** Dibuja el modelo grande de la nave (el del bloque Nave) para el bloque y para la entidad en vuelo. */
public class ShipModelRenderer {
    public static void render(PoseStack ps, MultiBufferSource buf, int light, int overlay) {
        Minecraft mc = Minecraft.getInstance();
        BlockState state = ModBlocks.SHIP.defaultBlockState();
        BakedModel model = mc.getBlockRenderer().getBlockModelShaper().getBlockModel(state);
        VertexConsumer vc = buf.getBuffer(RenderType.cutout());
        mc.getBlockRenderer().getModelRenderer().renderModel(ps.last(), vc, state, model, 1f, 1f, 1f, light, overlay);
    }
}
