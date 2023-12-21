package de.c4artz.glorious_cats.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FurSword extends SwordItem {
	public FurSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		if (!target.getWorld().isClient) {

			target.getWorld().createExplosion(target, target.getX(), target.getBodyY(0.0625), target.getZ(), 10.0F, World.ExplosionSourceType.MOB);

//			TntEntity tntEntity = new TntEntity(target.getWorld(), (double)target.getX() + 0.5, (double)target.getY(), (double)target.getZ() + 0.5, attacker);
//			tntEntity.setFuse(0);
//			target.getWorld().spawnEntity(tntEntity);
//			target.getWorld().emitGameEvent(attacker, GameEvent.PRIME_FUSE, target.getPos());
		}

//		Explosion explosion = new Explosion(target.getWorld(),target,target.getX(),target.getY(),target.getZ(),10,)

		// normal Minecraft item durability stuff
		stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.of("Why is this so strong??"));
	}
}
