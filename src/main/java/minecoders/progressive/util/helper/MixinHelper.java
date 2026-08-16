package minecoders.progressive.util.helper;

import minecoders.progressive.access.MovingPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.function.DoubleUnaryOperator;

@SuppressWarnings("unused")
public class MixinHelper {
    public static final float EPSILON = 0.001F;

    public static Entity asEntity(Object object) {
        return (Entity) object;
    }

    public static LivingEntity asLivingEntity(Object object) {
        return (LivingEntity) object;
    }

    public static ItemStack asItemStack(Object object) {
        return (ItemStack) object;
    }

    public static boolean isEntityMoving(Entity entity) {
        if (entity instanceof MobEntity mob)
            return !mob.getNavigation().isIdle() || mob.getMoveControl().isMoving();
        else if (entity instanceof PlayerEntity player)
            return ((MovingPlayer) player).progressive$isMoving();

        return false;
    }

    public static class Reference<T> {
        @Nullable
        public T value;

        public Reference() {
            this(null);
        }

        public Reference(@Nullable T value) {
            this.value = value;
        }
    }

    public static class DoubleReference {
        private double value;
        private boolean initialized = false;

        public DoubleReference() {}

        public DoubleReference(double value) {
            this.initialized = true;
            this.value = value;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public double get() {
            return this.value;
        }

        public void set(double value) {
            this.initialized = true;
            this.value = value;
        }
    }

    public static class FloatReference {
        private float value;
        private boolean initialized = false;

        public FloatReference() {}

        public FloatReference(float value) {
            this.initialized = true;
            this.value = value;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public float get() {
            return this.value;
        }

        public void set(float value) {
            this.initialized = true;
            this.value = value;
        }
    }

    public static class IntReference {
        private int value;
        private boolean initialized = false;

        public IntReference() {}

        public IntReference(int value) {
            this.initialized = true;
            this.value = value;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public int get() {
            return this.value;
        }

        public void set(int value) {
            this.initialized = true;
            this.value = value;
        }
    }
}
