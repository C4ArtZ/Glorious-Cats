package de.c4artz.glorious_cats.item;

import de.c4artz.glorious_cats.GloriousCats;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item MAUSI = registerItem("mausi", new Mausi(new QuiltItemSettings().maxCount(1)));
	public static final Item FURSWORD = registerItem("fur_sword", new FurSword(ToolMaterials.DIAMOND, 7, 1.6f, new QuiltItemSettings().maxCount(1)));
	public static final Item CATNIP = registerItem("catnip", new Catnip(new QuiltItemSettings().food(Catnip.FOOD_COMPONENT)));
	public static final Item CHICKENWING = registerItem("chicken_wing", new ChickenWing(new QuiltItemSettings().food(FoodComponents.CHICKEN)));
	public static final Item COOCKEDCHICKENWING = registerItem("cooked_chicken_wing", new CookedChickenWing(new QuiltItemSettings().food(FoodComponents.COOKED_CHICKEN)));

	public static final RegistryKey<ItemGroup> MAIN_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("c4artz_mod","glorious_cats_item_group"));

	public static Item registerItem(String name, Item item)
	{
		return Registry.register(Registries.ITEM, new Identifier(GloriousCats.modContainer.metadata().id(), name), item);
	}


	public static void registerModItems() {
		GloriousCats.LOGGER.debug("Registering Mod Items for Glorious Cats");

		Registry.register(Registries.ITEM_GROUP, MAIN_ITEM_GROUP, FabricItemGroup.builder()
			.name(Text.translatable("itemgroup." + GloriousCats.modContainer.metadata().id() + ".main"))
			.icon(() -> new ItemStack(FURSWORD))
			.build()
		);

		ItemGroupEvents.modifyEntriesEvent(MAIN_ITEM_GROUP).register(entries -> {
			entries.addItem(MAUSI);
			entries.addItem(FURSWORD);
			entries.addItem(CATNIP);
			entries.addItem(CHICKENWING);
			entries.addItem(COOCKEDCHICKENWING);
		});
	}



}
