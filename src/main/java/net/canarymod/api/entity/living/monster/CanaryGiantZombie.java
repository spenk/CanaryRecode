package net.canarymod.api.entity.living.monster;

import net.canarymod.api.entity.EntityType;
import net.minecraft.server.EntityGiantZombie;

/**
 * GiantZombie wrapper implementation
 * 
 * @author Jason (darkdiplomat)
 */
public class CanaryGiantZombie extends CanaryEntityMob implements GiantZombie {

    /**
     * Constructs a new wrapper for EntityGiantZombie
     * 
     * @param entity
     *            the EntityGiantZombie to wrap
     */
    public CanaryGiantZombie(EntityGiantZombie entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getEntityType() {
        return EntityType.GIANTZOMBIE;
    }

    @Override
    public String getFqName() {
        return "GiantZombie";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityGiantZombie getHandle() {
        return (EntityGiantZombie) entity;
    }
}
