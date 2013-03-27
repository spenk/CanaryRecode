package net.canarymod.api.world.blocks;


import net.canarymod.api.entity.Entity;
import net.canarymod.api.inventory.CanaryItem;
import net.canarymod.api.inventory.Container;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.CanaryWorld;
import net.minecraft.server.ItemStack;
import net.minecraft.server.TileEntityDispenser;


public class CanaryDispenser extends CanaryComplexBlock implements Dispenser, Container<Item> {
    // private Random random = new Random();

    public CanaryDispenser(TileEntityDispenser tileentity) {
        super(tileentity);
    }

    @Override
    public Inventory getInventory() {
        return getHandle().getInventory();
    }

    @Override
    public Entity activate() {
        return dispense(null);
    }

    @Override
    public Entity dispenseFromSlot(int slot) {
        ItemStack stack = getHandle().getSlot(slot);

        if (stack != null) {
            return dispense(stack);
        } else {
            ((CanaryWorld) getWorld()).getHandle().e(1001, this.getX(), this.getY(), this.getZ(), 0);
        }
        return null;
    }

    private Entity dispense(ItemStack item) {
        // Um... hmmmm...
        return null;
    }

    @Override
    public void clearContents() {
        getHandle().clearContents();
    }

    @Override
    public CanaryItem decreaseItemStackSize(int itemId, int amount) {
        ItemStack item = getHandle().decreaseItemStackSize(itemId, amount);

        return item != null ? item.getCanaryItem() : null;
    }

    @Override
    public CanaryItem[] getContents() {
        ItemStack[] oStacks = getHandle().getContents();
        CanaryItem[] items = new CanaryItem[oStacks.length];

        for (int i = 0; i < oStacks.length; i++) {
            items[i] = new CanaryItem(oStacks[i]);
        }

        return items;
    }

    @Override
    public String getInventoryName() {
        return getHandle().getInventoryName();
    }

    @Override
    public int getInventorySize() {
        return getHandle().getInventorySize();
    }

    @Override
    public int getInventoryStackLimit() {
        return getHandle().getInventoryStackLimit();
    }

    @Override
    public Item getItem(int id) {
        return getHandle().getItem(id);
    }

    @Override
    public Item getItem(int id, int amount) {
        return getHandle().getItem(id, amount);
    }

    @Override
    public Item getSlot(int index) {
        ItemStack item = getHandle().getSlot(index);

        return item != null ? item.getCanaryItem() : null;
    }

    @Override
    public boolean hasItem(int itemId) {
        return getHandle().hasItem(itemId);
    }

    @Override
    public boolean hasItemStack(Item item) {
        return getHandle().hasItemStack(((CanaryItem) item).getHandle());
    }

    @Override
    public Item removeItem(Item item) {
        return getHandle().removeItem(item);
    }

    @Override
    public Item removeItem(int id) {
        return getHandle().removeItem(id);
    }

    @Override
    public void setContents(Item[] items) {
        ItemStack[] oStacks = new ItemStack[items.length];

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                oStacks[i] = ((CanaryItem) items[i]).getHandle();
            } else {
                oStacks[i] = null;
            }
        }
        getHandle().setContents(oStacks);
    }

    @Override
    public void setInventoryName(String value) {
        getHandle().setInventoryName(value);
    }

    @Override
    public void setSlot(int index, Item value) {
        getHandle().setSlot(index, ((CanaryItem) value).getHandle());
    }

    @Override
    public void addItem(int itemId, int amount) {
        getHandle().addItem(itemId, amount);
    }

    @Override
    public void addItem(Item item) {
        getHandle().addItem(item);
    }

    @Override
    public int getEmptySlot() {
        return getHandle().getEmptySlot();
    }

    @Override
    public boolean hasItemStack(int itemId, int amount) {
        return getHandle().hasItemStack(itemId, amount);
    }

    @Override
    public boolean hasItemStack(int itemId, int minAmount, int maxAmount) {
        return getHandle().hasItemStack(itemId, minAmount, maxAmount);
    }

    @Override
    public TileEntityDispenser getHandle() {
        return (TileEntityDispenser) tileentity;
    }
}
