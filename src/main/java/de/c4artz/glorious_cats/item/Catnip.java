package de.c4artz.glorious_cats.item;

import de.c4artz.glorious_cats.GloriousCats;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Catnip extends Item {

	public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder()
		.hunger(2)
		.saturationModifier(0.3F)
		.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 15), 1.0F)
		.alwaysEdible()
		.build();


	public Catnip(Settings settings) {
		super(settings);
	}

//	@Override
//	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//		tooltip.add(Text.translatable("tooltip." + GloriousCats.modContainer.metadata().id() + ".catnip"));
//	}
}
