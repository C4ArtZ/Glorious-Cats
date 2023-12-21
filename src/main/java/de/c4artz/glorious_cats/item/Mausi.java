package de.c4artz.glorious_cats.item;

import de.c4artz.glorious_cats.GloriousCats;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Mausi extends Item {

	public Mausi(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

//		user.getItemCooldownManager().getCooldownProgress(this,2);

		if (hand == Hand.MAIN_HAND)
		{
			user.playSound(SoundEvents.ENTITY_SILVERFISH_HURT);
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600,1)); // duration is in ticks
		}

		return TypedActionResult.success(user.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("tooltip." + GloriousCats.modContainer.metadata().id() + ".mausi"));
	}
}
