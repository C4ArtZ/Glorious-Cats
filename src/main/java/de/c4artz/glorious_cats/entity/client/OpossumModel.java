package de.c4artz.glorious_cats.entity.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import de.c4artz.glorious_cats.entity.custom.OpossumEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class OpossumModel <T extends OpossumEntity> extends SinglePartEntityModel<T> {
	private final ModelPart opossum;
	private final ModelPart head;
	public OpossumModel(ModelPart root) {
		this.opossum = root.getChild("opossum");
		this.head = opossum.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData opossum = modelPartData.addChild("opossum", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 23.75F, 0.0F));

		ModelPartData head = opossum.addChild("head", ModelPartBuilder.create().uv(16, 11).cuboid(-1.0F, -4.0F, -4.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
			.uv(0, 11).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData ear_r1 = head.addChild("ear_r1", ModelPartBuilder.create().uv(3, 0).cuboid(-0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -5.25F, -3.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData ear_r2 = head.addChild("ear_r2", ModelPartBuilder.create().uv(3, 3).cuboid(-0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -5.25F, -3.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData body = opossum.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -4.0F, -5.0F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, 2.0F));

		ModelPartData tail = opossum.addChild("tail", ModelPartBuilder.create().uv(10, 13).cuboid(0.0F, -2.0F, 5.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData front_left_leg = opossum.addChild("front_left_leg", ModelPartBuilder.create().uv(0, 0).cuboid(2.0625F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -1.0F));

		ModelPartData front_right_leg = opossum.addChild("front_right_leg", ModelPartBuilder.create().uv(10, 11).cuboid(-2.0625F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -1.0F));

		ModelPartData rear_left_leg = opossum.addChild("rear_left_leg", ModelPartBuilder.create().uv(0, 3).cuboid(2.0F, -2.0F, 3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0625F, 0.25F, -1.0F));

		ModelPartData rear_right_leg = opossum.addChild("rear_right_leg", ModelPartBuilder.create().uv(0, 11).cuboid(-2.0625F, -3.0F, 3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.25F, -1.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(OpossumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		opossum.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return opossum;
	}
}
