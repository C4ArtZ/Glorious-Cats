package de.c4artz.glorious_cats.block;

import de.c4artz.glorious_cats.GloriousCats;
import de.c4artz.glorious_cats.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {

//	public static final Block FUR_BLOCK = registerBlock("fur_block",
//		new Block(QuiltBlockSettings.create());
//
//
//	private static Block registerBlock(String name, Block block) {
//		registerBlockItem(name, block);
//		return Registry.register(Registries.BLOCK, new Identifier(GloriousCats.modContainer.metadata().id(), name), block);
//	}
//
//	private static Item registerBlockItem(String name, Block block) {
//		Item item = Registry.register(Registries.ITEM, new Identifier(GloriousCats.modContainer.metadata().id(), name),
//			new BlockItem(block, new QuiltItemSettings()));
//
//		ItemGroupEvents.modifyEntriesEvent(ModItems.MAIN_ITEM_GROUP).register(entries -> {
//			entries.addItem(item);
//		});
//
//		return item;
//	}
//
//	public static void registerModBlocks() {
//		GloriousCats.LOGGER.debug("Registering Mod Blocks for Glorious Cats");
//	}


	public static final Block FUR_BLOCK = new Block(QuiltBlockSettings.create());
	public static final Block OLIVIA = new Olivia(QuiltBlockSettings.create().nonOpaque());


	public static void registerModBlocks() {
		GloriousCats.LOGGER.debug("Registering Mod Blocks for Glorious Cats");

		Registry.register(Registries.BLOCK, new Identifier(GloriousCats.modContainer.metadata().id(), "fur_block"), FUR_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(GloriousCats.modContainer.metadata().id(), "fur_block"), new BlockItem(FUR_BLOCK, new QuiltItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(GloriousCats.modContainer.metadata().id(), "olivia"), OLIVIA);
		Registry.register(Registries.ITEM, new Identifier(GloriousCats.modContainer.metadata().id(), "olivia"), new BlockItem(OLIVIA, new QuiltItemSettings()));

		ItemGroupEvents.modifyEntriesEvent(ModItems.MAIN_ITEM_GROUP).register(entries -> {
			entries.addItem(FUR_BLOCK.asItem());
			entries.addItem(OLIVIA.asItem());

			// https://modder.wiki.quiltmc.org/blocks/first-block#adding-a-model-for-the-block
		});
	}

}
