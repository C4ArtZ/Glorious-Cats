package de.c4artz.glorious_cats.entity.client;

import de.c4artz.glorious_cats.GloriousCats;
import de.c4artz.glorious_cats.GloriousCatsClient;
import de.c4artz.glorious_cats.entity.custom.OpossumEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class OpossumRenderer extends MobEntityRenderer<OpossumEntity, OpossumModel<OpossumEntity>> {

	private static final Identifier TEXTURE = new Identifier(GloriousCats.modContainer.metadata().id(), "textures/entity/opossum.png");

	public OpossumRenderer(EntityRendererFactory.Context context) {
		super(context, new OpossumModel<>(context.getPart(ModModelLayers.OPOSSUM)),0.3f);
	}

	@Override
	public Identifier getTexture(OpossumEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(OpossumEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		if (mobEntity.isBaby()) {
			matrixStack.scale(0.5f,0.5f,0.5f);
		} else {
			matrixStack.scale(1f,1f,1f);
		}
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}
