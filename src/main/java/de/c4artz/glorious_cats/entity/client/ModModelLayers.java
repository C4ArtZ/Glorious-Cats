package de.c4artz.glorious_cats.entity.client;

import de.c4artz.glorious_cats.GloriousCats;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
	public static final EntityModelLayer OPOSSUM = new EntityModelLayer(new Identifier(GloriousCats.modContainer.metadata().id(), "opossum"), "main");
}
