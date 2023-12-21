package de.c4artz.glorious_cats.entity;

import de.c4artz.glorious_cats.GloriousCats;
import de.c4artz.glorious_cats.GloriousCatsClient;
import de.c4artz.glorious_cats.entity.custom.OpossumEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class ModEntities {
	public static final EntityType<OpossumEntity> Opossum = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(GloriousCats.modContainer.metadata().id(), "opossum"),
		QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, OpossumEntity::new).setDimensions(EntityDimensions.fixed(1f,1f)).build());

	public static void registerModEntities() {
		GloriousCats.LOGGER.info("Registering Entities for Glorious Cats");
	}
}


