package de.c4artz.glorious_cats;


import de.c4artz.glorious_cats.entity.ModEntities;
import de.c4artz.glorious_cats.entity.client.ModModelLayers;
import de.c4artz.glorious_cats.entity.client.OpossumModel;
import de.c4artz.glorious_cats.entity.client.OpossumRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class GloriousCatsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		GloriousCats.LOGGER.debug("Cheese");

		EntityRendererRegistry.register(ModEntities.Opossum, OpossumRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.OPOSSUM, OpossumModel::getTexturedModelData);
	}
}
