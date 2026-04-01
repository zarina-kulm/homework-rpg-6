package com.narxoz.rpg.command;
import com.narxoz.rpg.arena.ArenaFighter;
public class HealCommand implements ActionCommand {
    private final ArenaFighter target;
    private final int healAmount;
    private int actualHealApplied;
    public HealCommand(ArenaFighter target, int healAmount) {
        this.target = target;
        this.healAmount = healAmount;
    }
    @Override
    public void execute() {
        if (target.getHealPotions() > 0) {
            actualHealApplied = target.heal(healAmount);
            System.out.println("[Heal] Restored " + actualHealApplied + " HP");
        } else {
            actualHealApplied = 0;
            System.out.println("[Heal] No potions left!");
        }
    }
    @Override
    public void undo() {
        if (actualHealApplied > 0) {
            target.takeDamage(actualHealApplied);
            System.out.println("[Undo Heal] Removed " + actualHealApplied + " HP");
        }
    }
    @Override
    public String getDescription() {
        return "Heal for " + healAmount + " HP";
    }
}
