package hellfirepvp.astralsorcery.common.constellation.perk.impl;

import hellfirepvp.astralsorcery.common.constellation.perk.ConstellationPerk;
import hellfirepvp.astralsorcery.common.registry.RegistryPotions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.config.Configuration;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: PerkDamageBleed
 * Created by HellFirePvP
 * Date: 04.12.2016 / 17:49
 */
public class PerkDamageBleed extends ConstellationPerk {

    private static int amplifierApplied = 1;
    private static int durationApplied = 80;

    public PerkDamageBleed() {
        super("DMG_BLEED", Target.ENTITY_ATTACK);
    }

    @Override
    public float onEntityAttack(EntityPlayer attacker, EntityLivingBase attacked, float dmgIn) {
        attacked.addPotionEffect(new PotionEffect(RegistryPotions.potionBleed, durationApplied, amplifierApplied, false, true));
        return dmgIn;
    }

    @Override
    public boolean hasConfigEntries() {
        return true;
    }

    @Override
    public void loadFromConfig(Configuration cfg) {
        amplifierApplied = cfg.getInt(getKey() + "BleedAmplifier", getConfigurationSection(), 1, 0, 40, "Defines the PotionEffect amplifier of the bleed applied.");
        durationApplied = cfg.getInt(getKey() + "BleedTickDuration", getConfigurationSection(), 80, 1, 600, "Defines the PotionEffect duration of the bleed applied");
    }

}
