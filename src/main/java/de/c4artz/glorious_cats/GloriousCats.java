package de.c4artz.glorious_cats;

import de.c4artz.glorious_cats.block.ModBlocks;
import de.c4artz.glorious_cats.entity.ModEntities;
import de.c4artz.glorious_cats.entity.custom.OpossumEntity;
import de.c4artz.glorious_cats.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GloriousCats implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Glorious Cats");
	public static ModContainer modContainer;


	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		modContainer = mod;

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.Opossum, OpossumEntity.createOpossumAttributes());

	}
}
